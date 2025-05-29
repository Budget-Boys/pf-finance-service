package br.com.budgetboys.pf_finance_service.utils.mappers;

import br.com.budgetboys.pf_finance_service.domain.user.User;
import br.com.budgetboys.pf_finance_service.domain.user.UserCreateDTO;
import br.com.budgetboys.pf_finance_service.domain.user.UserResponseDTO;

public class UserMapper {
    
    public User requestToEntity(UserCreateDTO dto){
        return new User(dto.getId(), dto.getName(), null, null);
    }

    public UserResponseDTO entityToResponse(User user){
        return new UserResponseDTO(user.getId(), user.getName());
    }

}
