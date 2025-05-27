package br.com.budgetboys.pf_finance_service.adapters.outbound.entities;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.ExpenseCategory;
import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Table(name = "expense")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JPAExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "expense_id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "expense_amount", nullable = false)
    private double amount;

    @Column(name = "expense_category", nullable = false)
    private ExpenseCategory category;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    public JPAExpenseEntity(Expense expense) {
        this.id = expense.getId();
        this.amount = expense.getAmount();
        this.category = expense.getCategory();
        this.creationDate = expense.getCreationDate();
        this.userId = expense.getUserId();
    }
}
