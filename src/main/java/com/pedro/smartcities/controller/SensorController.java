package com.pedro.smartcities.controller;

import com.pedro.smartcities.entity.Sensor;
import com.pedro.smartcities.repository.SensorRepository;
import com.pedro.smartcities.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sensor criar(@RequestBody @Valid Sensor sensor){
        return service.criar(sensor);
    }

    @GetMapping
    public List<Sensor> listar(){
        return service.listarTodos();
    }

    @GetMapping("/status")
    public String checkStatus() {
        return "Aplicação online!";
    }
}
