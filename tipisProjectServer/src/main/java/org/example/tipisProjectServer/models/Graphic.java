package org.example.tipisProjectServer.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name="graphic")
@Data
@NoArgsConstructor
public class Graphic {
    @Id
    @Column(name = "graphic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int graphic_id;

    @Column(name="name")
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "graphic", cascade = CascadeType.PERSIST)
    private List<Point> points;

    public Graphic(String name) {
        this.name = name;
    }
}
