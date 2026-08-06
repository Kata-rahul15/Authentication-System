package com.Application.AuthService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

        @GetMapping("/")
        public String home() {
            return "Authentication Service Running!";
        }


}
