package edu.hust.shadowmiddleman.service;

import edu.hust.shadowmiddleman.common.enumpackage.RoleEnum;
import edu.hust.shadowmiddleman.domain.User;
import edu.hust.shadowmiddleman.dto.account.LoginDTO;
import edu.hust.shadowmiddleman.dto.account.RegisterDTO;
import edu.hust.shadowmiddleman.dto.account.UserDTO;
import edu.hust.shadowmiddleman.exception.CustomException;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService extends BaseAutowire {

    @SneakyThrows
    public UserDTO register(RegisterDTO dto) {
        List<User> userList = userRepository.findAllByUsername(dto.getUsername());
        if (!userList.isEmpty()) throw new CustomException("Tài khoản đã tồn tại");
        
        User user = modelMapper.map(dto, User.class);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        if (dto.getRole() == null)
            dto.setRole(RoleEnum.SALE);
        user.setRole(dto.getRole());
        user.setBalance(0D);
        user.setStatus(1);
        userRepository.save(user);
        return authorize(new LoginDTO(dto.getUsername(), dto.getPassword()));
    }

    public UserDTO authorize(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDTO.getUsername(),
                loginDTO.getPassword()
        );

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user =
                userRepository.findOneByUsername(loginDTO.getUsername()).orElseThrow();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setJwt(tokenProvider.generateToken(authentication));
        return userDTO;
    }
}
