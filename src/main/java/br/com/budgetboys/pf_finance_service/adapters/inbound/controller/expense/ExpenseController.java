package br.com.budgetboys.pf_finance_service.adapters.inbound.controller.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.service.expense.ExpenseService;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
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

    @GetMapping("find")
    public ResponseEntity<?> find(@RequestParam UUID id) {
        try {
            ExpenseResponseDTO expense = this.expenseService.findExpenseById(id);
            return ResponseEntity.ok(expense);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("findall")
    public ResponseEntity<List<ExpenseResponseDTO>> findAll() {
        return ResponseEntity.ok(this.expenseService.findAll());
    }

    @DeleteMapping("delete")
    public void delete(UUID id){
        this.expenseService.deleteExpense(id);
    }
}
