# Project Description

This project is a Java-based application that provides different sorting techniques for arrays of integers. The project is built with Maven.

## Data Structures

The project primarily uses arrays and lists to store and manipulate data. The `SortArray` class uses an integer array to store the numbers to be sorted. It also uses lists to store the steps of the sorting process when the intermediate flag is set to true.

## Algorithms

The project implements three different sorting algorithms:

1. **Simple Sort**: This is a basic bubble sort algorithm. It compares each pair of adjacent items and swaps them if they are in the wrong order. The pass through the list is repeated until no more swaps are needed.

2. **Efficient Sort**: This is a quick sort algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then recursively sorted.

3. **Non-Comparison Sort**: This is a counting sort algorithm. It operates by counting the number of objects that have distinct key values, and using arithmetic on those counts to determine the positions of each key value in the output sequence.

## Object-Oriented Programming

The project follows the principles of Object-Oriented Programming (OOP). It has classes like `SortArray` and `Main` which encapsulate the data and the methods that manipulate this data. The `SortArray` class has methods for each sorting algorithm and the `Main` class is responsible for user interaction and controlling the flow of the program.

## Key Features

- The project allows users to sort arrays using different algorithms.
- Users can choose to display intermediate steps of the sorting process.
- The project provides a command-line interface for user interaction.
- The project includes unit tests to ensure the correctness of the sorting algorithms.

## Important Files

- `SortArray.java`: This file contains the `SortArray` class which includes the implementation of the sorting algorithms.
- `Main.java`: This file contains the `Main` class which is the entry point of the application. It handles user interaction and controls the flow of the program.
- `SortArrayTest.java`: This file contains the unit tests for the `SortArray` class.

## How to Run

To run the project, navigate to the project directory and use the following command:

```bash
mvn exec:java -Dexec.mainClass="org.datastructure.Main"
```

You will be prompted to enter the path of the file containing the numbers to be sorted, choose the sorting algorithm, and decide whether to display intermediate steps.

# JUnit Testing

The project uses JUnit for unit testing. JUnit is a popular testing framework for Java, and it provides assertions to identify test method, test utilities for writing and running tests, and annotations to control the test procedures.

The `SortArrayTest` class in the `src/test/java/org/datastructure` directory contains the unit tests for the `SortArray` class. It uses parameterized tests with CSV file sources to test the sorting methods with different inputs and expected outputs.

The tests cover the following scenarios:

- Simple sort without intermediates
- Simple sort with intermediates
- Efficient sort without intermediates
- Efficient sort with intermediates
- Non-comparison sort without intermediates
- Non-comparison sort with intermediates

Each test case:

1. Creates a temporary file with the input numbers.
2. Initializes a `SortArray` object with the temporary file.
3. Calls the appropriate sorting method on the `SortArray` object.
4. Asserts that the final sorted array matches the expected output.

The CSV file used for the tests (`/test.csv`) contains two columns: the first column is the input (a string of comma-separated numbers), and the second column is the expected output (a string of comma-separated numbers in sorted order).

To run the tests, navigate to the project directory and use the following command:

```bash
mvn test
```

This command will run all the tests in the project and display the results in the console.

# Time and Space Complexity

The time and space complexity of the sorting algorithms used in this project are as follows:

## Time Complexity

The time complexity of an algorithm quantifies the amount of time taken by an algorithm to run, as a function of the size of the input to the program.

| Algorithm | Best Case | Average Case | Worst Case |
|-----------|-----------|--------------|------------|
| Simple Sort (Bubble Sort) | O(n) | O(n^2) | O(n^2) |
| Efficient Sort (Quick Sort) | O(n log n) | O(n log n) | O(n^2) |
| Non-Comparison Sort (Counting Sort) | O(n + k) | O(n + k) | O(n + k) |

Here, `n` is the number of elements to be sorted and `k` is the range of input.

## Space Complexity

The space complexity of an algorithm quantifies the amount of space or memory taken by an algorithm to run, as a function of the size of the input to the program.

| Algorithm | Space Complexity |
|-----------|------------------|
| Simple Sort (Bubble Sort) | O(1) |
| Efficient Sort (Quick Sort) | O(log n) |
| Non-Comparison Sort (Counting Sort) | O(n + k) |

Here, `n` is the number of elements to be sorted and `k` is the range of input.

## Comparison

When comparing these sorting algorithms, bubble sort is the simplest but least efficient with a time complexity of O(n^2) in both average and worst cases. Quick sort is more efficient with an average and best case time complexity of O(n log n), but it can degrade to O(n^2) in the worst case. Counting sort is the most efficient when the range of input (k) is not significantly greater than the number of elements (n), with a time complexity of O(n + k) in all cases. However, it uses more memory, with a space complexity of O(n + k).