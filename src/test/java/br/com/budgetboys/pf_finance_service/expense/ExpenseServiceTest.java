package br.com.budgetboys.pf_finance_service.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.ExpenseCategory;
import br.com.budgetboys.pf_finance_service.adapters.outbound.service.expense.ExpenseService;
import br.com.budgetboys.pf_finance_service.domain.expense.*;
import br.com.budgetboys.pf_finance_service.utils.mappers.ExpenseMapper;
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
class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private ExpenseMapper expenseMapper;

    @InjectMocks
    private ExpenseService expenseService;

    private Expense expense;
    private ExpenseCreateDTO createDTO;
    private ExpenseResponseDTO responseDTO;
    private UUID expenseId;
    private UUID userId;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
        expenseId = UUID.randomUUID();

        createDTO = new ExpenseCreateDTO(100.0, ExpenseCategory.FUEL, userId);

        expense = new Expense();
        expense.setId(expenseId);
        expense.setAmount(createDTO.getAmount());
        expense.setCategory(createDTO.getCategory());
        expense.setUserId(createDTO.getUserId());

        responseDTO = new ExpenseResponseDTO();
        responseDTO.setId(expenseId);
        responseDTO.setAmount(expense.getAmount());
        responseDTO.setCategory(expense.getCategory());
        responseDTO.setUserId(expense.getUserId());
    }

    @Test
    void shouldSaveExpense() {
        when(expenseMapper.requestToEntity(createDTO)).thenReturn(expense);
        when(expenseRepository.save(expense)).thenReturn(expense);
        when(expenseMapper.entityToResponse(expense)).thenReturn(responseDTO);

        ExpenseResponseDTO result = expenseService.saveExpense(createDTO);

            assertNotNull(result, "Response should not be null");
            assertEquals(responseDTO.getId(), result.getId(), "Response should have same id");
            assertEquals(responseDTO.getAmount(), result.getAmount(),  "Response should have same amount");
            verify(expenseRepository).save(expense);
            verify(expenseMapper).requestToEntity(createDTO);
            verify(expenseMapper).entityToResponse(expense);
    }

    @Test
    void shouldThrowWhenAmountIsNegative(){
        ExpenseCreateDTO invalidDTO = new ExpenseCreateDTO(-100.0, ExpenseCategory.FUEL, userId);

        assertThrows(IllegalArgumentException.class, () -> expenseService.saveExpense(invalidDTO), "Expense amount should not be negative");
        verify(expenseRepository, never()).save(expense);
    }

    @Test
    void shouldFindExpenseById(){
        when(expenseRepository.findById(expenseId)).thenReturn(expense);
        when(expenseMapper.entityToResponse(expense)).thenReturn(responseDTO);

        ExpenseResponseDTO result = expenseService.findExpenseById(expenseId);

        assertNotNull(result, "Response should not be null");
        assertEquals(expenseId, result.getId(), "Expense Id should match");
        verify(expenseRepository).findById(expenseId);
        verify(expenseMapper).entityToResponse(expense);
    }

    @Test
    void shouldThrownWhenExpenseNotFound() {
        when(expenseRepository.findById(expenseId)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> expenseService.findExpenseById(expenseId));
        verify(expenseRepository).findById(expenseId);
        verifyNoMoreInteractions(expenseMapper);
    }

    @Test
    void shouldFindAllExpenses(){
        List<Expense> expenses = List.of(expense);
        List<Expense> expectedExpenses = List.of(expense);

        when(expenseRepository.findAll()).thenReturn(expenses);
        when(expenseMapper.entityToResponse(expense)).thenReturn(responseDTO);

        List<ExpenseResponseDTO> result = expenseService.findAll();

        assertEquals(expectedExpenses.size(), result.size(), "Expenses should match");
        assertEquals(expectedExpenses.getFirst().getId(), result.getFirst().getId(), "Expenses should match");

        verify(expenseRepository).findAll();
        verify(expenseMapper).entityToResponse(expense);
    }
}
