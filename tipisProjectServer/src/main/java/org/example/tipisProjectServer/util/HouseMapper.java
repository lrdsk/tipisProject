package org.example.tipisProjectServer.util;

import org.example.tipisProjectServer.dto.HouseDto;
import org.example.tipisProjectServer.models.House;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class HouseMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public HouseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HouseDto toDto(House house){
        return Objects.isNull(house) ? null : modelMapper.map(house, HouseDto.class);
    }

    public House toEntity(HouseDto houseDto){
        return Objects.isNull(houseDto) ? null : modelMapper.map(houseDto, House.class);
    }
}
