package com.example.trace.repo;
import com.example.trace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepo extends JpaRepository<User, Long> { Optional<User> findByUsername(String username); }
