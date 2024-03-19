package edu.hust.shadowmiddleman.service;

import edu.hust.shadowmiddleman.domain.User;
import edu.hust.shadowmiddleman.dto.account.RegisterDTO;
import edu.hust.shadowmiddleman.dto.common.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseAutowire {
    public User register(RegisterDTO dto){
        User user = modelMapper.map(dto, User.class);
        return userRepository.save(user);
    }
}
