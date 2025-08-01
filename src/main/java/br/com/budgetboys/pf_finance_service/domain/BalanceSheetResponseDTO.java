package br.com.budgetboys.pf_finance_service.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceSheetResponseDTO {

    private String status;
    private double expensesAmountTotal;
    private double incomesAmountTotal;
    private double balance;
}
