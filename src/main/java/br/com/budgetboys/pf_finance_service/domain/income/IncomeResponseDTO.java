package br.com.budgetboys.pf_finance_service.domain.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.IncomeCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class IncomeResponseDTO {

    private UUID id;
    private double amount;
    private IncomeCategory category;
    private Date creationDate;
    private UUID userId;

}

