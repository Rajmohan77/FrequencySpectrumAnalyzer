
package com.frequency;

public class FrequencyComponent {

    private double frequencyHz;
    private double magnitude;

    public FrequencyComponent(double frequencyHz, double magnitude) {
        this.frequencyHz = frequencyHz;
        this.magnitude = magnitude;
    }

    public double getFrequencyHz() {
        return frequencyHz;
    }

    public double getMagnitude() {
        return magnitude;
    }

    @Override
    public String toString() {
        return String.format(
            "Frequency: %.2f Hz | Magnitude: %.4f",
            frequencyHz,
            magnitude
        );
    }
}
