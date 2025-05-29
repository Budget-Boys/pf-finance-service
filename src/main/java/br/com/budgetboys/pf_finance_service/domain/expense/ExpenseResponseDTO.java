package br.com.budgetboys.pf_finance_service.domain.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.ExpenseCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class ExpenseResponseDTO {

    private UUID id;
    private double amount;
    private ExpenseCategory category;
    private Date creationDate;
    private UUID userId;

}
