package com.hms.hms.service;

import com.hms.hms.dto.UserDto.UserCreateDto;
import com.hms.hms.dto.UserDto.UserResponseDto;
import com.hms.hms.entity.User;
import com.hms.hms.exception.DuplicateUserException;
import com.hms.hms.exception.UserNotFoundException;
import com.hms.hms.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    // create
    public Long createUser(UserCreateDto dto) {

        validateNewUser(dto);
        User user = new User();

        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setEmail(dto.email());
        user.setPasswordHash(encoder.encode(dto.password()));
        user.setPhoneNumber(dto.phoneNumber());
        user.setBirthDate(dto.birthDate());
        user.setCpf(dto.cpf());
        user.setGender(dto.gender());
        user.setPostalCode(dto.postalCode());
        user.setStreet(dto.street());
        user.setStreetNumber(dto.streetNumber());
        user.setAddressComplement(dto.addressComplement());
        user.setNeighborhood(dto.neighborhood());
        user.setCity(dto.city());
        user.setState(dto.state());

        User savedUser = repository.save(user);
        return savedUser.getId();
    }

    // validate user
    private void validateNewUser(UserCreateDto dto) {

        if (repository.existsByEmail(dto.email())) {
            throw new DuplicateUserException(
                    "Email already exists"
            );
        }

        if (repository.existsByCpf(dto.cpf())) {
            throw new DuplicateUserException(
                    "CPF already exists"
            );
        }
    }

    // find user by id
    public UserResponseDto findUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found"
                ));

        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    // show all users
    public List<UserResponseDto> findAllUsers() {
        List<User> users = repository.findAll();
        List<UserResponseDto> response = new ArrayList<>();

        for (User user : users) {
            response.add(new UserResponseDto(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail()
            ));
        }

        return response;
    }
}