package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAExpenseEntity;
import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseRepository;
import br.com.budgetboys.pf_finance_service.utils.mappers.ExpenseMapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final JPAExpenseRepository jpaExpenseRepository;

    private final ExpenseMapper expenseMapper;

    public ExpenseRepositoryImpl(JPAExpenseRepository jpaExpenseRepository, ExpenseMapper expenseMapper) {
        this.jpaExpenseRepository = jpaExpenseRepository;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public Expense save(Expense expense) {
        JPAExpenseEntity expenseEntity = expenseMapper.expenseToJpa(expense);
        JPAExpenseEntity savedEntity = jpaExpenseRepository.save(expenseEntity);
        return expenseMapper.jpaToExpense(savedEntity);
    }

    @Override
    public Expense findById(UUID id) {
        return null;
    }

    @Override
    public List<Expense> findAll() {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
