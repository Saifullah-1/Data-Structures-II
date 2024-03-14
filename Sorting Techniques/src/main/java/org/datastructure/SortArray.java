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
        List<int[]> ans = new ArrayList<>();
        int[] currentArray = array.clone(); // Clone the original array to avoid modifying it directly.
        ans.add(currentArray.clone()); // Add a clone of the current state to the list.
        for (int i = 0; i < currentArray.length - 1; i++) {
            for (int j = 0; j < currentArray.length - i - 1; j++) {
                if (currentArray[j] > currentArray[j + 1]) {
                    int temp = currentArray[j];
                    currentArray[j] = currentArray[j + 1];
                    currentArray[j + 1] = temp;

                    // Change happens -> New intermediate array.
                    if (intermediate) {
                        ans.add(currentArray.clone()); // Add a clone of the current state.
                    }
                }
            }
        }
        if (!intermediate) ans.add(currentArray); // Add the final sorted array if intermediate is false.
        return ans;
    }

    public List<int[]> efficientSort(boolean intermediate) {
        return null;
    }

    public List<int[]> nonComparisonSort(boolean intermediate) {
        return null;
    }

}