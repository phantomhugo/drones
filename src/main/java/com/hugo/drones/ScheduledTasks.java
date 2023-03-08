/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugo.drones;

/**
 *
 * @author hugo
 */
import com.hugo.drones.model.Drone;
import com.hugo.drones.repository.DroneRepository;
import com.hugo.drones.restservice.DroneController;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    DroneRepository droneRepository;
    @Autowired
    DroneController droneController;

    @Scheduled(fixedRate = 5000)
    public void reportDroneState() {
        List<Drone> drones = droneController.listDrones();
        log.info("Checking drones battery");
        for (Drone elem : drones) {
            if (elem.getBatteryPercentage() < 25) {
                log.info("The drone {} has les than 25% battery", elem.getSerialNumber());
            }

        }
    }
}
