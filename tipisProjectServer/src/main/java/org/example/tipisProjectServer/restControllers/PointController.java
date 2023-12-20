package org.example.tipisProjectServer.restControllers;

import org.example.tipisProjectServer.models.Point;
import org.example.tipisProjectServer.serviceImpl.GraphicServiceImpl;
import org.example.tipisProjectServer.serviceImpl.PointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PointController {
    private final PointServiceImpl pointService;
    private final GraphicServiceImpl graphicService;

    @Autowired
    public PointController(PointServiceImpl pointService, GraphicServiceImpl graphicService) {
        this.pointService = pointService;
        this.graphicService = graphicService;
    }

    @GetMapping("/points/{id}")
    public List<Point> getAllPoints(@PathVariable("id") int id){
        return graphicService.findOne(id).getPoints();
    }

    @PostMapping("/points/{name}")
    public HttpEntity<HttpStatus> addPointsForGraphic(@RequestBody Point[] points, @PathVariable("name") String name){
        pointService.saveAll(points, name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
