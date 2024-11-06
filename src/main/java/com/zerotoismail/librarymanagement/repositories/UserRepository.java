package com.zerotoismail.librarymanagement.repositories;

import com.zerotoismail.librarymanagement.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Transactional
    @Modifying
    void deleteById(UUID id);
    Optional<User> findByEmail(String email);
    List<User> findByFirstName(String firstName);
}
