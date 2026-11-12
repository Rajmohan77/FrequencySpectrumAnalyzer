
package com.frequency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class SignalReader {

    public double[] readCSV(String filePath)
            throws IOException {

        List<String> lines =
                Files.readAllLines(Path.of(filePath));

        List<Double> values = new ArrayList<>();

        for (String line : lines) {

            if (line.trim().isEmpty()) {
                continue;
            }

            String[] columns = line.split(",");

            double value =
                    Double.parseDouble(columns[0].trim());

            values.add(value);
        }

        double[] samples = new double[values.size()];

        for (int i = 0; i < values.size(); i++) {
            samples[i] = values.get(i);
        }

        return samples;
    }
}
