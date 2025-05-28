package br.com.budgetboys.pf_finance_service.adapters.outbound.service.expense;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseResponseDTO;
import br.com.budgetboys.pf_finance_service.utils.mappers.ExpenseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseMapper expenseMapper;

    public ExpenseService (ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public ExpenseResponseDTO saveExpense(Expense expense){
        if(expense.getAmount() < 0){
            throw new IllegalArgumentException("The expense amount cannot be negative");
        }

        Expense expenseEntity = this.expenseRepository.save(expense);

        return this.expenseMapper.entityToResponse(expenseEntity);
    }

    public ExpenseResponseDTO findExpenseById(UUID id){
        Expense expense = this.expenseRepository.findById(id);
        if(expense == null) {
            throw new IllegalArgumentException("Expense Id: "+id+ " not found");
        }
        return this.expenseMapper.entityToResponse(expense);
    }x''

    public List<ExpenseResponseDTO> getAllExpenses(){
       return this.expenseRepository.findAll().stream().map(this.expenseMapper::entityToResponse).collect(Collectors.toList());
    }

    public void deleteExpense(UUID id){
        this.expenseRepository.deleteById(id);
    }
}
