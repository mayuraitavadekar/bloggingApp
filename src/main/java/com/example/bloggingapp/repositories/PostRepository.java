package com.example.bloggingapp.repositories;

import com.example.bloggingapp.entities.Category;
import com.example.bloggingapp.entities.Post;
import com.example.bloggingapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}
