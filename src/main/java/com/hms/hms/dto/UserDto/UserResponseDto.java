package com.hms.hms.dto.UserDto;

public record UserResponseDto(
        Long id,
        String firstName,
        String lastName,
        String email
) {}