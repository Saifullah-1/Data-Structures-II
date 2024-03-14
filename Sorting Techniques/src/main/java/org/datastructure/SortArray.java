package org.datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortArray {

    private final int[] array;
    public SortArray(File file) throws FileNotFoundException {
        List<Integer> list = new ArrayList<>();
        Scanner fileScanner = new Scanner(file);
        String[] tokens = fileScanner.nextLine().split(", ");
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            list.add(num);
        }
        this.array = list.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<int[]> simpleSort(boolean intermediate) {
        List<int[]> steps = new ArrayList<>();
        int[] arr = array.clone();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    if (intermediate) steps.add(arr.clone());

                }
            }
        }
        if (!intermediate) steps.add(arr);
        return steps;
    }

    public List<int[]> efficientSort(boolean intermediate) {
        return null;
    }

    public List<int[]> nonComparisonSort(boolean intermediate) {
        List<int[]> steps = new ArrayList<>();
        int[] arr = array.clone();

        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (int x : arr) {
            mx = Math.max(mx, x);
            mn = Math.min(mn, x);
        }

        int[] countArray = new int[mx - mn + 1];

        for (int x : arr) ++countArray[x - mn];

        for (int i = 1; i < countArray.length; ++i) {
            countArray[i] += countArray[i - 1];
        }

        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; --i) {
            sorted[countArray[arr[i] - mn] - 1] = arr[i];
            if (intermediate) steps.add(sorted.clone());
            --countArray[arr[i] - mn];
        }
        if (!intermediate) steps.add(sorted.clone());
        return steps;
    }
}