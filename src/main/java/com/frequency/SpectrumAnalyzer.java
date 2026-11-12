
package com.frequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.jtransforms.fft.DoubleFFT_1D;

public class SpectrumAnalyzer {

    public List<FrequencyComponent> analyze(
            double[] samples, double samplingRate) {

        if (samples == null || samples.length < 2) {
            throw new IllegalArgumentException(
                "At least 2 samples are required");
        }

        if (samplingRate <= 0) {
            throw new IllegalArgumentException(
                "Sampling rate must be positive");
        }

        int n = samples.length;

        // Prepare FFT input
        double[] fftData = new double[2 * n];

        for (int i = 0; i < n; i++) {
            fftData[i] = samples[i];
        }

        // Perform FFT
        DoubleFFT_1D fft = new DoubleFFT_1D(n);
        fft.realForwardFull(fftData);

        List<FrequencyComponent> results =
                new ArrayList<>();

        // Calculate frequency and magnitude
        for (int k = 1; k <= n / 2; k++) {

            double real = fftData[2 * k];
            double imaginary = fftData[2 * k + 1];

            double magnitude =
                    Math.sqrt(real * real +
                              imaginary * imaginary) / n;

            // Single-sided amplitude spectrum
            if (k < n / 2) {
                magnitude *= 2.0;
            }

            double frequency =
                    (double) k * samplingRate / n;

            results.add(
                new FrequencyComponent(
                    frequency, magnitude
                )
            );
        }

        // Sort by highest magnitude
        results.sort(
            Comparator.comparingDouble(
                FrequencyComponent::getMagnitude
            ).reversed()
        );

        return results;
    }
}
