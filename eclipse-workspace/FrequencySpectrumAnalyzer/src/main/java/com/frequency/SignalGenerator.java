
package com.frequency;

public class SignalGenerator {

    public static double[] generateSignal(
            int sampleCount,
            double samplingRate,
            double... frequencies) {

        double[] signal = new double[sampleCount];

        for (int i = 0; i < sampleCount; i++) {

            double time = i / samplingRate;

            for (double frequency : frequencies) {

                signal[i] += Math.sin(
                    2 * Math.PI * frequency * time
                );
            }
        }

        return signal;
    }
}
