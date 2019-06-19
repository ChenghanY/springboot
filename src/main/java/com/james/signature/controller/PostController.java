package com.james.signature.controller;

import com.james.signature.Constants;
import com.james.signature.domain.PostEntity;
import com.james.signature.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "职位服务")
@RequestMapping(Constants.URI_POST)
public class   PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    @ApiOperation(value = "获取所有职位信息")
    private PostEntity[] getAllPost() {
        List<PostEntity> postEntityList = postService.getAllPost();
        return postEntityList.toArray(new PostEntity[postEntityList.size()]);
    }

    @PostMapping(value = "/{id}")
    @ApiOperation(value = "根据职位ID获取职位信息")
    private PostEntity getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }
}
