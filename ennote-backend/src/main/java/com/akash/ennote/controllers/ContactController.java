package com.akash.ennote.controllers;

import com.akash.ennote.dtos.ContactForm;
import com.akash.ennote.utils.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody ContactForm form) {
        String emailBody = "Name: " + form.getName() + "\n"
                + "Email: " + form.getEmail() + "\n"
                + "Message: " + form.getMessage();

        emailService.sendEmail(
                form.getEmail(),
                "am5857516@gmail.com",
                "New Contact Form Submission",
                emailBody
        );

        return "Email sent successfully";
    }
}