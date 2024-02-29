package com.example.antoangiaothong.atgt.Repository;

import com.example.antoangiaothong.atgt.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
