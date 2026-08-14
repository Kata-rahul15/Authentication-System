package com.Application.AuthService.Controller;

import com.Application.AuthService.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;
import java.net.Socket;

@RestController
public class TestController {


    @GetMapping("/health")
        public String home() {
            return "Authentication Service Running!";
        }


}
