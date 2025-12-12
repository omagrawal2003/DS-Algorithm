package sorting; // declare this class is in the 'sorting' package

public class mergeSortUsingRecursion { // define the class

    // recursive merge sort: returns a new sorted array containing elements from arr[left..right]
    public static int[] mergeSort(int[] arr, int left, int right) {
        // if the provided range is invalid (left > right), return an empty array
        if (left > right) {
            return new int[0];
        }
        // base case: single element range, return an array with that single element
        if (left == right) {
            return new int[] { arr[left] };
        }
        // compute mid avoiding potential overflow: left + (right - left) / 2
        int mid = left + (right - left) / 2;

        // recursively sort left half [left..mid]
        int[] arr1 = mergeSort(arr, left, mid);
        // recursively sort right half [mid+1..right]
        int[] arr2 = mergeSort(arr, mid + 1, right);

        // merge the two sorted halves and return the merged sorted array
        return merge(arr1, arr2);
    }

    // merge two sorted arrays leftArr and rightArr into one sorted array
    public static int[] merge(int[] leftArr, int[] rightArr) {
        int n1 = leftArr.length; // length of left array
        int n2 = rightArr.length; // length of right array
        int[] mergedArr = new int[n1 + n2]; // result array of combined size

        int i = 0, j = 0, k = 0; // i: index for leftArr, j: for rightArr, k: for mergedArr

        // while both arrays have remaining elements, pick the smaller current element
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                mergedArr[k] = leftArr[i]; // take from leftArr when it's smaller or equal
                i++; // advance left index
                k++; // advance merged index
            } else {
                mergedArr[k] = rightArr[j]; // take from rightArr when it's smaller
                j++; // advance right index
                k++; // advance merged index
            }
        }

        // copy any remaining elements from leftArr (if rightArr exhausted)
        while (i < n1) {
            mergedArr[k++] = leftArr[i++]; // copy and advance both k and i
        }

        // copy any remaining elements from rightArr (if leftArr exhausted)
        while (j < n2) {
            mergedArr[k++] = rightArr[j++]; // copy and advance both k and j
        }

        return mergedArr; // return the merged sorted array
    }

    // helper to print array contents on one line separated by spaces
    public static void printArray(int[] arr) {
        for (int num : arr) { // for-each loop over array elements
            System.out.print(num + " "); // print element followed by a space
        }
        System.out.println(); // print newline after all elements
    }

    // program entry point: demonstrates merge sort on a sample array
    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 }; // sample unsorted array
        printArray(arr); // print original array
        arr = mergeSort(arr, 0, arr.length - 1); // sort entire array using mergeSort
        System.out.println("Sorted array:");
        printArray(arr); // print sorted array
    }
}
