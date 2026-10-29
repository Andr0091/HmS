package com.hms.hms.dto.UserDto;

import java.time.LocalDate;

public record UserCreateDto(
    String firstName,
    String lastName,
    String email,
    String password,
    String phoneNumber,
    LocalDate birthDate,
    String cpf,
    String gender,
    String postalCode,
    String street,
    String streetNumber,
    String addressComplement,
    String neighborhood,
    String city,
    String state
) {}