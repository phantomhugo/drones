package com.hugo.drones.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author hugo
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class DroneLowBatteryException extends Exception {

    public DroneLowBatteryException(String id) {
        super("Drone has low battery level, id requested " + id);
    }
}
