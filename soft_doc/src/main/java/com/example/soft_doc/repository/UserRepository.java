package com.example.soft_doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.soft_doc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
