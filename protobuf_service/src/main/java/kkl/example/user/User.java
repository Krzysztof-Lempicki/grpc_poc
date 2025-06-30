package kkl.example.user;

import lombok.Builder;

import java.util.List;

@Builder
public record User(
        int id,
        boolean isBlocked,
        String firstName,
        String lastName,
        String email,
        List<PhoneNumber> phones

) {}
