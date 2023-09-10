package com.example.blog.Services;

import com.example.blog.Repositories.UserRepository;

import com.example.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(String username, String password){
        User user=new User(username,password);
        userRepository.save(user);
        return user;
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }

    public User updateUser(Integer id, String password){
        User user=userRepository.findById(id).get();
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }
}