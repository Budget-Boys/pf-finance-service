package br.com.budgetboys.pf_finance_service.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.IncomeCategory;
import br.com.budgetboys.pf_finance_service.adapters.outbound.service.income.IncomeService;
import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseResponseDTO;
import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeRepository;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeResponseDTO;
import br.com.budgetboys.pf_finance_service.utils.mappers.IncomeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IncomeServiceTest {

    @Mock
    private IncomeRepository incomeRepository;

    @Mock
    private IncomeMapper incomeMapper;

    @InjectMocks
    private IncomeService incomeService;

    private Income income;
    private IncomeCreateDTO createDTO;
    private IncomeResponseDTO responseDTO;
    private UUID incomeId;
    private UUID userId;

    @BeforeEach
    void setUp(){
        userId = UUID.randomUUID();
        incomeId = UUID.randomUUID();

        createDTO = new IncomeCreateDTO(100.0, IncomeCategory.FREELANCE, userId);

        income = new Income();
        income.setId(incomeId);
        income.setUserId(createDTO.getUserId());
        income.setAmount(createDTO.getAmount());
        income.setCategory(createDTO.getCategory());

        responseDTO = new IncomeResponseDTO();
        responseDTO.setId(income.getId());
        responseDTO.setAmount(income.getAmount());
        responseDTO.setCategory(income.getCategory());
        responseDTO.setUserId(income.getUserId());
    }

    @Test
    void shouldSaveIncome(){
        when(incomeMapper.requestToEntity(createDTO)).thenReturn(income);
        when(incomeRepository.save(income)).thenReturn(income);
        when(incomeMapper.entityToResponse(income)).thenReturn(responseDTO);

        IncomeResponseDTO result = incomeService.saveIncome(createDTO);

        assertNotNull(result, "Response should not be null");
        assertEquals(responseDTO.getId(), result.getId(), "Response should have same id");
        assertEquals(responseDTO.getAmount(), result.getAmount(), "Response should have same amount");
        assertEquals(responseDTO.getCategory(), result.getCategory(), "Response should have same category");
        assertEquals(responseDTO.getUserId(), result.getUserId(), "Response should have same user id");

        verify(incomeRepository).save(income);
        verify(incomeMapper).requestToEntity(createDTO);
        verify(incomeMapper).entityToResponse(income);
    }

    @Test
    void shouldThrowWhenAmountIsNegative(){
        IncomeCreateDTO invalidDTO = new IncomeCreateDTO(-100.0, IncomeCategory.FREELANCE, userId);

        assertThrows(IllegalArgumentException.class, () -> incomeService.saveIncome(invalidDTO));
        verify(incomeRepository, never()).save(income);
    }

    @Test
    void shouldThrowWhenIncomeNotFound(){
        when(incomeRepository.findById(incomeId)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> incomeService.findIncomeById(incomeId));
        verify(incomeRepository, never()).findById(incomeId);
        verifyNoMoreInteractions(incomeMapper);
    }

    @Test
    void shouldFindAllIncomes(){
        List<Income> incomes = List.of(income);
        List<Income> expectedIncomes = List.of(income);

        when(incomeRepository.findAll()).thenReturn(incomes);
        when(incomeMapper.entityToResponse(income)).thenReturn(responseDTO);

        List<IncomeResponseDTO> result = incomeService.findAllIncomes();

        assertEquals(expectedIncomes.size(), result.size(), "Incomes should match");
        assertEquals(expectedIncomes.getFirst().getId(), result.getFirst().getId(), "Incomes should match");

        verify(incomeRepository).findAll();
        verify(incomeMapper).entityToResponse(income);
    }
}
