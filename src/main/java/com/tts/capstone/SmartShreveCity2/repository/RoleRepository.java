package com.tts.capstone.SmartShreveCity2.repository;


import com.tts.capstone.SmartShreveCity2.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRole(String role);

}