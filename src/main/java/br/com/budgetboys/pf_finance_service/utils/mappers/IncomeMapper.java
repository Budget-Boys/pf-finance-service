package br.com.budgetboys.pf_finance_service.utils.mappers;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAIncomeEntity;
import br.com.budgetboys.pf_finance_service.domain.income.Income;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.income.IncomeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IncomeMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "incomeCreateDTO.amount", target = "amount"),
            @Mapping(source = "incomeCreateDTO.category", target = "category"),
            @Mapping(target = "creationDate", ignore = true),
            @Mapping(source = "incomeCreateDTO.userId", target = "userId")
    })
    Income requestToEntity(IncomeCreateDTO incomeCreateDTO);

    @Mappings({
            @Mapping(source = "incomeEntity.id", target = "id"),
            @Mapping(source = "incomeEntity.amount", target = "amount"),
            @Mapping(source = "incomeEntity.category", target = "category"),
            @Mapping(source = "incomeEntity.creationDate", target = "creationDate"),
            @Mapping(source = "incomeEntity.userId", target = "userId")
    })
    IncomeResponseDTO entityToResponse(Income incomeEntity);

    @Mappings({
            @Mapping(source = "jpaIncomeEntity.id", target = "id"),
            @Mapping(source = "jpaIncomeEntity.amount", target = "amount"),
            @Mapping(source = "jpaIncomeEntity.category", target = "category"),
            @Mapping(source = "jpaIncomeEntity.creationDate", target = "creationDate"),
            @Mapping(source = "jpaIncomeEntity.userId", target = "userId")
    })
    Income jpaToEntity(JPAIncomeEntity jpaIncomeEntity);

     @Mappings({
        @Mapping(source = "income.id", target = "id"),
        @Mapping(source = "income.amount", target = "amount"),
        @Mapping(source = "income.category", target = "category"),
        @Mapping(source = "income.creationDate", target = "creationDate"),
        @Mapping(source = "income.userId", target = "userId")
    })
    JPAIncomeEntity entityToJpa(Income income);

     @Mappings({
             @Mapping(source = "jpaIncomeEntity.id", target = "id"),
             @Mapping(source = "jpaIncomeEntity.amount", target = "amount"),
             @Mapping(source = "jpaIncomeEntity.category", target = "category"),
             @Mapping(source = "jpaIncomeEntity.creationDate", target = "creationDate"),
             @Mapping(source = "jpaIncomeEntity.userId", target = "userId")
     })
     IncomeResponseDTO jpaToResponse(JPAIncomeEntity jpaIncomeEntity);
}
