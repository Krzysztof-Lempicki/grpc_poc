package kkl.example;

import jakarta.annotation.PostConstruct;
import kkl.example.user.RandomUserServiceGrpc;
import kkl.example.user.RandomUsersRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GrpcServiceRandomUserClient {

    private final RandomUserServiceGrpc.RandomUserServiceBlockingStub randomUserServiceBlockingStub;

    @PostConstruct
    public void getRandomUsers() {
        var usersRequest = RandomUsersRequest.newBuilder()
                .setAmount(1)
                .build();

        log.info(
                randomUserServiceBlockingStub
                    .getRandomUsers(usersRequest)
                    .toString()
        );
    }

}

