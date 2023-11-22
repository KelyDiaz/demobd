package com.example.demobd.model.service;

import com.example.demobd.model.dto.DemoBdDTO;
import com.example.demobd.model.entity.DemoBdEntity;
import com.example.demobd.model.repository.DemoBdRepository;
import com.example.demobd.model.util.DemoBdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DemoBdServiceImpl implements IDemoBdService {

    private final DemoBdRepository demoBdRepository;
    private final DemoBdUtil demoBdUtil;

    @Autowired
    public DemoBdServiceImpl(DemoBdRepository demoBdRepository, DemoBdUtil demoBdUtil) {
        this.demoBdRepository = demoBdRepository;
        this.demoBdUtil = demoBdUtil;
    }

    @Override
    public List<DemoBdDTO> getAllUsers() {
        List<DemoBdEntity> demoBdEntity = demoBdRepository.findAll();
        return demoBdUtil.getUserMapper(demoBdEntity);
    }

    @Override
    public List<DemoBdDTO> getUser(String name) {
        List<DemoBdEntity> demoBdEntityR = demoBdRepository.findByName(name);
        if (demoBdEntityR.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return demoBdUtil.getUserMapper(demoBdEntityR);

    }

    @Override
    public DemoBdDTO createUser(DemoBdEntity demoBdEntity) {
        DemoBdEntity demoBdEntityR = demoBdRepository.save(demoBdEntity);
        return demoBdUtil.createUserMapper(demoBdEntityR);
    }
}
