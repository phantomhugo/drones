package com.hugo.drones.repository;

import com.hugo.drones.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hugo
 */
public interface MedicationRepository extends JpaRepository<Medication, String> {

}
