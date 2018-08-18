package com.winkle.Niteleague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;
import java.util.Random;

@SpringBootApplication
@EnableJpaAuditing
public class NiteleagueApplication {

    public static void main(String[] args) {

        SpringApplication.run(NiteleagueApplication.class, args);
    }




}
