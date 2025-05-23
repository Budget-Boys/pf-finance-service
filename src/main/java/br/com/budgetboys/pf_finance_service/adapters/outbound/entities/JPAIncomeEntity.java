package br.com.budgetboys.pf_finance_service.adapters.outbound.entities;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.IncomeCategory;
import br.com.budgetboys.pf_finance_service.domain.income.Income;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "income")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JPAIncomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "income_id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "income_amout", nullable = false)
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "income_category", nullable = false)
    private IncomeCategory category;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    public JPAIncomeEntity(Income income) {
        this.id = income.getId();
        this.amount = income.getAmount();
        this.category = income.getCategory();
        this.creationDate = income.getCreationDate();
        this.userId = income.getUserId();
    }
}
