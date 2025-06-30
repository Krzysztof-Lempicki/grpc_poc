package kkl.example.user;

import org.springframework.stereotype.Component;

@Component
public class UserToDtoMapper {

    public RandomUserResponse map(User user) {
        return RandomUserResponse.newBuilder()
                .setId(user.id())
                .setIsBlocked(user.isBlocked())
                .setFirstName(user.firstName())
                .setLastName(user.lastName())
                .setEmail(user.email())
                .addAllPhone(
                   user.phones()
                           .stream()
                           .map(this::mapPhone)
                           .toList()
                           )
                .build();

    }

    private PhoneNumberResponse mapPhone(PhoneNumber phone) {
        return PhoneNumberResponse.newBuilder()
                .setNumber(phone.number())
                .setType(phone.type() == null ? null: PhoneTypeResponse.valueOf(phone.type().name()))
                .build();
    }

}
