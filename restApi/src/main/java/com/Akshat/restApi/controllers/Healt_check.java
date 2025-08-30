package com.Akshat.restApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Healt_check {
     @GetMapping("/")
     public String healt_check(){
         return "Ok";
     }
}
