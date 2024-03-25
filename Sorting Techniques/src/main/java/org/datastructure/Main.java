package org.datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public enum SortingOption {
        SIMPLE,
        EFFICIENT,
        NON_COMPARISON
    }

    public static void printLists(List<int[]> lists) {
        for (int[] list : lists) {
            System.out.println(Arrays.toString(list));
        }
    }

    public static SortArray promptForFilePath() throws FileNotFoundException {
        File file;
        do {
            System.out.print("Enter file Path: ");
            String path = sc.nextLine();
            file = new File(path);
            if (!file.exists()) {
                System.out.println("Error: File not found: " + file.getAbsolutePath());
            }
        } while (!file.exists());

        return new SortArray(file);
    }

    public static SortingOption promptForSortingOption() {
        int userChoice;
        do {
            System.out.println("Select sort type:");
            System.out.println("[0] Simple Sort");
            System.out.println("[1] Efficient Sort");
            System.out.println("[2] Non-Comparison Sort");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 2.");
                sc.next();
            }
            userChoice = sc.nextInt();
            sc.nextLine();
            if (userChoice < 0 || userChoice > 2) {
                System.out.println("Invalid input. Please enter a number between 0 and 2.");
            }
        } while (userChoice < 0 || userChoice > 2);
        return SortingOption.values()[userChoice];
    }

    public static boolean promptForIntermediateArrays() {
        String userChoice;
        final List<String> yesGroup = List.of("y", "Y", "Yes", "yes", "YES");
        final List<String> noGroup = List.of("n", "N", "No", "no", "NO");
        do {
            System.out.print("Do you want to display intermediate arrays? (Y/N): ");
            userChoice = sc.nextLine();
            if (!yesGroup.contains(userChoice) && !noGroup.contains(userChoice)) {
                System.out.println("Invalid input, try again.");
            }
        } while (!yesGroup.contains(userChoice) && !noGroup.contains(userChoice));
        return yesGroup.contains(userChoice);
    }

    public static int promptForContinuationOption() {
        int userChoice;
        do {
            System.out.println("Select an option:");
            System.out.println("[0] Open a new file");
            System.out.println("[1] Continue with the same file");
            System.out.println("[2] Exit");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 2.");
                sc.next();
            }
            userChoice = sc.nextInt();
            sc.nextLine();
            if (userChoice < 0 || userChoice > 2) {
                System.out.println("Invalid input. Please enter a number between 0 and 2.");
            }
        } while (userChoice < 0 || userChoice > 2);
        return userChoice;
    }

    public static void main(String[] args) throws FileNotFoundException {
        SortArray sortArray = promptForFilePath();
        while (true) {
            SortingOption sortingOption = promptForSortingOption();
            boolean isIntermediate = promptForIntermediateArrays();
            List<int[]> sortedLists = switch (sortingOption) {
                case SIMPLE -> sortArray.simpleSort(isIntermediate);
                case EFFICIENT -> sortArray.efficientSort(isIntermediate);
                case NON_COMPARISON -> sortArray.nonComparisonSort(isIntermediate);
            };
            printLists(sortedLists);
            System.out.println("*****************");

            int continuationOption = promptForContinuationOption();
            if (continuationOption == 0) {
                sortArray = promptForFilePath();
            } else if (continuationOption == 2) {
                break;
            }
        }
    }
}