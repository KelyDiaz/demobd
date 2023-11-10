package com.example.demobd.model.util;

import com.example.demobd.model.dto.DemoBdDTO;
import com.example.demobd.model.entity.DemoBdEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemoBdUtil {
    public List<DemoBdDTO> getUserMapper(List<DemoBdEntity> demoBdEntity) {
        List<DemoBdDTO> demoBdDTOS = new ArrayList<>();
        for (DemoBdEntity demoBdEntity1 : demoBdEntity) {
            DemoBdDTO demoBdDTO = new DemoBdDTO();
            demoBdDTO.setNombre(demoBdEntity1.getName());
            demoBdDTOS.add(demoBdDTO);
        }
        return demoBdDTOS;
    }

    public DemoBdDTO createUserMapper(DemoBdEntity demoBdEntity) {
        DemoBdDTO demoBdDTO = new DemoBdDTO();
        demoBdDTO.setNombre(demoBdEntity.getName());
        return demoBdDTO;
    }
}
