package org.example.tipisProjectServer.restControllers;

import org.example.tipisProjectServer.models.Graphic;
import org.example.tipisProjectServer.serviceImpl.GraphicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GraphicController {
    private final GraphicServiceImpl graphicService;

    @Autowired
    public GraphicController(GraphicServiceImpl graphicService) {
        this.graphicService = graphicService;
    }

    @GetMapping("/graphic")
    public List<Graphic> getAllFromGraphic(){
        return graphicService.findAll();
    }

    @PostMapping("/graphic")
    public HttpEntity<HttpStatus> saveNewGraphic(@RequestBody Graphic graphic){
        graphicService.save(graphic);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
