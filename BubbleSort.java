import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] array, String order) {
        int n = array.length;
        boolean swapped = false; // Flag to track if any elements were swapped

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparisons and swapping
            for (int j = 0; j < n - 1 - i; j++) {
                // Determine the comparison condition based order
                boolean condition = (order.equals("asc")) ? (array[j] > array[j + 1]) : (array[j] < array[j + 1]);
                if (condition) {
                    // Swap elements if condition is true
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; // Set swapped to true indicating a swap occurred
                }
            }
        }

        // If no swapping occurred, array is already sorted
        if (!swapped) {
            System.out.println("Given array is already sorted");
        }

        return array; // Return the sorted array
    }

    public static void main(String[] args) {
        int[] array = { 10, 4, 2, 8, 11, 15 }; // Example array
        String order = "asc"; // Sorting order
        int[] sortedArray = bubbleSort(array, order); // Call the sorting method the array
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray)); // Print the sorted array
    }
}
