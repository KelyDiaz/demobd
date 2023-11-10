package com.example.demobd.model.service;

import com.example.demobd.model.dto.DemoBdDTO;
import com.example.demobd.model.entity.DemoBdEntity;
import com.example.demobd.model.repository.DemoBdRepository;
import com.example.demobd.model.util.DemoBdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoBdServiceImpl implements IDemoBdService {

    @Autowired
    DemoBdRepository demoBdRepository;
    @Autowired
    DemoBdUtil demoBdUtil;

    @Override
    public List<DemoBdDTO> getAllUsers() {
        List<DemoBdEntity> demoBdEntity = demoBdRepository.findAll();
        return demoBdUtil.getUserMapper(demoBdEntity);
    }

    @Override
    public List<DemoBdDTO> getUser(String name) {
        List<DemoBdEntity> demoBdEntityR = demoBdRepository.findByName(name);
        return demoBdUtil.getUserMapper(demoBdEntityR);
    }

    @Override
    public DemoBdDTO createUser(DemoBdEntity demoBdEntity) {
        DemoBdEntity demoBdEntityR = demoBdRepository.save(demoBdEntity);
        return demoBdUtil.createUserMapper(demoBdEntityR);
    }
}
