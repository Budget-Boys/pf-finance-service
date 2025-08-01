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
    private int expensesTolal;
    private int incomesTotal;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getExpensesAmountTotal() {
        return expensesAmountTotal;
    }

    public void setExpensesAmountTotal(double expensesAmountTotal) {
        this.expensesAmountTotal = expensesAmountTotal;
    }

    public double getIncomesAmountTotal() {
        return incomesAmountTotal;
    }

    public void setIncomesAmountTotal(double incomesAmountTotal) {
        this.incomesAmountTotal = incomesAmountTotal;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getExpensesTolal() {
        return expensesTolal;
    }

    public void setExpensesTolal(int expensesTolal) {
        this.expensesTolal = expensesTolal;
    }

    public int getIncomesTotal() {
        return incomesTotal;
    }

    public void setIncomesTotal(int incomesTotal) {
        this.incomesTotal = incomesTotal;
    }
}
