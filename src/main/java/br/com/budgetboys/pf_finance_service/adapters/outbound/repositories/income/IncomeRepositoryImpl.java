package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAIncomeEntity;
import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeRepository;
import br.com.budgetboys.pf_finance_service.utils.mappers.IncomeMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class IncomeRepositoryImpl implements IncomeRepository {

    private final JPAIncomeRepository jpaIncomeRepository;

    private final IncomeMapper incomeMapper;

    public IncomeRepositoryImpl(JPAIncomeRepository jpaIncomeRepository, IncomeMapper incomeMapper) {
        this.jpaIncomeRepository = jpaIncomeRepository;
        this.incomeMapper = incomeMapper;
    }

    @Override
    public Income save(Income income) {
        JPAIncomeEntity incomeEntity = new JPAIncomeEntity(income);
        return this.incomeMapper.jpaToIncome(this.jpaIncomeRepository.save(incomeEntity));
    }

    @Override
    public Income findById(UUID id) {
        Optional<JPAIncomeEntity> incomeEntity = this.jpaIncomeRepository.findById(id);
        return incomeEntity.map(entity -> new Income(entity.getId(), entity.getAmount(), entity.getCategory())).orElse(null);
    }

    @Override
    public List<Income> findAll() {
        return this.jpaIncomeRepository.findAll()
                .stream()
                .map(entity -> new Income(entity.getId(), entity.getAmount(), entity.getCategory()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        this.jpaIncomeRepository.deleteById(id);
    }
}
