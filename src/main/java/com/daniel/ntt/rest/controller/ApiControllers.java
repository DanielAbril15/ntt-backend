package com.daniel.ntt.rest.controller;

import com.daniel.ntt.rest.models.Document;
import com.daniel.ntt.rest.models.User;
import com.daniel.ntt.rest.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {

    @Autowired
    IUserService userService;


    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> example(@RequestParam(name = "type", required = true) String type,
                                     @RequestParam(name = "document", required = true) String document) {

        // Validar si el parámetro solo contiene números
        if (!document.matches("\\d+")) {
            throw new RuntimeException("Invalid parameter value: " + document);
        }

        if (!type.equals("P") && !type.equals("C")) {
            return new ResponseEntity<>("Invalid parameter value: " + type, HttpStatus.BAD_REQUEST);
        }

        if (!document.equals("23445322")) {
            return new ResponseEntity<>("The document " + document + " not exist", HttpStatus.NOT_FOUND);
        }


        Document documentRequest = new Document();
        documentRequest.setDocumentType(type);
        documentRequest.setDocumentNumber(document);
        User userResponse = userService.getDetailsUser(documentRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }


}
