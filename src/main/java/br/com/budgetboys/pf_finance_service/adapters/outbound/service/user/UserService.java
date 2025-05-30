package br.com.budgetboys.pf_finance_service.adapters.outbound.service.user;


import br.com.budgetboys.pf_finance_service.domain.user.*;
import br.com.budgetboys.pf_finance_service.utils.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

      public void saveUser(UserCreateDTO userCreateDTO) {
        if (userCreateDTO.getName() == null) {
            throw new IllegalArgumentException("User name cannot be null or blank");
        }
        userRepository.save(userCreateDTO);
    }

    
}