package kkl.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.grpc.client.ImportGrpcClients;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ImportGrpcClients(basePackageClasses = Main.class)
public class Main {
    public static void main(String[] args) {
        run(Main.class, args);
    }
}