package com.example.blog.Repositories;

//import com.example.blog.Models.Blog;
import com.example.blog.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
