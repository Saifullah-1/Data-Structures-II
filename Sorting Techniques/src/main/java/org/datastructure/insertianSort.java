public class insertianSort {

    public static int[][] insertion_sort(int[] OriginalArray) {
        int[][] Intermediate_Arrays = new int[OriginalArray.length][OriginalArray.length];
        for (int i = 1; i < OriginalArray.length; i++) {
            System.arraycopy(OriginalArray, 0, Intermediate_Arrays[i - 1], 0, OriginalArray.length);
            for (int j = 0; j < i; j++) {
                if (OriginalArray[i] < OriginalArray[j]) {
                    int temp = OriginalArray[i];
                    for (int k = i; k > j; k--)
                        OriginalArray[k] = OriginalArray[k - 1];
                    OriginalArray[j] = temp;
                    break;
                }
            }
        }
        System.arraycopy(OriginalArray, 0, Intermediate_Arrays[OriginalArray.length - 1], 0, OriginalArray.length);
        return Intermediate_Arrays;
    }

    public static void main(String[] args) {
        int[] test = {};
        if (test.length == 0) {
            System.out.println("{}");
            return;
        }
        int[][] result = insertion_sort(test);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();

        }
    }
}