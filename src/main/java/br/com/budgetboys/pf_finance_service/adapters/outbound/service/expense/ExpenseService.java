package br.com.budgetboys.pf_finance_service.adapters.outbound.service.expense;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseResponseDTO;
import br.com.budgetboys.pf_finance_service.utils.mappers.ExpenseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    private final ExpenseMapper expenseMapper;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    public ExpenseResponseDTO saveExpense(ExpenseCreateDTO expenseCreateDTO) {
        if (expenseCreateDTO.getAmount() < 0) {
            throw new IllegalArgumentException("The expense amount cannot be negative");
        }

        Expense expenseEntity = this.expenseMapper.requestToEntity(expenseCreateDTO);
        Expense savedEntity = this.expenseRepository.save(expenseEntity);

        return this.expenseMapper.entityToResponse(savedEntity);
    }

    public ExpenseResponseDTO findExpenseById(UUID id) {
        Expense expense = this.expenseRepository.findById(id);
        if (expense == null) {
            throw new IllegalArgumentException("Expense Id: " + id + " not found");
        }
        return this.expenseMapper.entityToResponse(expense);
    }

    public List<ExpenseResponseDTO> findAll() {
        return this.expenseRepository.findAll()
                .stream()
                .map(this.expenseMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public void deleteExpense(UUID id) {
        Expense expense = this.expenseRepository.findById(id);

        if (expense == null) {
            throw new IllegalArgumentException("Expense Id: " + id + " not found");
        }

        this.expenseRepository.delete(expense);
    }

    public List<ExpenseResponseDTO> findExpensesByUserId(UUID userId) {
        return this.expenseRepository.findAllByUserId(userId).stream()
                .map(this.expenseMapper::entityToResponse)
                .collect(Collectors.toList());
    }
}
