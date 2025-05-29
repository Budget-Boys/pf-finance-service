package br.com.budgetboys.pf_finance_service.adapters.outbound.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name = "user")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JPAUserEntity {

    @Id
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_incomes")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<JPAIncomeEntity> incomes;

    @Column(name = "user_expenses")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<JPAExpenseEntity> expenses;
}
