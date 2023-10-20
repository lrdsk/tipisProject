package org.example.tipisProjectServer.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "house")
public class House {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date_of_publication")
    @Temporal(TemporalType.DATE)
    private Date dateOfPublication;

    @Column(name="price")
    private int price;

    @Column(name="level")
    private int level;

    @Column(name="rooms")
    private int rooms;

    @Column(name="bilding_type")
    @Enumerated(EnumType.ORDINAL)
    private BuildingType buildingType;

    public House(Date dateOfPublication, int price, int level, int rooms, BuildingType buildingType) {
        this.dateOfPublication = dateOfPublication;
        this.price = price;
        this.level = level;
        this.rooms = rooms;
        this.buildingType = buildingType;
    }
}
