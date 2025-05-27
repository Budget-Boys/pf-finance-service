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

}
