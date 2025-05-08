package br.com.budgetboys.pf_finance_service.adapters.outbound.Service.expense;

import org.springframework.stereotype.Service;

import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseRepository;

@Service
public class ExpenseService {
    
    private final ExpenseRepository expenseRepository;

    public ExpenseService (ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }
}
