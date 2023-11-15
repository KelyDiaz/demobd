package com.example.demobd.controller;

import com.example.demobd.model.dto.DemoBdDTO;
import com.example.demobd.model.entity.DemoBdEntity;
import com.example.demobd.model.service.IDemoBdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo-bd")
public class DemoBdController {


    private final IDemoBdService iDemoBdService;

    @Autowired
    public DemoBdController(IDemoBdService iDemoBdService) {
        this.iDemoBdService = iDemoBdService;
    }

    @GetMapping
    public ResponseEntity<List<DemoBdDTO>> getAllUsers() {
        return new ResponseEntity<>(iDemoBdService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<List<DemoBdDTO>> getUser(@PathVariable String name) {
        return new ResponseEntity<>(iDemoBdService.getUser(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DemoBdDTO> createUser(@RequestBody DemoBdEntity demoBdEntity) {
        return new ResponseEntity<>(iDemoBdService.createUser(demoBdEntity), HttpStatus.OK);
    }

}
