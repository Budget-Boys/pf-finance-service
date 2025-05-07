package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAIncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JPAIncomeRepository extends JpaRepository<JPAIncomeEntity, UUID> {
}
