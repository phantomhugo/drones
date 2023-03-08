package com.hugo.drones.restservice;

import com.hugo.drones.exceptions.DroneExceedLoadException;
import com.hugo.drones.exceptions.DroneLowBatteryException;
import com.hugo.drones.exceptions.DroneNotFoundException;
import com.hugo.drones.model.Drone;
import com.hugo.drones.model.Medication;
import com.hugo.drones.repository.DroneRepository;
import com.hugo.drones.utils.Validator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        Validator.checkLenght(drone.getSerialNumber(), 100);
        return repository.save(drone);
    }

    @GetMapping("/drone")
    public List<Drone> listDrones() {
        return repository.findAll();
    }

    @GetMapping("/drone/available")
    public List<Drone> listAvailableDrones() {
        List<Drone> result = new ArrayList<>();
        result.addAll(repository.findByMedicationNull());
        List<Drone> loadedDrones = repository.findByMedicationNotNull();
        for (Drone elem : loadedDrones) {
            if (elem.getCurrentWeight() < elem.getWeightLimit()) {
                result.add(elem);
            }
        }
        return result;
    }

    @PutMapping("/drone/{id}")
    public Drone updateDrone(@RequestBody Drone drone, @PathVariable String id) {
        Validator.notNull(drone);
        Validator.checkLenght(drone.getSerialNumber(), 100);
        Validator.notNull(repository.findById(drone.getSerialNumber()));
        return repository.save(drone);
    }

    @GetMapping("/drone/{id}")
    public Drone getDrone(@PathVariable String id) throws DroneNotFoundException {
        return repository.findById(id).orElseThrow(() -> new DroneNotFoundException(id));
    }

    @PostMapping("/drone/{id}/load")
    public Drone addLoad(@RequestBody List<Medication> load, @PathVariable String id) throws DroneNotFoundException, DroneLowBatteryException, DroneExceedLoadException {
        Drone currentDrone = getDrone(id);
        repository.save(currentDrone);
        if (currentDrone.getBatteryPercentage() < 25) {
            throw new DroneLowBatteryException(id);
        }
        currentDrone.setDroneState(Drone.STATE_LOADING);
        double droneCarriedWeight = currentDrone.getCurrentWeight();
        for (Medication elem : load) {
            if (elem.getWeight() + droneCarriedWeight <= currentDrone.getWeightLimit()) {
                currentDrone.getMedication().add(elem);
            } else {
                throw new DroneExceedLoadException(id);
            }
        }
        currentDrone.setDroneState(Drone.STATE_LOADED);
        return repository.save(currentDrone);
    }

    @GetMapping("/drone/{id}/load")
    public List<Medication> getCurrentLoad(@PathVariable String id) throws DroneNotFoundException {
        Drone currentDrone = getDrone(id);
        return currentDrone.getMedication();
    }

    @GetMapping("/drone/{id}/battery")
    public int getCurrentBattery(@PathVariable String id) throws DroneNotFoundException {
        Drone currentDrone = getDrone(id);
        return currentDrone.getBatteryPercentage();
    }
}
