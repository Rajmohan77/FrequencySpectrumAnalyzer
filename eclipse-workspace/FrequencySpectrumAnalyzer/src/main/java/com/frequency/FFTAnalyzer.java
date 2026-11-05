
package com.frequency;

public class FFTAnalyzer {

    public static double[] calculateFFT(double[] signal) {

        int n = signal.length;

        if (n == 0 || (n & (n - 1)) != 0) {
            throw new IllegalArgumentException(
                "Signal length must be a power of 2"
            );
        }

        double[] real = signal.clone();
        double[] imag = new double[n];

        // Bit reversal
        int j = 0;

        for (int i = 1; i < n; i++) {

            int bit = n >> 1;

            while ((j & bit) != 0) {
                j ^= bit;
                bit >>= 1;
            }

            j ^= bit;

            if (i < j) {
                double temp = real[i];
                real[i] = real[j];
                real[j] = temp;
            }
        }

        // FFT calculation
        for (int size = 2; size <= n; size *= 2) {

            double angle = -2 * Math.PI / size;

            double wReal = Math.cos(angle);
            double wImag = Math.sin(angle);

            for (int start = 0; start < n; start += size) {

                double currentReal = 1;
                double currentImag = 0;

                for (int k = 0; k < size / 2; k++) {

                    int even = start + k;
                    int odd = even + size / 2;

                    double oddReal =
                        currentReal * real[odd]
                        - currentImag * imag[odd];

                    double oddImag =
                        currentReal * imag[odd]
                        + currentImag * real[odd];

                    real[odd] = real[even] - oddReal;
                    imag[odd] = imag[even] - oddImag;

                    real[even] += oddReal;
                    imag[even] += oddImag;

                    double nextReal =
                        currentReal * wReal
                        - currentImag * wImag;

                    double nextImag =
                        currentReal * wImag
                        + currentImag * wReal;

                    currentReal = nextReal;
                    currentImag = nextImag;
                }
            }
        }

        // Calculate magnitude spectrum
        double[] magnitude = new double[n / 2];

        for (int i = 0; i < n / 2; i++) {
            magnitude[i] = Math.sqrt(
                real[i] * real[i] + imag[i] * imag[i]
            );
        }

        return magnitude;
    }
}

