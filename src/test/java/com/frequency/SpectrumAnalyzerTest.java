
package com.frequency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SpectrumAnalyzerTest {

    @Test
    public void testFrequencyDetection() {

        int n = 1024;
        double fs = 1024.0;

        double[] samples = new double[n];

        for (int i = 0; i < n; i++) {
            samples[i] =
                Math.sin(2 * Math.PI * 50 * i / fs)
                + 0.5 * Math.sin(2 * Math.PI * 120 * i / fs);
        }

        SpectrumAnalyzer analyzer =
                new SpectrumAnalyzer();

        List<FrequencyComponent> results =
                analyzer.analyze(samples, fs);

        assertEquals(50.0,
                results.get(0).getFrequencyHz(), 0.01);

        assertEquals(120.0,
                results.get(1).getFrequencyHz(), 0.01);
    }

    @Test
    public void testInvalidInput() {

        SpectrumAnalyzer analyzer =
                new SpectrumAnalyzer();

        assertThrows(
            IllegalArgumentException.class,
            () -> analyzer.analyze(new double[0], 1024)
        );
    }
}
