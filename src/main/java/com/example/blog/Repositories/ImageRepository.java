package com.example.blog.Repositories;

//import com.example.blog.Models.Image;
import com.example.blog.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

}