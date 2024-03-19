package edu.hust.shadowmiddleman.service;

import edu.hust.shadowmiddleman.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService extends BaseAutowire{
    public List<Post> getAll(){
        return postRepository.findAll();
    }

}
