package br.com.budgetboys.pf_finance_service.model;

import br.com.budgetboys.pf_finance_service.model.enums.IncomeCategory;

import java.util.UUID;

public class Income {

    private UUID id;
    private double amount;
    private IncomeCategory category;
}
