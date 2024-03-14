import java.util.ArrayList;
import java.util.Random;

public class quickSort {

    static class Iteration {
        int pivot;
        int[] intermediate;
    }

    ArrayList<Iteration> Intermediate_Arrays = new ArrayList<Iteration>();

    private void random(int[] sorted, int low, int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;
        int temp = sorted[pivot];
        sorted[pivot] = sorted[high];
        sorted[high] = temp;
    }

    private int quick_sort(int[] OriginalArray, int start, int end) {
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
        return pivot_index;
    }

    private void QuickSort(int[] OriginalArray, int start, int end) {
        if (start < end) {
            int pivot = quick_sort(OriginalArray, start, end);
            Iteration iteration = new Iteration();
            iteration.pivot = OriginalArray[pivot];
            iteration.intermediate = new int[OriginalArray.length];
            System.arraycopy(OriginalArray, 0, iteration.intermediate, 0, OriginalArray.length);
            Intermediate_Arrays.add(iteration);
            QuickSort(OriginalArray, start, pivot - 1);
            QuickSort(OriginalArray, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] test = {5, 6, 1, 3, 0, -5, 11};
        if (test.length == 0) {
            System.out.println("{}");
            return;
        }
        if (test.length == 1) {
            System.out.println("{" + test[0] + "}");
            return;
        }
        quickSort quickSort = new quickSort();
        quickSort.QuickSort(test, 0, test.length - 1);
        for (int i = 0; i < quickSort.Intermediate_Arrays.size(); i++) {
            System.out.print("pivot= " + quickSort.Intermediate_Arrays.get(i).pivot + "    ");
            for (int j = 0; j < test.length; j++) {
                System.out.print(quickSort.Intermediate_Arrays.get(i).intermediate[j] + " ");
            }
            System.out.println();
        }
    }
}