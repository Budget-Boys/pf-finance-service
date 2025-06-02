package br.com.budgetboys.pf_finance_service.domain.expense;

import java.util.List;
import java.util.UUID;

public interface ExpenseRepository {
    Expense save(Expense expense);
    Expense findById(UUID id);
    List<Expense> findAll();
    void delete(Expense expense);
}
