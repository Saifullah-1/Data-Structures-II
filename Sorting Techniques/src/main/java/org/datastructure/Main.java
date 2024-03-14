package org.datastructure;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            // Ask user for file path
            System.out.print("Enter file Path: ");
            String filePath = sc.nextLine();
            SortArray sortArray = new SortArray();
            // Print the menu [1] Simple Sort [2] Efficient Sort [3] Non-Comparison Sort [4] exit
            // Ask user if he wants intermediate arrays
        }
    }
}