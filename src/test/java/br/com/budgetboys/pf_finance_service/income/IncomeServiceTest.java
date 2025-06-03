package br.com.budgetboys.pf_finance_service.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.service.income.IncomeService;
import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeRepository;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeResponseDTO;
import br.com.budgetboys.pf_finance_service.utils.mappers.IncomeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

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

        createDTO = new IncomeCreateDTO();

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
}
