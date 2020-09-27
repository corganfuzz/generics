package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Sort {
        static <E extends Comparable<E>> void sortG(E[] list) {
            E currentMin;
            int currentMinIndex;

            for (int i = 0; i < list.length - 1; i++) {
                currentMin = list[i];
                currentMinIndex = i;

                for (int j = i + 1; j < list.length; j++) {
                    if (currentMin.compareTo(list[j]) > 0) {
                        currentMin = list[j];
                        currentMinIndex = j;
                    }
                }
                if (currentMinIndex != i) {
                    list[currentMinIndex] = list[i];
                    list[i] = currentMin;
                }
            }
        }

        static void printList(Object[] list) {
            for (Object o : list) {
                System.out.print(o + " ");
            }
            System.out.println();
        }

        static void sortingArraysGenerically() {
            System.out.println();
            System.out.println("SORTING (length and array itself required)");
            System.out.println("==========================================\n");
            Scanner sc = new Scanner(System.in);
            System.out.print("How many elements do you want to enter: ");

            int length = sc.nextInt();
            String[] myArray = new String[length];

            System.out.print("Enter " + length + " elements ONLY, please: ");
            for (int i = 0; i < length; i++) {
                myArray[i] = sc.next();
            }
            sortG(myArray);
            printList(myArray);
        }
    }

    static class Search {
        static <U> boolean linearSearch(U[] list, U key) {
            for (U item : list) {
                if (item.equals(key)) {
                    return true;
                }
            }
            return false;
        }

        static <U> boolean linearSearch(Iterable<U> collection, U key) {
            for (U u : collection) {
                if (u.equals(key)) {
                    return true;
                }
            }
            return false;
        }

        static void linearSearchListAndCollections() {
            System.out.println();
            System.out.println("LINEAR SEARCH");
            System.out.println("=============\n");
            Integer[] list = {1, 4, 4, 2, 5, -3, 6, 2};
            Integer searchKey = Integer.valueOf("2");
            ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(list));

            boolean listResult = Search.linearSearch(list, searchKey);
            boolean collectionResult = Search.linearSearch(arrList, searchKey);

            System.out.println("Given " + searchKey + " as the search key, is it present in the Object? " + listResult);
            System.out.println("Given " + searchKey + " as the search key, is it present in the Object? " + collectionResult);
        }
    }

    static class Menu {
        static int displayMenu() {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("==========================================\n");
            System.out.println("MAKE A SELECTION");
            System.out.println("==========================================\n");
            System.out.println("1 - Sorting for any kind of Arrays");
            System.out.println("2 - Linear search an specific array generically ");
            System.out.println("3 - Exit ");
            return sc.nextInt();
        }

        static void itemExecution(int choice) {
            switch (choice) {
                case 1 -> Sort.sortingArraysGenerically();
                case 2 -> Search.linearSearchListAndCollections();
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid Selection only 1-3 available");
            }
        }

        static void userSelection() {
            int userChoice = Menu.displayMenu();
            Menu.itemExecution(userChoice);
        }
    }

    public static void main(String[] args) {
        Menu.userSelection();
    }
}
