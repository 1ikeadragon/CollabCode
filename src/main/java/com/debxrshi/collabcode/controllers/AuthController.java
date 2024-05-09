package com.debxrshi.collabcode.controllers;


import com.debxrshi.collabcode.models.User;
import com.debxrshi.collabcode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
//
//    @Autowired
//    private UserRepository userRepository;

//    @PostMapping("/signUp")
//    public ResponseEntity<?> signUp(@RequestBody User user){
//        if(!(userRepository.findByUserAndPasword(user.getUsername(), user.getPassword()))){
//            userRepository.save(user);
//        }
//        else {
//
//        }
//    }
//
//    @PostMapping("/signIn")
//    public ResponseEntity<?> signIn(@RequestBody User user){
//        if(userRepository.findByUserAndPasword(user.getUsername(),user.getPassword())){
//            return ResponseEntity
//        }
//        else {
//            return ResponseEntity
//        }

}


