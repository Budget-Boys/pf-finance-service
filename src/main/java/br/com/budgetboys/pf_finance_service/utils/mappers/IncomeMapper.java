package br.com.budgetboys.pf_finance_service.utils.mappers;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAIncomeEntity;
import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeResponseDTO;
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

    @Mappings({
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.amount", target = "amount"),
            @Mapping(source = "entity.category", target = "category"),
            @Mapping(source = "entity.creationDate", target = "creationDate"),
            @Mapping(source = "entity.userId", target = "userId")
    })
    IncomeResponseDTO toResponseDto(Income jpaIncomeEntity);

    @Mappings({
            @Mapping(source = "jpa.id", target = "id"),
            @Mapping(source = "jpa.amount", target = "amount"),
            @Mapping(source = "jpa.category", target = "category"),
            @Mapping(source = "jpa.creationDate", target = "creationDate"),
            @Mapping(source = "jpa.userId", target = "userId")
    })
    Income jpaToIncome(JPAIncomeEntity jpaIncomeEntity);
}
