package com.example.demobd.controller;

import com.example.demobd.model.entity.PruebaEntity;
import com.example.demobd.model.repository.PruebaRepository;
import com.example.demobd.model.service.IPruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PruebaController {

    @Autowired
    PruebaRepository pruebaRepository;

    @Autowired
    IPruebaService iPruebaService;

    @GetMapping("/ejemplo")
    public ResponseEntity<List<PruebaEntity>> obtenerEjemplo() {
        List<PruebaEntity> pruebaEntity = pruebaRepository.findAll();
        return new ResponseEntity<>(pruebaEntity, HttpStatus.OK);
    }

    @PostMapping("/ejemplo")
    public ResponseEntity<PruebaEntity> obtenerEjemploPost(@RequestBody PruebaEntity pruebaEntity) {
        PruebaEntity pruebaEntityR = pruebaRepository.save(pruebaEntity);
        return new ResponseEntity<>(pruebaEntityR, HttpStatus.OK);
    }

}
