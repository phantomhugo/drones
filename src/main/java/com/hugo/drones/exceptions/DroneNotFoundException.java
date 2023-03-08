package com.hugo.drones.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author hugo
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DroneNotFoundException extends Exception {

    public DroneNotFoundException(String id) {
        super("Drone not found, id requested " + id);
    }
}
