package org.example.tipisProjectServer.serviceImpl;

import org.example.tipisProjectServer.models.Point;
import org.example.tipisProjectServer.repositories.GraphicRepository;
import org.example.tipisProjectServer.repositories.PointRepository;
import org.example.tipisProjectServer.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PointServiceImpl implements PointService {
    private final PointRepository pointRepository;
    private final GraphicRepository graphicRepository;

    @Autowired
    public PointServiceImpl(PointRepository pointRepository, GraphicRepository graphicRepository) {
        this.pointRepository = pointRepository;
        this.graphicRepository = graphicRepository;
    }

    @Override
    public List<Point> findAll() {
        return pointRepository.findAll();
    }

    @Override
    public void saveAll(Point[] points, String graphicName) {
        for(Point point : points){
            point.setGraphic(graphicRepository.findGraphicByName(graphicName));
        }
        pointRepository.saveAllAndFlush(Arrays.asList(points));
    }

    @Override
    public void deletePoint(double value) {

    }
}
