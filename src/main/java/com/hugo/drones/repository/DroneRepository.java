package com.hugo.drones.repository;

import com.hugo.drones.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hugo
 */
public interface DroneRepository extends JpaRepository<Drone, String> {

}
