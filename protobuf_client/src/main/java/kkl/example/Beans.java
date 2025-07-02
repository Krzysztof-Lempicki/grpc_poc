package kkl.example;

import kkl.example.user.RandomUserServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class Beans {

    @Bean
    public RandomUserServiceGrpc.RandomUserServiceBlockingStub randomUserServiceStub(GrpcChannelFactory channels) {
        return RandomUserServiceGrpc.newBlockingStub(channels.createChannel("local"));
    }


}
