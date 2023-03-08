package com.hugo.drones.exceptions;

/**
 *
 * @author hugo
 */
public class DroneNotFoundException extends Exception {

    public DroneNotFoundException(String id) {
        super("Drone not found, id requested " + id);
    }
}
