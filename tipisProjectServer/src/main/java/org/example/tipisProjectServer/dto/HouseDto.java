package org.example.tipisProjectServer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tipisProjectServer.models.BuildingType;

import java.util.Date;

@Data
@NoArgsConstructor
public class HouseDto {
    private Date dateOfPublication;
    private int price;
    private int level;
    private int rooms;
    private BuildingType buildingType;

}
