package com.dkkcorp.mybankapp;

//import com.dkkcorp.mybankapp.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(SecurityConfig.class)
public class MyBankAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBankAppApplication.class, args);
    }
}
