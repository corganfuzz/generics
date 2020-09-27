package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
            Integer[] list = {1, 4, 4, 2, 5, -3, 6, 2};
            Integer searchKey = Integer.valueOf("2");
            ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(list));

            boolean listResult = Search.linearSearch(list, searchKey);
            boolean collectionResult = Search.linearSearch(arrList, searchKey);

            System.out.println("Given " + searchKey + " as the search key, is it present in the Object? " + listResult);
            System.out.println("Given " + searchKey + " as the search key, is it present in the Object? " + collectionResult);
        }
    }

    public static void main(String[] args) {
        Search.linearSearchListAndCollections();
//        sortingArraysGenerically();


    }
}
