package org.example.tipisProjectServer.service;

import org.example.tipisProjectServer.dto.HouseDto;

import java.util.List;
import java.util.Optional;

public interface HouseService {
    List<HouseDto> findAll();
    HouseDto findOne(int id);
    void save(HouseDto houseDto);
    void deleteById(int id);
}
