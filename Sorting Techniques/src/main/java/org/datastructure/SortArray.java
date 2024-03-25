package org.datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SortArray {

    private final int[] array;

    public SortArray(File file) throws FileNotFoundException {
        List<Integer> list = new ArrayList<>();
        Scanner fileScanner = new Scanner(file);
        String[] tokens = fileScanner.nextLine().split(",");
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            list.add(num);
        }
        this.array = list.stream().mapToInt(Integer::intValue).toArray();
    }

    public SortArray(int[] array) {
        this.array = array;
    }
    public List<int[]> simpleSort(boolean intermediate) {
        List<int[]> steps = new ArrayList<>();
        int[] arr = array.clone();
        long comparisons = 0;
        long swaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                ++comparisons;
                if (arr[j] > arr[j + 1]) {
                    ++swaps;
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    if (intermediate) steps.add(arr.clone());
                }
            }
            if (!swapped) break;
        }
        System.out.println("Array length: " + arr.length);
        System.out.println("Comparisons:  " + comparisons);
        System.out.println("Swaps:        " + swaps);
        if (steps.isEmpty()) steps.add(arr);
        return steps;
    }

    public List<int[]> efficientSort(boolean intermediate) {
        List<int[]> steps = new ArrayList<>();
        int[] arr = array.clone();
        List<Integer> pivots = new ArrayList<>();
        QuickSort(arr, 0, arr.length - 1, intermediate, steps, pivots);
        if (intermediate)
            steps.add(pivots.stream().mapToInt(Integer::intValue).toArray());
        if (!intermediate)
            steps.add(arr);
        return steps;
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
        if (steps.isEmpty()) steps.add(sorted);
        return steps;
    }

    private void random(int[] sorted, int low, int high) {
        Random rand = new Random(1);
        int pivot = rand.nextInt(high - low) + low;
        int temp = sorted[pivot];
        sorted[pivot] = sorted[high];
        sorted[high] = temp;
    }

    private int quick_sort(int[] OriginalArray, int start, int end, boolean intermediate, List<int[]> steps) {
        random(OriginalArray, start, end);
        int pivot_element = OriginalArray[end];
        int pivot_index = start - 1;
        for (int i = start; i < end; i++) {
            if (OriginalArray[i] < pivot_element) {
                pivot_index++;
                if (pivot_index != i) {
                    int temp = OriginalArray[i];
                    OriginalArray[i] = OriginalArray[pivot_index];
                    OriginalArray[pivot_index] = temp;
                }
            }
        }
        pivot_index++;
        int temp = OriginalArray[pivot_index];
        OriginalArray[pivot_index] = OriginalArray[end];
        OriginalArray[end] = temp;
        if (intermediate)
            steps.add(OriginalArray.clone());
        return pivot_index;
    }

    public void QuickSort(int[] OriginalArray, int start, int end, boolean intermediate, List<int[]> steps, List<Integer> pivots) {
        if (start < end) {
            int pivot = quick_sort(OriginalArray, start, end, intermediate, steps);
            if (intermediate)
                pivots.add(pivot);
            QuickSort(OriginalArray, start, pivot - 1, intermediate, steps, pivots);
            QuickSort(OriginalArray, pivot + 1, end, intermediate, steps, pivots);
        }
    }
}