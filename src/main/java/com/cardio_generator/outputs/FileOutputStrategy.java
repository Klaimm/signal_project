package com.cardio_generator.outputs;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Output strategy that writes patient data to text files.
 * <p>
 * Each label (e.g., "ECG", "BloodPressure") corresponds to a separate file
 * within the specified base directory.
 */

//Changed class first letter to match file name
public class FileOutputStrategy implements OutputStrategy {

    private String BaseDirectory;

    public final ConcurrentHashMap<String, String> file_map = new ConcurrentHashMap<>();

    /**
     * Constructs a FileOutputStrategy with the given base directory.
     *
     * @param baseDirectory the directory where output files will be stored
     */

    //Changed constructor name to match class name
    public FileOutputStrategy(String baseDirectory) {

        this.BaseDirectory = baseDirectory;
    }

    /**
     * Outputs patient data to a label-specific file in the base directory.
     *
     * @param patientId the patient ID
     * @param timestamp the timestamp of the data
     * @param label the data label (e.g., "ECG", "OxygenSaturation")
     * @param data the actual data to write
     */

    @Override
    public void output(int patientId, long timestamp, String label, String data) {
        try {
            // Create the directory
            Files.createDirectories(Paths.get(BaseDirectory));
        } catch (IOException e) {
            System.err.println("Error creating base directory: " + e.getMessage());
            return;
        }
        // Set the FilePath variable

        //Changed variable name to lowerCase
        String filePath = file_map.computeIfAbsent(label, k -> Paths.get(BaseDirectory, label + ".txt").toString());

        // Write the data to the file
        try (PrintWriter out = new PrintWriter(
                Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.printf("Patient ID: %d, Timestamp: %d, Label: %s, Data: %s%n", patientId, timestamp, label, data);
        } catch (Exception e) {
            System.err.println("Error writing to file " + filePath + ": " + e.getMessage());
        }
    }
}