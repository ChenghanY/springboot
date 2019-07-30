package com.james.signature.controller;

import com.james.signature.domain.PostEntity;
import com.james.signature.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "职位控制器")
@RestController
public class   PostController {

    @Autowired
    PostService postService;

    @GetMapping(value = "/post")
    @ApiOperation(value = "获取所有职位信息")
    private PostEntity[] getAllPost() {
        List<PostEntity> postEntityList = postService.getAllPost();
        return postEntityList.toArray(new PostEntity[postEntityList.size()]);
    }

    @GetMapping(value = "/post/{id}")
    @ApiOperation(value = "根据职位ID获取职位信息")
    private PostEntity getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }
}
