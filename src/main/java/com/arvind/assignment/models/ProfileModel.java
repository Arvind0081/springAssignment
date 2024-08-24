package com.arvind.assignment.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileModel {

    
   @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
   
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;
    
    @NotBlank(message = "Phone Number is mandatory")
    @Pattern(regexp="(^$|\\d{10})")
    private String phone;
    
}
