package org.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class quickSort {

    List<int[]> steps= new ArrayList<int []>();

    private void random(int[] sorted, int low, int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;
        int temp = sorted[pivot];
        sorted[pivot] = sorted[high];
        sorted[high] = temp;
    }

    private int quick_sort(int[] OriginalArray, int start, int end,boolean intermediate) {
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
        steps.add(OriginalArray.clone());
        pivot_index++;
        int temp = OriginalArray[pivot_index];
        OriginalArray[pivot_index] = OriginalArray[end];
        OriginalArray[end] = temp;
        return pivot_index;
    }

    public void QuickSort(int[] OriginalArray, int start, int end,boolean intermediate) {
        if (start < end) {
            int pivot = quick_sort(OriginalArray, start, end,intermediate);
            QuickSort(OriginalArray, start, pivot - 1,intermediate);
            QuickSort(OriginalArray, pivot + 1, end,intermediate);
        }
    }
}