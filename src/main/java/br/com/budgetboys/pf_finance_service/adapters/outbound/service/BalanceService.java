package br.com.budgetboys.pf_finance_service.adapters.outbound.service;

import br.com.budgetboys.pf_finance_service.domain.BalanceSheetResponseDTO;
import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseRepository;
import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BalanceService {

    private final ExpenseRepository expenseRepository;

    private final IncomeRepository incomeRepository;

    @Autowired
    public BalanceService(ExpenseRepository expenseRepository, IncomeRepository incomeRepository) {
        this.expenseRepository = expenseRepository;
        this.incomeRepository = incomeRepository;
    }

    public BalanceSheetResponseDTO getBalanceSheet(UUID userId) {
        BalanceSheetResponseDTO balanceSheetResponseDTO = new BalanceSheetResponseDTO();

        double expensesAmountTotal = expenseRepository.findAllByUserId(userId).stream().map(Expense::getAmount).count();
        double incomesAmountTotal = incomeRepository.findAllByUserId(userId).stream().map(Income::getAmount).count();

        balanceSheetResponseDTO.setExpensesAmountTotal(expensesAmountTotal);
        balanceSheetResponseDTO.setIncomesAmountTotal(incomesAmountTotal);

        double balance = incomesAmountTotal - expensesAmountTotal;

        balanceSheetResponseDTO.setBalance(Math.abs(balance));

        if (balance < 0) {
            balanceSheetResponseDTO.setStatus("NEGATIVE");
        } else {
            balanceSheetResponseDTO.setStatus("POSITIVE");
        }

        return balanceSheetResponseDTO;
    }
}
