package org.example.tipisProjectServer.service;

import org.example.tipisProjectServer.models.Point;

import java.util.List;

public interface PointService{
    List<Point> findAll();
    void saveAll(Point[] points, String graphicName);
    void deletePoint(double value);
}
