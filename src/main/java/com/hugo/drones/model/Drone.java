package com.hugo.drones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

import lombok.Data;

/**
 *
 * @author hugo
 */
@Entity
@Data
public class Drone implements Serializable {

    public static final int MODEL_LIGHT_WEIGHT = 0;
    public static final int MODEL_MIDDLE_WEIGHT = 1;
    public static final int MODEL_CRUISER_WEIGHT = 2;
    public static final int MODEL_HEAVY_WEIGHT = 3;
    public static final int STATE_IDLE = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_LOADED = 2;
    public static final int STATE_DELIVERING = 3;
    public static final int STATE_RETURNING = 4;
    @Id
    @Column(length = 100)
    private String serialNumber;

    @Column
    private int model;
    @Column
    private double weightLimit;
    @Column
    private int batteryPercentage;
    @Column
    private int droneState;

}
