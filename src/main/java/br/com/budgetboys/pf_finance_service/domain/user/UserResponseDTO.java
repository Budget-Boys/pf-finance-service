package br.com.budgetboys.pf_finance_service.domain.user;

import java.util.UUID;

import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.income.Income;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserResponseDTO {
   
     private UUID id;
    private String name;

    public UserResponseDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}

