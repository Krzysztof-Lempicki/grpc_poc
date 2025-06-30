package kkl.example.user;

import net.datafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.IntStream;

@Repository
public class RandomUserRepository {

    private final Faker faker = new Faker();

    public List<User> getRandomUsers(int count) {
        return IntStream.rangeClosed(1,count)
                .boxed()
                .map(number ->getRandomUser())
                .toList();
    }

    public User getRandomUser(){
        return User.builder()
                .id(faker.number().numberBetween(1,5))
                .isBlocked(faker.bool().bool())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phones(generatePhones())
                .build();
    }

    private List<PhoneNumber> generatePhones() {
        return IntStream.rangeClosed(1, faker.number().numberBetween(1,5))
                .boxed()
                .map(number -> {
                    return new PhoneNumber(
                            faker.phoneNumber().phoneNumber(),
                            PhoneType.values()[faker.number().numberBetween(0,1)]
                    );
                })
                .toList();
    }

}
