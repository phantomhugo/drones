/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugo.drones.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author hugo
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class DroneExceedLoadException extends Exception {

    public DroneExceedLoadException(String id) {
        super("Drone has exceed weight cappacity, id requested " + id);
    }
}
