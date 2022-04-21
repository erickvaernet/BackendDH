package com.example.integradorV2.Persistence;

import com.example.integradorV2.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
