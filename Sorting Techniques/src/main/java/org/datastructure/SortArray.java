package org.datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortArray {
    private List<Integer> list = new ArrayList<>();

    public SortArray(File file) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        String []in = fileScanner.nextLine().split(", ");
        for (int i = 0; i < in.length; ++i) {
            int num = Integer.parseInt(in[i]);
            list.add(num);
//            System.out.print(num + " ");
        }
    }

    public List<List<Integer>> simpleSort(boolean intermediate) {
        return null;
    }

    public List<List<Integer>> efficientSort(boolean intermediate) {
        return null;
    }

    public List<List<Integer>> nonComparisonSort(boolean intermediate) {
        return null;
    }
}