
package com.frequency;

public class PeakDetector {

    public static void detectPeaks(
            double[] magnitude,
            double samplingRate,
            int sampleCount) {

        System.out.println("\nFREQUENCY ANALYSIS RESULTS");
        System.out.println("--------------------------");

        for (int i = 1; i < magnitude.length - 1; i++) {

            if (magnitude[i] > magnitude[i - 1]
                    && magnitude[i] > magnitude[i + 1]
                    && magnitude[i] > 1.0) {

                double frequency =
                    (double) i * samplingRate / sampleCount;

                System.out.printf(
                    "Detected Frequency: %.2f Hz%n",
                    frequency
                );
            }
        }
    }
}

