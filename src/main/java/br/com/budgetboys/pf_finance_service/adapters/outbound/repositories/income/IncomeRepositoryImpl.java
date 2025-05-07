package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.income;

import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class IncomeRepositoryImpl implements IncomeRepository {

    private JPAIncomeRepository jpaIncomeRepository;

    public IncomeRepositoryImpl(JPAIncomeRepository jpaIncomeRepository) {
        this.jpaIncomeRepository = jpaIncomeRepository;
    }

    @Override
    public Income save(Income income) {
        return null;
    }

    @Override
    public Income findById(UUID id) {
        return null;
    }

    @Override
    public List<Income> findAll() {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
