package org.datastructure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortArrayTest {

    private static Stream<Arguments> streamOfFiles() {
        final String path = "C:\\Users\\alsha\\IdeaProjects\\Data-Structures-II\\Sorting Techniques\\src\\test\\resources\\";
        String[] fileNames = {
                "01-reversed-ne5-ke8.txt", // takes a long time
                "02-sorted-ne5-ke8.txt",
                "03-empty.txt",
                "04-identical-ne4.txt",
                "05-identical-ne3.txt",
                "06-random-ne3-ke.txt",
                "07-single-element.txt",
                "08-negative-ne4-ke8.txt",
                "09-two-elements-ke8.txt",
                "10-two-elements-ke9.txt",
                "12-reversed-ne5-ke0.txt",
//                "11-bubble-stress-ne6-ke2.txt", // does not finish in simple sort.
        };

        return Stream.of(fileNames).flatMap(fileName -> {
            File file = new File(path + fileName);
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                br.readLine(); // Skip input string word
                int inputSize = Integer.parseInt(br.readLine());
                int[] input = new int[inputSize];
                for (int i = 0; i < inputSize; i++) {
                    input[i] = Integer.parseInt(br.readLine());
                }
                br.readLine(); // Skip expected string word
                int expectedSize = Integer.parseInt(br.readLine());
                int[] expected = new int[expectedSize];
                for (int i = 0; i < expectedSize; i++) {
                    expected[i] = Integer.parseInt(br.readLine());
                }
                // Skip stars line
                return Stream.of(Arguments.of(input, expected));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @ParameterizedTest
    @MethodSource("streamOfFiles")
    void simpleSortWithoutIntermediates(int[] input, int[] expected) {
        SortArray sortArray = new SortArray(input);
        List<int[]> result = sortArray.simpleSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("streamOfFiles")
    void efficientSortWithoutIntermediates(int[] input, int[] expected) {
        SortArray sortArray = new SortArray(input);
        List<int[]> result = sortArray.efficientSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("streamOfFiles")
    void nonComparisonSortWithoutIntermediates(int[] input, int[] expected) {
        SortArray sortArray = new SortArray(input);
        List<int[]> result = null;
        try {
            result = sortArray.nonComparisonSort(false);
        } catch (OutOfMemoryError e) {
            System.gc(); // Suggest garbage collection
        }
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(expected);
    }

    private static Stream<Arguments> streamOfArrays() throws IOException {
        final String path = "C:\\Users\\alsha\\IdeaProjects\\Data-Structures-II\\Sorting Techniques\\src\\test\\resources\\";
        File file = new File(path + "14-increasing-size.txt");
//        File file = new File(path + "15-counting-vs-quick.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        return Stream.generate(() -> {
            try {
                br.readLine(); // read input string word.
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int inputSize;
            try {
                inputSize = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int[] input = new int[inputSize];
            for (int i = 0; i < inputSize; i++) {
                try {
                    input[i] = Integer.parseInt(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                br.readLine(); // read expected string word.
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int expectedSize;
            try {
                expectedSize = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int[] expected = new int[expectedSize];
            for (int i = 0; i < expectedSize; i++) {
                try {
                    expected[i] = Integer.parseInt(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                br.readLine(); // read stars line.
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return Arguments.of(input, expected);
        }).limit(1);  // Control the number of tests
    }

    @ParameterizedTest
    @MethodSource("streamOfArrays")
    void simpleSortStress(int[] input, int[] expected) {
        SortArray sortArray = new SortArray(input);
        List<int[]> result = sortArray.simpleSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("streamOfArrays")
    void efficientSortStress(int[] input, int[] expected) {
        SortArray sortArray = new SortArray(input);
        List<int[]> result = sortArray.efficientSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("streamOfArrays")
    void nonComparisonSortStress(int[] input, int[] expected) {
        SortArray sortArray = new SortArray(input);
        List<int[]> result = sortArray.nonComparisonSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(expected);
    }


    @Test
    void simpleSortLongs() throws FileNotFoundException {
        File input = new File("C:\\Users\\alsha\\IdeaProjects\\Data-Structures-II\\Sorting Techniques\\src\\test\\resources\\13-longs.txt");
        Long[] expected = {2218556890522892383L, 5076885383333679745L, 5879138130930366493L, 6741987804016584860L};
        SortArray sortArray = new SortArray(input);
        List<int[]> result = sortArray.simpleSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(expected);
    }

    @Test
    void efficientSortLongs() throws FileNotFoundException {
        File input = new File("C:\\Users\\alsha\\IdeaProjects\\Data-Structures-II\\Sorting Techniques\\src\\test\\resources\\13-longs.txt");
        Long[] expected = {2218556890522892383L, 5076885383333679745L, 5879138130930366493L, 6741987804016584860L};
        SortArray sortArray = new SortArray(input);
        List<int[]> result = sortArray.efficientSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(expected);
    }

    @Test
    void nonComparisonSortLongs() throws FileNotFoundException {
        File input = new File("C:\\Users\\alsha\\IdeaProjects\\Data-Structures-II\\Sorting Techniques\\src\\test\\resources\\13-longs.txt");
        Long[] expected = {2218556890522892383L, 5076885383333679745L, 5879138130930366493L, 6741987804016584860L};

        SortArray sortArray = new SortArray(input);
        List<int[]> result = sortArray.nonComparisonSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(expected);
    }

}