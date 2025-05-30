package br.com.budgetboys.pf_finance_service.domain.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.IncomeCategory;
import br.com.budgetboys.pf_finance_service.domain.user.User;

import java.util.Date;
import java.util.UUID;

public class Income {

    private UUID id;
    private double amount;
    private IncomeCategory category;
    private Date creationDate;

    private User user;

    public Income() {
    }

    public Income(UUID id, double amount, IncomeCategory category, User user) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.user = user;
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

    public IncomeCategory getCategory() {
        return category;
    }

    public void setCategory(IncomeCategory category) {
        this.category = category;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
