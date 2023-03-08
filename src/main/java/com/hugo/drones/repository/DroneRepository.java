package com.hugo.drones.repository;

import com.hugo.drones.model.Drone;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author hugo
 */
public interface DroneRepository extends JpaRepository<Drone, String> {

    List<Drone> findByMedicationNull();

    List<Drone> findByMedicationNotNull();
}
