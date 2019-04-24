package com.tompethouse.dao;

import com.tompethouse.entities.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOptionDao extends JpaRepository<OptionEntity,Integer> {
    List<OptionEntity> findAll();
}
