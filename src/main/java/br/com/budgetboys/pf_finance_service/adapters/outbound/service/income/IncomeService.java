package br.com.budgetboys.pf_finance_service.adapters.outbound.service.income;

import org.springframework.stereotype.Service;

import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeRepository;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService (IncomeRepository incomeRepository){
        this.incomeRepository = incomeRepository;
    }
    
    public Income saveIncome(Income income){

        if(income.getAmount() < 0){
            throw new IllegalArgumentException("The expense amount cannot be negative");
        }
        return incomeRepository.save(income);
    }
}
