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
    
    
}
