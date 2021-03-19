package com.tts.capstone.SmartShreveCity2.repository;

import com.tts.capstone.SmartShreveCity2.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}