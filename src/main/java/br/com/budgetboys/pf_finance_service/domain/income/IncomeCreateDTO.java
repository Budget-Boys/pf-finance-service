package br.com.budgetboys.pf_finance_service.domain.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.IncomeCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class IncomeCreateDTO {

    @Positive(message = "The income amount must be positive")
    private double amount;

    @NotNull(message = "The category cannot be null")
    private IncomeCategory category;

    private UUID userId;

}
