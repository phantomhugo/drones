package com.hugo.drones.restservice;

import com.hugo.drones.exceptions.MedicationNotFoundException;
import com.hugo.drones.model.Medication;
import com.hugo.drones.repository.MedicationRepository;
import com.hugo.drones.utils.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hugo
 */
@RestController
public class MedicationController {

    private final MedicationRepository repository;

    public MedicationController(MedicationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/medication")
    public Medication addMedication(@RequestBody Medication med) {
        return repository.save(med);
    }

    @PutMapping("/medication/{name}")
    public Medication updateMedication(@RequestBody Medication med, @PathVariable String name) {
        Validator.notNull(med);
        Validator.notNull(repository.findById(med.getName()));
        return repository.save(med);
    }

    @GetMapping("/medication/{name}")
    public Medication getMedication(@PathVariable String name) throws MedicationNotFoundException {
        return repository.findById(name).orElseThrow(() -> new MedicationNotFoundException(name));
    }
}
