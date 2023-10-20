package org.example.tipisProjectServer.restControllers;

import jakarta.validation.Valid;
import org.example.tipisProjectServer.dto.HouseDto;
import org.example.tipisProjectServer.serviceImpl.HouseServiceImpl;
import org.example.tipisProjectServer.util.HouseError;
import org.example.tipisProjectServer.util.HouseNotAddedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HouseController {
    private final HouseServiceImpl houseService;
    @Autowired
    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/houses")
    public List<HouseDto> getAllHouses(){
        return houseService.findAll();
    }

    @PostMapping("/houses")
    public HttpEntity<HttpStatus> addNewHouse(@RequestBody @Valid HouseDto houseDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors){
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";\n");
            }
            throw new HouseNotAddedException(errorMsg.toString());
        }
        houseService.save(houseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ExceptionHandler
    public HttpEntity<HouseError> handleException(HouseNotAddedException houseNotAddedException){
        HouseError response = new HouseError(
                houseNotAddedException.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
