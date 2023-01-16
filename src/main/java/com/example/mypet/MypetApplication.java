package com.example.mypet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MypetApplication {


	public static void main(String[] args) {
		SpringApplication.run(MypetApplication.class, args);
	}

}
