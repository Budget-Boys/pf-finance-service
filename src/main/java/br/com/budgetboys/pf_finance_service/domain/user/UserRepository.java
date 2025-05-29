package br.com.budgetboys.pf_finance_service.domain.user;

public interface UserRepository {
    void save(UserCreateDTO user);
}
