package com.company;

import java.io.*;
import java.util.List;

/**
 * Created by Bogdan Kornev
 * on 26.05.2015, 21:23.
 */
public class NoiseHelper {
    private static int[] probabilityMatrix1 = {1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1};
    private static int[] probabilityMatrix0 = {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0};

    public static void makeNoisyPatterns(List<double[]> patterns, String dir) {
        for (int i = 0; i < patterns.size(); i++) {
            double[] vector = patterns.get(i);
            File file = new File(dir + "/" + (i + 1));
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try (PrintStream printStream = new PrintStream(new FileOutputStream(file))) {
                MatrixPrinter.printMatrix(makeNoise(vector), printStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static double[] makeNoise(double[] vector) {
        MatrixPrinter.printMatrix(vector, System.out);
        System.out.println();
        for (int i = 0; i < vector.length; i++) {
            double n = vector[i];
//            int random = n == 1 ?
//                    probabilityMatrix1[(int) (Math.random() * probabilityMatrix1.length)] :
//                    probabilityMatrix0[(int) (Math.random() * probabilityMatrix0.length)];
//            vector[i] = n == 1 ?
//                    n * random :
//                    n + random;
            if (vector[i] == 1) {
                continue;
            }
            int random = probabilityMatrix0[(int) (Math.random() * probabilityMatrix0.length)];
            vector[i] = vector[i] + random;
        }
        MatrixPrinter.printMatrix(vector, System.out);
        System.out.println();
        System.out.println();
        return vector;
    }
}
