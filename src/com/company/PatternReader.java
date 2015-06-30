package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Bogdan Kornev
 * on 28.05.2015, 5:02.
 */
public class PatternReader {
    public static List<double[]> getPatterns(String dir, int patternLength) {
        List<double[]> patterns = new ArrayList<>();
        File dirLearn = new File(dir);
        File[] files = dirLearn.listFiles();
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                try {
                    int n1 = Integer.parseInt(o1.getName());
                    int n2 = Integer.parseInt(o2.getName());
                    return n1 > n2 ? 1 : (n1 < n2) ? -1 : 0;
                } catch (NumberFormatException e) {
                    return o1.compareTo(o2);
                }
            }
        });
        for (File file : files) {
            patterns.add(getVectorFromFile(file, patternLength));
        }
        return patterns;
    }

    public static double[] getVectorFromFile(File file, int size) {
        double[] vector = new double[size];
        try (Scanner sc = new Scanner(file)) {
            for (int i = 0; i < size; i++) {
                if (!sc.hasNext()) {
                    break;
                }
                vector[i] = sc.nextInt() == 1 ? 1 : -1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return vector;
    }
}
