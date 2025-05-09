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
        if(expense.getAmount() < 0){
            throw new IllegalArgumentException("The expense amount cannot be negative");
        }
        return expenseRepository.save(expense);
    }

    public Expense findExpenseById(UUID id){
        Expense expense = expenseRepository.findById(id);
        if(expense == null) {
            throw new IllegalArgumentException("Expense Id: "+id+ " not found");
        }
        return expense;                       
    }

    public List<Expense> getAllExpenses(){
       return expenseRepository.findAll(); 
    }

    public void deleteExpense(UUID id){
        expenseRepository.deleteById(id);
    }
}
