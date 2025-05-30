package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAExpenseEntity;
import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseRepository;
import br.com.budgetboys.pf_finance_service.utils.mappers.ExpenseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final JPAExpenseRepository jpaExpenseRepository;

    @Autowired
    private final ExpenseMapper expenseMapper;

    public ExpenseRepositoryImpl(JPAExpenseRepository jpaExpenseRepository, ExpenseMapper expenseMapper) {
        this.jpaExpenseRepository = jpaExpenseRepository;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public Expense save(Expense expense) {
        JPAExpenseEntity expenseEntity = this.expenseMapper.expenseToJpa(expense);
        JPAExpenseEntity savedEntity = this.jpaExpenseRepository.save(expenseEntity);

        return this.expenseMapper.jpaToEntity(savedEntity);
    }

    @Override
    public Expense findById(UUID id) {
        return jpaExpenseRepository.findById(id)
            .map(expenseMapper::jpaToEntity)
            .orElse(null);
    }

    @Override
    public List<Expense> findAll() {
        return this.jpaExpenseRepository.findAll().stream().map(expenseMapper::jpaToEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Expense expense) {
        JPAExpenseEntity jpaExpenseEntity = this.expenseMapper.expenseToJpa(expense);
        this.jpaExpenseRepository.delete(jpaExpenseEntity);
    }
}
