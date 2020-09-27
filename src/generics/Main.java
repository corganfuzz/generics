package generics;

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

        System.out.print("Enter " + length + " only " + " elements, please: ");
        for (int i = 0; i < length; i++) {
            myArray[i] = sc.next();
        }
        sortG(myArray);
        printList(myArray);
    }

    public static void main(String[] args) {
        sortingArraysGenerically();
    }
}
