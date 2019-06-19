package com.james.signature.service.impl;

import com.james.signature.domain.PostEntity;
import com.james.signature.repository.PostRepository;
import com.james.signature.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<PostEntity> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public PostEntity getPostById(Integer id) {
        Optional<PostEntity> optional = postRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            PostEntity p = new PostEntity();
            p.setDescription("资源未找到");
            return p;
        }
    }
}
