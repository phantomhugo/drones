package com.hugo.drones.restservice;

import com.hugo.drones.model.Drone;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hugo
 */
@RestController
public class DroneController {

    @PostMapping("/drone")
    Drone addDrone(@RequestBody Drone drone) {
        return new Drone();
        //return repository.save(newEmployee);
    }

    @GetMapping("/drone/{id}")
    Drone getDrone(Integer idDrone) {
        return new Drone();
        //return repository.save(newEmployee);
    }
}
