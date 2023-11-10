package com.example.demobd.model.repository;

import com.example.demobd.model.entity.DemoBdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoBdRepository extends JpaRepository<DemoBdEntity, Long> {
    List<DemoBdEntity> findByName(String nombre);

}
