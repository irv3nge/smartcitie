package com.pedro.smartcities.repository;

import com.pedro.smartcities.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
