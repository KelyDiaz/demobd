package com.example.demobd.model.service;

import com.example.demobd.model.dto.PruebaDTO;
import com.example.demobd.model.util.PruebaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PruebaServiceImpl implements IPruebaService{
    @Autowired
    public PruebaUtil pruebaUtil;

    @Override
    public PruebaDTO prueba() {

        return null;
    }
}
