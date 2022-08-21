package com.example.bloggingapp.services;

import com.example.bloggingapp.entities.Post;
import com.example.bloggingapp.payloads.PostDto;
import com.example.bloggingapp.payloads.PostResponse;

import java.util.List;

public interface PostService {

    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    PostDto updatePost(PostDto postDto, Integer postId);

    // delete post
    void deletePost(Integer postId);

    // get all
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    // get post
    PostDto getPostById(Integer postId);

    // get by category
    List<PostDto> getAllPostsByCategory(Integer categoryId);

    // get by user
    List<PostDto> getAllPostsByUser(Integer userId);

    List<PostDto> searchPost(String keyword);
}
