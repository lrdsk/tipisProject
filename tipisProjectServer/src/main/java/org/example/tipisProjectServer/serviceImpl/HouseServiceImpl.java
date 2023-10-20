package org.example.tipisProjectServer.serviceImpl;

import org.example.tipisProjectServer.dto.HouseDto;
import org.example.tipisProjectServer.models.House;
import org.example.tipisProjectServer.repositories.HouseRepository;
import org.example.tipisProjectServer.service.HouseService;
import org.example.tipisProjectServer.util.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;
    private final HouseMapper houseMapper;
    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository, HouseMapper houseMapper) {
        this.houseRepository = houseRepository;
        this.houseMapper = houseMapper;
    }

    @Override
    public List<HouseDto> findAll() {
        return houseRepository.findAll().stream().map(houseMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public HouseDto findOne(int id) {
        return houseMapper.toDto(houseRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public void save(HouseDto houseDto) {
        houseRepository.save(houseMapper.toEntity(houseDto));
    }

    @Override
    public void deleteById(int id) {
        houseRepository.deleteById(id);
    }
}
