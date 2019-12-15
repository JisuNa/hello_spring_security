package com.example.security.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/admin")
public class AdminApiController {

    @GetMapping(value="")
    public ResponseEntity<?> index() {
        return new ResponseEntity<>("Admin Index", HttpStatus.OK);
    }
}
