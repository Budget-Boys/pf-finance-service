package br.com.budgetboys.pf_finance_service.adapters.outbound.service.income;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.budgetboys.pf_finance_service.domain.income.IncomeCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeResponseDTO;
import br.com.budgetboys.pf_finance_service.utils.mappers.IncomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeRepository;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    @Autowired
    private IncomeMapper incomeMapper;

    public IncomeService (IncomeRepository incomeRepository){
        this.incomeRepository = incomeRepository;
    }
    
    public IncomeResponseDTO saveIncome(IncomeCreateDTO income){

        if(income.getAmount() < 0){
            throw new IllegalArgumentException("The income amount cannot be negative");
        }

        Income incomeEntity = this.incomeMapper.requestToEntity(income);

        Income jpaIncomeEntity = this.incomeRepository.save(incomeEntity);

        return this.incomeMapper.entityToResponse(jpaIncomeEntity);
    }

    public IncomeResponseDTO findIncomeById(UUID id){
        Income income = this.incomeRepository.findById(id);
        if(income == null){
            throw new IllegalArgumentException("Income Id: " +id+ "not found");
        }
        return this.incomeMapper.entityToResponse(income);
    }

    public List<IncomeResponseDTO> findAllIncomes(){
        return this.incomeRepository.findAll().stream().map(this.incomeMapper::entityToResponse).collect(Collectors.toList());
    }

    public void deleteIncome(UUID id){
        Income  income = this.incomeRepository.findById(id);

        if(income == null){
            throw new IllegalArgumentException("Income Id: " +id+ "not found");
        }

        this.incomeRepository.delete(income);
    }
}
