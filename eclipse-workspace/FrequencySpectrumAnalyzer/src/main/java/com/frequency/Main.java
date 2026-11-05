
package com.frequency;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("   FREQUENCY SPECTRUM ANALYZER");
        System.out.println("==================================");

        int sampleCount = 1024;
        double samplingRate = 1024.0;

        // Generate three input frequencies
        double[] signal = SignalGenerator.generateSignal(
            sampleCount,
            samplingRate,
            50.0,
            100.0,
            200.0
        );

        System.out.println("\nInput Signal Generated!");
        System.out.println("Sampling Rate: " + samplingRate + " Hz");
        System.out.println("Sample Count: " + sampleCount);

        // Perform FFT
        double[] spectrum = FFTAnalyzer.calculateFFT(signal);

        System.out.println("\nFFT Calculation Completed!");

        // Detect frequency peaks
        PeakDetector.detectPeaks(
            spectrum,
            samplingRate,
            sampleCount
        );

        System.out.println("\n==================================");
        System.out.println("   ANALYSIS COMPLETED SUCCESSFULLY");
        System.out.println("==================================");
    }
}
