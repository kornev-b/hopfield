package com.company;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Bogdan Kornev
 * on 26.05.2015, 21:29.
 */
public class MatrixPrinter {
    public static void printMatrix(double[] vector, PrintStream printStream) {
        if (vector == null) {
            return;
        }
        int columns = (int) Math.sqrt(vector.length);
        for (int i = 0; i < vector.length; i++) {
            double n = vector[i];
            if ((i + 1) % columns == 0) {
                printStream.println(getSymbolFor(n));
            } else {
                printStream.print(getSymbolFor(n) + "\t");
            }
        }
    }

    private static String getSymbolFor(double n) {
        return n == -1 ? "." : "*";
    }
}
