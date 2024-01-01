package com.solix.jdp.springssogoogle.controller;

import com.solix.jdp.springssogoogle.SpringSsoGoogleApplication;
import com.solix.jdp.springssogoogle.domain.User;
import com.solix.jdp.springssogoogle.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<?> save(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.saveUser(user), HttpStatus.CREATED);
    }

    private static final Logger logger = LoggerFactory.getLogger(SpringSsoGoogleApplication.class);

    @GetMapping("/getUser")
    public String getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        String givenName = principal.getAttribute("given_name");
        String familyName = principal.getAttribute("name");
        String email = principal.getAttribute("email");
        String fullName = givenName + " " + familyName;
//        logger.info("Full Name: {}", fullName);
//        logger.info("Email: {}", email);
        User user = new User();
        user.setEmail(email);
        user.setName(familyName);
        user.setGivenName(givenName);
        this.userService.saveUser(user);
        return "Hello, " + familyName + "! Your email is:" + email;
    }

}
