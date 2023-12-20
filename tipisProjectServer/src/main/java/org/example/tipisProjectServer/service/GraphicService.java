package org.example.tipisProjectServer.service;

import org.example.tipisProjectServer.models.Graphic;

import java.util.List;

public interface GraphicService {
    List<Graphic> findAll();
    Graphic findOne(int id);
    void save(Graphic graphics);
    void delete(double value);
}
