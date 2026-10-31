package com.hms.hms.repository;

import com.hms.hms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<User> findByEmail(String email);
    Optional<User> findByCpf(String cpf);
    Boolean existsByFirstNameAndLastName(String firstName, String lastName);
    Boolean existsByEmail(String email);
    Boolean existsByCpf(String cpf);
}