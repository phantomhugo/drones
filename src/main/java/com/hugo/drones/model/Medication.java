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
public class Medication implements Serializable {

    @Id
    private String name;
    @Column
    private double weight;
    @Column
    private String code;
    @Column
    private String image;
}
