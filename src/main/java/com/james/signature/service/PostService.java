package com.james.signature.service;

import com.james.signature.domain.PostEntity;

import java.util.List;

public interface PostService {
    List<PostEntity> getAllPost();

    PostEntity getPostById(Integer id);
}
