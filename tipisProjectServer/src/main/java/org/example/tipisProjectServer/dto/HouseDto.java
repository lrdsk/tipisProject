package org.example.tipisProjectServer.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tipisProjectServer.models.BuildingType;
import java.util.Date;

@Data
@NoArgsConstructor
public class HouseDto {
    private Date dateOfPublication;

    @Min(value=1, message = "Price need to be more than 0")
    private int price;

    private int level;
    private int rooms;
    private BuildingType buildingType;
}
