package br.com.budgetboys.pf_finance_service.domain.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.ExpenseCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ExpenseCreateDTO {

    @Positive(message = "The expense amount must be positive")
    private double amount;

    @NotNull(message = "The category cannot be null")
    private ExpenseCategory category;

    private UUID userId;

}
