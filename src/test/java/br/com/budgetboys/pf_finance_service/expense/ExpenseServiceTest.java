package br.com.budgetboys.pf_finance_service.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.ExpenseCategory;
import br.com.budgetboys.pf_finance_service.adapters.outbound.service.expense.ExpenseService;
import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseRepository;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseResponseDTO;
import br.com.budgetboys.pf_finance_service.utils.mappers.ExpenseMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private ExpenseMapper expenseMapper;

    @InjectMocks
    private ExpenseService expenseService;

    private Expense expense;
    private ExpenseCreateDTO expenseCreateDTO;
    private ExpenseResponseDTO expenseResponseDTO;
    private UUID expenseId;

    @BeforeEach
    void setUp() {
        expenseId = UUID.randomUUID();

        expenseCreateDTO = new ExpenseCreateDTO(100.0, ExpenseCategory.FUEL, UUID.randomUUID());

        expense = new Expense();

        expense.setId(expenseId);
        expense.setCategory(expenseCreateDTO.getCategory());
        expense.setAmount(expenseCreateDTO.getAmount());
        expense.setUserId(expenseCreateDTO.getUserId());
    }

}
