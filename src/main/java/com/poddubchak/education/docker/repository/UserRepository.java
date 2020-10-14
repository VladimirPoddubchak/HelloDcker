package com.poddubchak.education.docker.repository;

import com.poddubchak.education.docker.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    public User findByLogin(String login);
}
