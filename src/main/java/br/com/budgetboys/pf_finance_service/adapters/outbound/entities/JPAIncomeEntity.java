package br.com.budgetboys.pf_finance_service.adapters.outbound.entities;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.IncomeCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "income_category")
    private IncomeCategory category;
}
