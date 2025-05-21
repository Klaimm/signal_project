package com.cardio_generator.outputs;

/**
 * Interface for output strategies used in the health data simulator.
 * <p>
 * Implementations of this interface define how generated patient data
 * is handled.
 */

public interface OutputStrategy {

    /**
     * Outputs a single data entry for a patient.
     *
     * @param patientId the unique identifier of the patient
     * @param timestamp the time at which the data was generated (epoch milliseconds)
     * @param label the type or label of the data (e.g., "ECG", "BloodPressure")
     * @param data  the actual data content to output
     */

    void output(int patientId, long timestamp, String label, String data);
}
