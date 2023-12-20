package org.example.tipisProjectServer.restControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.tipisProjectServer.dto.HouseDto;
import org.example.tipisProjectServer.serviceImpl.HouseServiceImpl;
import org.example.tipisProjectServer.util.HouseErrorHandler;
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
@Tag(name="Контроллер для необработанных данных о домах", description = "Методы для работы с данными (получение и отправка)")
public class HouseController {
    private final HouseServiceImpl houseService;
    @Autowired
    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/houses")
    @Operation(summary = "Получение всех записей о домах")
    public List<HouseDto> getAllHouses(){
        return houseService.findAll();
    }

    @PostMapping("/houses")
    @Operation(summary = "Отправка новых записей о домах")
    public HttpEntity<HttpStatus> addNewHouse(@RequestBody @Valid HouseDto[] houseDtoList, BindingResult bindingResult){
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
        houseService.save(houseDtoList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @ExceptionHandler
    public HttpEntity<HouseErrorHandler> handleException(HouseNotAddedException houseNotAddedException){
        HouseErrorHandler response = new HouseErrorHandler(
                houseNotAddedException.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
