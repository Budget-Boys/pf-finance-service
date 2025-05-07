package br.com.budgetboys.pf_finance_service.model;

import br.com.budgetboys.pf_finance_service.model.enums.IncomeCategory;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "income_id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "income_amout", nullable = false)
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "income_category")
    private IncomeCategory category;
}
