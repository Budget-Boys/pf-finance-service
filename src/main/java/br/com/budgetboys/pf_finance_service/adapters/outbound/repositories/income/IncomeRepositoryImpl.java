package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAIncomeEntity;
import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeRepository;
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
        JPAIncomeEntity incomeEntity = this.incomeMapper.entityToJpa(income);
        JPAIncomeEntity savedEntity = this.jpaIncomeRepository.save(incomeEntity);
        return this.incomeMapper.jpaToEntity(savedEntity);
    }

    @Override
    public Income findById(UUID id) {
        Optional<JPAIncomeEntity> incomeEntity = this.jpaIncomeRepository.findById(id);
        return incomeEntity.map(this.incomeMapper::jpaToEntity).orElse(null);
    }

    @Override
    public List<Income> findAll() {
        return this.jpaIncomeRepository.findAll().stream().map(this.incomeMapper::jpaToEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Income income) {
        JPAIncomeEntity jpaIncomeEntity = this.incomeMapper.entityToJpa(income);
        this.jpaIncomeRepository.delete(jpaIncomeEntity);
    }

    @Override
    public List<Income> findAllByUserId(UUID userId) {
        return this.jpaIncomeRepository.findAllByUserId(userId)
                .stream()
                .map(incomeMapper::jpaToEntity)
                .collect(Collectors.toList());
    }
}
