package com.example.security.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @GetMapping(value = "")
    public ResponseEntity<?> index() {
        return new ResponseEntity<>("Hello Security", HttpStatus.OK);
    }



}