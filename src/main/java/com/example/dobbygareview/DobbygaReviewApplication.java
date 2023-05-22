package com.example.dobbygareview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DobbygaReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(DobbygaReviewApplication.class, args);
    }

}
