package br.com.budgetboys.pf_finance_service.adapters.outbound.service.expense;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseRepository;

@Service
public class ExpenseService {
    
    private final ExpenseRepository expenseRepository;

    public ExpenseService (ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public Expense saveExpense(Expense expense){

        return expenseRepository.save(expense);
    }

    public Expense findExpenseById(UUID id){
        return expenseRepository.findById(id);
    }

    public List<Expense> getAllExpress(){
       return expenseRepository.findAll(); 
    }
}
