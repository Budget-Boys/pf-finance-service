package br.com.budgetboys.pf_finance_service.domain.income;

import java.util.List;
import java.util.UUID;

public interface IncomeRepository {
    Income save(Income income);
    Income findById(UUID id);
    List<Income> findAll();
    void delete(Income income);
    List<Income> findAllByUserId(UUID userId);
}
