package edu.hust.shadowmiddleman.service;

import edu.hust.shadowmiddleman.repository.PostRepository;
import edu.hust.shadowmiddleman.repository.UserRepository;
import edu.hust.shadowmiddleman.security.jwt.TokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseAutowire {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TokenProvider tokenProvider;

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    //--------- repository start ------------//

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    //--------- repository end ------------//

}
