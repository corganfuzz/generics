package generics;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static double[] selectionSort(double[] list) {

        for (int i = 0; i < list.length - 1; i++) {

            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        return list;
    }

    static double[] ArrayInputChecker() {
        Scanner s = new Scanner(System.in);
        System.out.print("How many elements do you want to enter: ");
        int length = s.nextInt();
        double[] myArray = new double[length];
        System.out.print("Enter " + length + " elements, please: ");
        for (int i = 0; i < length; i++) {
            myArray[i] = s.nextDouble();
        }
        return myArray;
    }

    static void printedResult() {
        double[] myArray = ArrayInputChecker();
        System.out.print("\n");
        System.out.println("Your array is " + Arrays.toString(myArray));
        System.out.println("==============================================");
        String printedResult = Arrays.toString(selectionSort(myArray));
        System.out.println("Your sorted array is " + printedResult);
    }

    public static void main(String[] args) {
        printedResult();
    }
}
