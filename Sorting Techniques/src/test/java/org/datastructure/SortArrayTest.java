package org.datastructure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortArrayTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
    void simpleSortWithoutIntermediates(String input, String expected) throws IOException {
        File tempFile = createTempFileWithNumbers(input);
        SortArray sortArray = new SortArray(tempFile);
        List<int[]> result = sortArray.simpleSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(parseArray(expected));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
    void simpleSortWithIntermediates(String input, String expected) throws IOException {
        File tempFile = createTempFileWithNumbers(input);
        SortArray sortArray = new SortArray(tempFile);
        List<int[]> result = sortArray.simpleSort(true);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(parseArray(expected));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
    void efficientSortWithoutIntermediates(String input, String expected) throws IOException {
        File tempFile = createTempFileWithNumbers(input);
        SortArray sortArray = new SortArray(tempFile);
        List<int[]> result = sortArray.efficientSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 2)).isEqualTo(parseArray(expected));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
    void efficientSortWithIntermediates(String input, String expected) throws IOException {
        File tempFile = createTempFileWithNumbers(input);
        SortArray sortArray = new SortArray(tempFile);
        List<int[]> result = sortArray.efficientSort(true);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 2)).isEqualTo(parseArray(expected));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
    void nonComparisonSortWithoutIntermediates(String input, String expected) throws IOException {
        File tempFile = createTempFileWithNumbers(input);
        SortArray sortArray = new SortArray(tempFile);
        List<int[]> result = sortArray.nonComparisonSort(false);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(parseArray(expected));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
    void nonComparisonSortWithIntermediates(String input, String expected) throws IOException {
        File tempFile = createTempFileWithNumbers(input);
        SortArray sortArray = new SortArray(tempFile);
        List<int[]> result = sortArray.nonComparisonSort(true);
        assertThat(result).isNotNull();
        assertThat(result.get(result.size() - 1)).isEqualTo(parseArray(expected));
    }

    private File createTempFileWithNumbers(String numbers) throws IOException {
        File tempFile = File.createTempFile("tempFile", ".txt");
        PrintWriter out = new PrintWriter(tempFile);
        out.println(numbers);
        out.close();
        return tempFile;
    }

    private int[] parseArray(String numbers) {
        return Arrays.stream(numbers.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}