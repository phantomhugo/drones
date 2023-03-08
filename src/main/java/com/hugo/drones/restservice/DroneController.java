package com.hugo.drones.restservice;

import com.hugo.drones.exceptions.DroneNotFoundException;
import com.hugo.drones.model.Drone;
import com.hugo.drones.repository.DroneRepository;
import com.hugo.drones.utils.Validator;
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

    private final DroneRepository repository;

    public DroneController(DroneRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/drone")
    public Drone addDrone(@RequestBody Drone drone) {
        Validator.notNull(drone);
        return repository.save(drone);
    }

    @PutMapping("/drone/{id}")
    public Drone updateDrone(@RequestBody Drone drone, @PathVariable String id) {
        Validator.notNull(drone);
        Validator.notNull(repository.findById(drone.getSerialNumber()));
        return repository.save(drone);
    }

    @GetMapping("/drone/{id}")
    public Drone getDrone(@PathVariable String id) throws DroneNotFoundException {
        return repository.findById(id).orElseThrow(() -> new DroneNotFoundException(id));
    }

}
