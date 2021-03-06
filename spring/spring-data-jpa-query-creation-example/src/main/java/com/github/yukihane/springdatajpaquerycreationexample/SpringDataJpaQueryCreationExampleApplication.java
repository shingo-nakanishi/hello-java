package com.github.yukihane.springdatajpaquerycreationexample;

import com.github.yukihane.springdatajpaquerycreationexample.entity.MyEntityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaQueryCreationExampleApplication implements CommandLineRunner {

    @Autowired
    private MyEntityRepository repository;

    @Override
    public void run(final String... args) throws Exception {
        repository.findById("MY_ID");
        repository.deleteByMyEntityIdAndAltIdNot("ID", "ALT_ID");
        repository.deleteByMyEntityIdIn(List.of("id1", "id2"));

    }

    public static void main(final String[] args) {
        SpringApplication.run(SpringDataJpaQueryCreationExampleApplication.class, args);
    }

}
