package com.pedro.smartcities.service;


import com.pedro.smartcities.entity.Sensor;
import com.pedro.smartcities.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository repository ;

    public SensorService(SensorRepository repository){

        this.repository = repository ;
    }

    public Sensor criar(Sensor sensor){

        return repository.save(sensor);
    }

    public List<Sensor> listarTodos(){

        return repository.findAll();
    }
}
