package com.example.toshexpenses.toshexpenses.repository;

import com.example.toshexpenses.toshexpenses.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
