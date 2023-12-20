package org.example.tipisProjectServer.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "point")
@NoArgsConstructor
@Data
public class Point {
    @Id
    @Column(name="point_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int point_id;

    @Column(name="point_value")
    private double point_value;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "graphic_id", referencedColumnName = "graphic_id")
    private Graphic graphic;

    public Point(double point_value) {
        this.point_value = point_value;
    }
}
