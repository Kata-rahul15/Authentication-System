package com.Application.AuthService.Controller;

import com.Application.AuthService.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;
import java.net.Socket;

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
    public String smtpTest() {
        try (Socket socket = new Socket()) {
            socket.connect(
                    new InetSocketAddress("smtp-relay.brevo.com", 587),
                    5000
            );
            return "Connected";
        } catch (Exception e) {
            return e.toString();
        }
    }


}
