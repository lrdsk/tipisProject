package org.example.tipisProjectServer.serviceImpl;

import org.example.tipisProjectServer.models.Graphic;
import org.example.tipisProjectServer.repositories.GraphicRepository;
import org.example.tipisProjectServer.service.GraphicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class GraphicServiceImpl implements GraphicService {
    private final GraphicRepository graphicRepository;

    public GraphicServiceImpl(GraphicRepository graphicRepository) {
        this.graphicRepository = graphicRepository;
    }

    @Override
    public List<Graphic> findAll() {
        return graphicRepository.findAll();
    }

    @Override
    public Graphic findOne(int id) {
        return graphicRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void save(Graphic graphic) {
        graphicRepository.save(graphic);
    }

    @Override
    public void delete(double value) {

    }
}
