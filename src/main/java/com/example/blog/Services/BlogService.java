package com.example.blog.Services;

import com.example.blog.Repositories.BlogRepository;
import com.example.blog.Repositories.UserRepository;
import com.example.blog.models.Blog;
import com.example.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        User user = userRepository.findById(userId).get();
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPubDate(new Date());
        blog.setUser(user);

        List<Blog> blogList = user.getBlogList();
        blogList.add(blog);
        user.setBlogList(blogList);

        userRepository.save(user);
        return blog;

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository.deleteById(blogId);
    }
}