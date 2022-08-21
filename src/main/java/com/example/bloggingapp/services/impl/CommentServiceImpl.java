package com.example.bloggingapp.services.impl;

import com.example.bloggingapp.entities.Comment;
import com.example.bloggingapp.entities.Post;
import com.example.bloggingapp.exceptions.ResourceNotFoundException;
import com.example.bloggingapp.payloads.CommentDto;
import com.example.bloggingapp.repositories.CommentRepository;
import com.example.bloggingapp.repositories.PostRepository;
import com.example.bloggingapp.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        // fetch post
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
        // commentDto -> comment
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        // update comment data
        comment.setPost(post);
        // save into database
        Comment savedComment = this.commentRepository.save(comment);

        // return commentDto
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        // fetch comment
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId));
        // delete comment
        this.commentRepository.delete(comment);
    }
}
