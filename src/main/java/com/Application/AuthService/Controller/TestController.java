package com.Application.AuthService.Controller;

import com.Application.AuthService.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    private final EmailService emailService;
    @Autowired
    public TestController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
        public String home() {
            return "Authentication Service Running!";
        }

    @GetMapping("/mail-test")
    public String mailTest() {
        emailService.sendVerifyOtp("katarahul8@@gmail.com", "rahul","123456");
        return "Mail requested";
    }


}
