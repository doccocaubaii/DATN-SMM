package edu.hust.shadowmiddleman.service;

import edu.hust.shadowmiddleman.repository.PostRepository;
import edu.hust.shadowmiddleman.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseAutowire {
    @Autowired
    ModelMapper modelMapper;

    //--------- repository start ------------//

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    //--------- repository end ------------//

}
