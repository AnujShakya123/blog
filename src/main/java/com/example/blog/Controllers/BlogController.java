package com.example.blog.Controllers;


import com.example.blog.Services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {


    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity createBlog(@RequestParam Integer userId ,
                                     @RequestParam String title,
                                     @RequestParam String content) {
        // Create a blog and add it under given user
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int blogId) {
        // Delete the blog using deleteById
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
