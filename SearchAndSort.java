import java.util.Arrays;

public class SearchAndSort {
    // Method to perform binary search on a sorted array
    public static int binarySearch(int[] array, int searchValue) {
        // Sort the array using bubble sort (asc) from BubbleSort class
        array = BubbleSort.bubbleSort(array, "asc");

        // Perform binary search
        return binarySearchRecursive(array, searchValue, 0, array.length - 1);
    }

    // Recursive method for binary search
    private static int binarySearchRecursive(int[] array, int searchValue, int left, int right) {
        // Base case: if the search range is invalid
        if (left > right) {
            return -1; // Not found
        }

        // Calculate mid point
        int mid = left + (right - left) / 2;

        // Check if the search value is found at mid
        if (array[mid] == searchValue) {
            // Check if mid is the first occurrence of search value
            while (mid > 0 && array[mid - 1] == searchValue) {
                mid--;
            }
            return mid;
        } else if (array[mid] < searchValue) {
            // Recursively search in the right half
            return binarySearchRecursive(array, searchValue, mid + 1, right);
        } else {
            // Recursively search in the left half
            return binarySearchRecursive(array, searchValue, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        // Example arrays
        int[] array1 = {3, 6, 2, 4};
        int[] array2 = {1, 5, 8, 9, 10};

        // Example search values
        int searchValue1 = 4;
        int searchValue2 = 5;

        // Perform binary search and print results
        int index1 = binarySearch(array1, searchValue1);
        int index2 = binarySearch(array2, searchValue2);

        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Search value 1: " + searchValue1);
        System.out.println("Index of first occurrence in sorted array1: " + index1);

        System.out.println();

        System.out.println("Array2: " + Arrays.toString(array2));
        System.out.println("Search value 2: " + searchValue2);
        System.out.println("Index of first occurrence in sorted array2: " + index2);
    }
}

