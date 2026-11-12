

package com.frequency;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            String filePath = args.length > 0
                    ? args[0] : "datasets/signal1.csv";

            double samplingRate = args.length > 1
                    ? Double.parseDouble(args[1]) : 1024.0;

            System.out.println("================================");
            System.out.println(" FREQUENCY SPECTRUM ANALYZER");
            System.out.println("================================");

            SignalReader reader = new SignalReader();

            double[] samples = reader.readCSV(filePath);

            System.out.println("Dataset: " + filePath);
            System.out.println("Samples: " + samples.length);
            System.out.println("Sampling Rate: "
                    + samplingRate + " Hz");

            SpectrumAnalyzer analyzer =
                    new SpectrumAnalyzer();

            List<FrequencyComponent> results =
                    analyzer.analyze(samples, samplingRate);

            System.out.println("\nFrequency Analysis Results");
            System.out.println("--------------------------------");

            int count = Math.min(10, results.size());

            for (int i = 0; i < count; i++) {
                System.out.println(results.get(i));
            }

            System.out.println("--------------------------------");
            System.out.println("Analysis Completed Successfully!");

        } catch (Exception e) {
            System.out.println("Analysis Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
