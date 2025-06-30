package kkl.example;

import io.grpc.stub.StreamObserver;
import kkl.example.user.*;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class RandomUserRpcService extends RandomUserServiceGrpc.RandomUserServiceImplBase {

    private final RandomUserRepository repository;
    private final UserToDtoMapper mapper;

    @Override
    public void getRandomUsers(RandomUsersRequest dto,
                               StreamObserver<RandomUsersResponse> responseObserver) {

        var users = getRandomUsers(dto.getAmount());

        responseObserver.onNext(
                RandomUsersResponse.newBuilder()
                .addAllUsers(users)
                .build()
        );

        responseObserver.onCompleted();
    }

    private List<RandomUserResponse> getRandomUsers(Integer amount) {
        return repository.getRandomUsers(amount)
                .stream()
                .map(mapper::map)
                .toList();
    }
}
