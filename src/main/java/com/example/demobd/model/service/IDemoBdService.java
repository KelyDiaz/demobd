package com.example.demobd.model.service;

import com.example.demobd.model.dto.DemoBdDTO;
import com.example.demobd.model.entity.DemoBdEntity;

import java.util.List;

public interface IDemoBdService {
    List<DemoBdDTO> getAllUsers();

    List<DemoBdDTO> getUser(String name);

    DemoBdDTO createUser(DemoBdEntity demoBdEntity);
}
