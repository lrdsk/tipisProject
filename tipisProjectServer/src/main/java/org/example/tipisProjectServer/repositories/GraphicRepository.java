package org.example.tipisProjectServer.repositories;

import org.example.tipisProjectServer.models.Graphic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicRepository extends JpaRepository<Graphic, Integer> {
    Graphic findGraphicByName(String name);
}
