package com.cardio_generator.generators;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * Interface for patient data generators.
 * <p>
 * Classes implementing this interface are responsible for generating
 * health-related data (e.g., ECG, blood pressure) for a specific patient
 * and sending it through a provided output strategy.
 *
 */

public interface PatientDataGenerator {

    /**
     * Generates and outputs patient data for the given patient ID.
     *
     * @param patientId unique identifier of the patient
     * @param outputStrategy strategy used for the generated data
     */

    void generate(int patientId, OutputStrategy outputStrategy);
}
