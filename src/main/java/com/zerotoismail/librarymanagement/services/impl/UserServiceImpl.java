package com.zerotoismail.librarymanagement.services.impl;

import com.zerotoismail.librarymanagement.enums.UserStatus;
import com.zerotoismail.librarymanagement.exceptions.ResourceNotFoundException;
import com.zerotoismail.librarymanagement.models.User;
import com.zerotoismail.librarymanagement.models.UserBorrowBook;
import com.zerotoismail.librarymanagement.repositories.UserRepository;
import com.zerotoismail.librarymanagement.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", id.toString()));
    }

    @Override
    public List<User> searchUserByFirstName(String title) {
        return userRepository.findByFirstName(title);
    }

    @Override
    public List<User> searchUserByEmail(String title) {
        return userRepository.findByEmail(title);
    }

    @Override
    public User createOrUpdateUser(UUID id, String firstName, String lastName,
                                   String email, String password, UserStatus status,
                                   List<UserBorrowBook> borrowedBooks) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setStatus(status);
        user.setBorrowedBooks(borrowedBooks);

        return userRepository.save(user);
    }

    @Override
    public User deleteUser(UUID id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", id.toString()));

        userRepository.delete(foundUser);
        return foundUser;
    }
}
