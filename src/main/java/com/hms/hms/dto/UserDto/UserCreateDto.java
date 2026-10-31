package com.hms.hms.dto.UserDto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record UserCreateDto(
    @NotBlank
    String firstName,
    @NotBlank
    String lastName,
    @NotBlank
    @Email
    String email,
    @NotBlank
    @Size(min = 8)
    String password,
    @NotBlank
    String phoneNumber,
    @NotNull
    LocalDate birthDate,
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    String cpf,
    String gender,
    @NotBlank
    String postalCode,
    @NotBlank
    String street,
    @NotBlank
    String streetNumber,
    String addressComplement,
    @NotBlank
    String neighborhood,
    @NotBlank
    String city,
    @NotBlank
    String state
) {}