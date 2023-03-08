package com.hugo.drones;

import com.hugo.drones.utils.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hugo
 */
public class ValidatorTest {

    @Test
    void validateInvalidMedicationNameString() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validMedicationName("%%%");
        }, "");
        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validMedicationName("Hola%%%");
        }, "");
    }

    @Test
    void validateValidMedicationNameString() {
        Assertions.assertDoesNotThrow(() -> {
            Validator.validMedicationName("Hola");
        });
        Assertions.assertDoesNotThrow(() -> {
            Validator.validMedicationName("Hola-_");
        });
    }
}
