package br.com.budgetboys.pf_finance_service.domain.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.ExpenseCategory;

import java.util.Date;
import java.util.UUID;

public class Expense {

    private UUID id;
    private double amount;
    private ExpenseCategory category;
    private Date creationDate;
    private UUID userId;

    public Expense() {
    }

    public Expense(UUID id, double amount, ExpenseCategory category, UUID userId) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
