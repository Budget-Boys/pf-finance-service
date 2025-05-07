package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.expense;

import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseRepository;

import java.util.List;
import java.util.UUID;

public class ExpenseRepositoryImpl implements ExpenseRepository {
    @Override
    public Expense save(Expense expense) {
        return null;
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
