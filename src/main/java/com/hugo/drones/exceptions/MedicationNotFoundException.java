package com.hugo.drones.exceptions;

/**
 *
 * @author hugo
 */
public class MedicationNotFoundException extends Exception {

    public MedicationNotFoundException(String id) {
        super("Medication not found, id requested " + id);
    }
}
