package br.com.budgetboys.pf_finance_service.domain.user;

import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.income.Income;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private Income[] incomes;
    private Expense[] expenses;

    public User(UUID id, String name, Income[] incomes, Expense[] expenses) {
        this.id = id;
        this.name = name;
        this.incomes = incomes;
        this.expenses = expenses;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Income[] getIncomes() {
        return incomes;
    }

    public void setIncomes(Income[] incomes) {
        this.incomes = incomes;
    }

    public Expense[] getExpenses() {
        return expenses;
    }

    public void setExpenses(Expense[] expenses) {
        this.expenses = expenses;
    }
}
