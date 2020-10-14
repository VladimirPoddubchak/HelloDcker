package com.poddubchak.education.docker.service;

import com.poddubchak.education.docker.model.Status;
import com.poddubchak.education.docker.model.User;
import com.poddubchak.education.docker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser (User user){
        user.setStatus(Status.NEW);
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User createUserByName (String name){
        User user = new User(null,
                name,
                name+"@email.com",
                name+"123",
                name+"@email.com",
                Status.NEW,
                null,
                LocalDateTime.now(),
                LocalDateTime.now());
        return userRepository.save(user);
    }


    public User modifyUser (User user){
        user.setModified(LocalDateTime.now());
        return userRepository.save(user);
    }

    public void deleteUser(User user){
        user.setStatus(Status.DELETED);
        user.setModified(LocalDateTime.now());
        userRepository.save(user);
    }

    public List<User> getAllUsers (){
        return (List<User>) userRepository.findAll();
    }
}
