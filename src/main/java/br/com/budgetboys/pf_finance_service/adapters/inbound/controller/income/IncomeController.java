package br.com.budgetboys.pf_finance_service.adapters.inbound.controller.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.service.income.IncomeService;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("incomes")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody IncomeCreateDTO income) {
        try {
            IncomeResponseDTO savedIncome = this.incomeService.saveIncome(income);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedIncome);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        try {
            IncomeResponseDTO incomeResponse = this.incomeService.findIncomeById(id);
            return ResponseEntity.ok(incomeResponse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<IncomeResponseDTO>> findAll() {
        return ResponseEntity.ok().body(this.incomeService.findAllIncomes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable UUID id) {
        try {
            this.incomeService.deleteIncome(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/by-user/{id}")
    public ResponseEntity<List<IncomeResponseDTO>> findAllByUserId(@PathVariable("id") UUID userId) {
        return ResponseEntity.ok().body(this.incomeService.findAllByUserId(userId));
    }
}
