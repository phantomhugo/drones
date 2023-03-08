package com.hugo.drones.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author hugo
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MedicationNotFoundException extends Exception {

    public MedicationNotFoundException(String id) {
        super("Medication not found, id requested " + id);
    }
}
