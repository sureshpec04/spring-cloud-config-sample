package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class SpringCloudconfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudconfigClientApplication.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${message:Hello default}")
    private String message;
    
    @Value("${password:Non-Decrypted secret}")
    private String mysecret;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
    
    @RequestMapping("/secret")
    String getSecret() {
        return this.mysecret;
    }
}
