package br.com.budgetboys.pf_finance_service.domain.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserCreateDTO {

    @NotNull
    private UUID id;

    @NotNull
    private String name;

}
