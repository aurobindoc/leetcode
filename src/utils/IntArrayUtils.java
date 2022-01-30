package utils;

/**
 * Created by aurobindo.m on 30/01/22
 */
public class IntArrayUtils {
    public static void printList(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + " ]");
    }

    public static void swapList(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
