package br.com.budgetboys.pf_finance_service.adapters.inbound.controller.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.service.expense.ExpenseService;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ExpenseCreateDTO expenseCreateDTO) {
        try {
            ExpenseResponseDTO savedExpense = this.expenseService.saveExpense(expenseCreateDTO);
            return ResponseEntity.ok(savedExpense);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
