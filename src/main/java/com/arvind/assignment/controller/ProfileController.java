package com.arvind.assignment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.arvind.assignment.models.ProfileModel;
import com.arvind.assignment.services.iservices.IProfileServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profile")
public class ProfileController {
    private final IProfileServices profileServices;


    @GetMapping("")
    public ResponseEntity<List<ProfileModel>> getAllProfile(){
List<ProfileModel> responseList= profileServices.readAllProfile();
        return new ResponseEntity<>(responseList,HttpStatus.OK);
       
    }
    @PostMapping("")
    public ResponseEntity<String> postMethodName(@Valid @RequestBody ProfileModel profile) {
       String response= profileServices.createProfile(profile);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<ProfileModel> getByName(@RequestHeader String name){
    ProfileModel responseList= profileServices.getProfileByName(name);
        return new ResponseEntity<>(responseList,HttpStatus.OK);
       
    }

    // to display the annotation message
     @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    
}
