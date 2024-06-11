package com.example.RentCar.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentCar.dto.Usuario.UsuarioDTO;
import com.example.RentCar.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> CreateUser(@RequestBody UsuarioDTO newUser) {

        HashMap<String, Object> response = new HashMap<>();

        UsuarioDTO userCreated = usuarioService.CreateUsuario(newUser);

        if (userCreated == null) {
            response.put("error", "There was an error creating the user");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

        response.put("success", userCreated);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}