package br.com.budgetboys.pf_finance_service.utils.mappers;

import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface IncomeMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "dto.amount", target = "amount"),
            @Mapping(source = "dto.category", target = "category"),
            @Mapping(target = "creationDate", ignore = true),
            @Mapping(source = "dto.userId", target = "userId")
    })
    Income toEntity(IncomeCreateDTO incomeCreateDTO);
}
