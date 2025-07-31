package br.com.budgetboys.pf_finance_service.adapters.inbound.controller;

import br.com.budgetboys.pf_finance_service.adapters.outbound.service.BalanceService;
import br.com.budgetboys.pf_finance_service.domain.BalanceSheetResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("balance")
public class BalanceSheetController {

    private final BalanceService balanceService;

    public BalanceSheetController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BalanceSheetResponseDTO> getBalanceSheet(@PathVariable("id") UUID userId) {
        return ResponseEntity.ok(this.balanceService.getBalanceSheet(userId));
    }
}
