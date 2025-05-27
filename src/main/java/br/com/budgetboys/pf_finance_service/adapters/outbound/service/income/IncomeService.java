package br.com.budgetboys.pf_finance_service.adapters.outbound.service.income;

import java.util.List;
import java.util.UUID;

import br.com.budgetboys.pf_finance_service.domain.income.IncomeCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeResponseDTO;
import br.com.budgetboys.pf_finance_service.utils.mappers.IncomeMapper;
import org.springframework.stereotype.Service;

import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeRepository;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    private IncomeMapper incomeMapper;

    public IncomeService (IncomeRepository incomeRepository){
        this.incomeRepository = incomeRepository;
    }
    
    public IncomeResponseDTO saveIncome(IncomeCreateDTO income){

        if(income.getAmount() < 0){
            throw new IllegalArgumentException("The income amount cannot be negative");
        }

        Income incomeEntity = incomeMapper.toEntity(income);

        Income jpaIncomeEntity = incomeRepository.save(incomeEntity);

        return incomeMapper.toResponseDto(jpaIncomeEntity);
    }

    public IncomeResponseDTO findIncomeById(UUID id){
        Income income = incomeRepository.findById(id);
        if(income == null){
            throw new IllegalArgumentException("Income Id: " +id+ "not found");
        }
        return this.incomeMapper.toResponseDto(income);
    }

    public List<Income> getAllIncomes(){
        return incomeRepository.findAll();
    }

    public void deleteIncome(UUID id){
        incomeRepository.deleteById(id);
    }
}
