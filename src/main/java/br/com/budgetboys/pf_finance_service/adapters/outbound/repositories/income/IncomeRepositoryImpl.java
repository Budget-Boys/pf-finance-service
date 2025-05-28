package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAIncomeEntity;
import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeRepository;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeResponseDTO;
import br.com.budgetboys.pf_finance_service.utils.mappers.IncomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class IncomeRepositoryImpl implements IncomeRepository {

    private final JPAIncomeRepository jpaIncomeRepository;

    @Autowired
    private final IncomeMapper incomeMapper;

    public IncomeRepositoryImpl(JPAIncomeRepository jpaIncomeRepository, IncomeMapper incomeMapper) {
        this.jpaIncomeRepository = jpaIncomeRepository;
        this.incomeMapper = incomeMapper;
    }

    @Override
    public Income save(Income income) {
        JPAIncomeEntity incomeEntity = this.incomeMapper.incomeToJpa(income);
        JPAIncomeEntity savedEntity = this.jpaIncomeRepository.save(incomeEntity);
        return this.incomeMapper.jpaToIncome(savedEntity);
    }

    @Override
    public Income findById(UUID id) {
        Optional<JPAIncomeEntity> incomeEntity = this.jpaIncomeRepository.findById(id);
        return incomeEntity.map(this.incomeMapper::jpaToIncome).orElse(null);
    }

    @Override
    public List<IncomeResponseDTO> findAll() {
        return this.jpaIncomeRepository.findAll().stream().map(this.incomeMapper::jpaToResponseDto).collect(Collectors.toList());

    }

    @Override
    public void deleteById(UUID id) {
        this.jpaIncomeRepository.deleteById(id);
    }
}
