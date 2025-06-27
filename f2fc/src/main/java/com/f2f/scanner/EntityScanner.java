package com.f2f.scanner;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityScanner {

    @Bean
    public CommandLineRunner showEntities(EntityManagerFactory emf) {
        return args -> {
            System.out.println("✅ Detected JPA Entities:");
            for (EntityType<?> entity : emf.getMetamodel().getEntities()) {
                System.out.println(" - " + entity.getJavaType().getName());
            }
        };
    }
}
