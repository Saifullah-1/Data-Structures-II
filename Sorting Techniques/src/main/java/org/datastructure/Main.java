package org.datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void printList(List<List<Integer>> list) {

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            // Ask user for file path
            System.out.print("Enter file Path: ");
            String filePath = sc.nextLine();
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found!");
                continue;
            }
            SortArray sortArray = new SortArray(file);
            // Print the menu [1] Simple Sort [2] Efficient Sort [3] Non-Comparison Sort [4] exit
            System.out.println("Please select sort type: [1] Simple Sort [2] Efficient Sort [3] Non-Comparison Sort");
            int sortType = sc.nextInt();
            char ch;
            List<List<Integer>> list;
            switch (sortType) {
                case 1:
                    // Ask user if he wants intermediate arrays
                    System.out.print("Do you want intermediate arrays? Y/N");
                    ch = sc.next().charAt(0);
                    switch (ch) {
                        case 'Y': case 'y':
                            list = sortArray.simpleSort(true);
                            // print list
                            printList(list);
                            break;
                        case 'N': case 'n':
                            list = sortArray.simpleSort(false);
                            // print list
                            printList(list);
                            break;
                        default:
                            // TODO
                            break;
                    }
                    break;
                case 2:
                    // Ask user if he wants intermediate arrays
                    System.out.print("Do you want intermediate arrays? Y/N");
                    ch = sc.next().charAt(0);
                    switch (ch) {
                        case 'Y': case 'y':
                            list = sortArray.efficientSort(true);
                            // print list
                            printList(list);
                            break;
                        case 'N': case 'n':
                            list = sortArray.efficientSort(false);
                            // print list
                            printList(list);
                            break;
                        default:
                            // TODO
                            break;
                    }
                    break;
                case 3:
                    // Ask user if he wants intermediate arrays
                    System.out.print("Do you want intermediate arrays? Y/N");
                    ch = sc.next().charAt(0);
                    switch (ch) {
                        case 'Y': case 'y':
                            list = sortArray.nonComparisonSort(true);
                            // print list
                            printList(list);
                            break;
                        case 'N': case 'n':
                            list = sortArray.nonComparisonSort(false);
                            // print list
                            printList(list);
                            break;
                        default:
                            // TODO
                            break;
                    }
                    break;
            }
        }
    }
}