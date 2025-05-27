package br.com.budgetboys.pf_finance_service.utils.mappers;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAExpenseEntity;
import br.com.budgetboys.pf_finance_service.domain.expense.Expense;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.expense.ExpenseResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") 
public interface ExpenseMapper {

     @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "expenseCreateDTO.amount", target = "amount"),
        @Mapping(source = "expenseCreateDTO.category", target = "category"),
        @Mapping(target = "creationDate", ignore = true),
        @Mapping(source = "expenseCreateDTO.userId", target = "userId")
    })
    Expense expenseCreateDtoToDomain(ExpenseCreateDTO expenseCreateDTO);

    @Mappings({
        @Mapping(source = "expense.id", target = "id"),
        @Mapping(source = "expense.amount", target = "amount"),
        @Mapping(source = "expense.category", target = "category"),
        @Mapping(source = "expense.creationDate", target = "creationDate"),
        @Mapping(source = "expense.userId", target = "userId")
    })
    ExpenseResponseDTO expenseToResponseDto(Expense expense);

    @Mappings({
        @Mapping(source = "jpa.id", target = "id"),
        @Mapping(source = "jpa.amount", target = "amount"),
        @Mapping(source = "jpa.category", target = "category"),
        @Mapping(source = "jpa.creationDate", target = "creationDate"),
        @Mapping(source = "jpa.userId", target = "userId")
    })
    Expense jpaToExpense(JPAExpenseEntity jpa);

     @Mappings({
        @Mapping(source = "expense.id", target = "id"),
        @Mapping(source = "expense.amount", target = "amount"),
        @Mapping(source = "expense.category", target = "category"),
        @Mapping(source = "expense.creationDate", target = "creationDate"),
        @Mapping(source = "expense.userId", target = "userId")
    })
    JPAExpenseEntity expenseToJpa(Expense expense);
}
