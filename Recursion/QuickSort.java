// How QuickSort Works
// 	• Divide and Conquer algorithm:
// 		○ Divide: Choose a pivot and partition the array into two halves: elements smaller than the pivot and elements larger than the pivot.
// 		○ Conquer: Recursively apply QuickSort on each half.


//   - Pivot Selection:
// 		○ The pivot can be chosen in various ways:
//         - First element.
//         - Last element.
//         - Random element (randomized QuickSort improves performance on average).


//   - In-Place Sorting:
//      - QuickSort sorts the array in place,
//      - requiring minimal extra memory (O(log N) for the recursion stack).


// Time Complexity
//     Best Case: O(NlogN)
//      - when the pivot divides the array into two nearly equal halves at every step.
//     Worst Case: O(N*N)
//      - when the pivot is the smallest or largest element (e.g., already sorted or reverse-sorted input with poor pivot choice).


// Space complexity is O(logN) in the best and average cases (recursion depth).
// In the worst case, space complexity can reach O(N) due to skewed partitioning.


//Comparisons with Other Sorting Algorithms
//  MergeSort:
//      - QuickSort is faster for in-place sorting but has a worst-case time complexity of O(N*N) unlike MergeSort's guaranteed O(NlogN).
//      - MergeSort is stable, while QuickSort is not.
//  HeapSort:
//      - QuickSort generally performs better in practice due to better cache locality.
//  Insertion Sort:
//      - QuickSort is faster for large arrays, but Insertion Sort outperforms for small arrays.


//Practical Implementations
// Real-World Usage:
//      - Used in library functions like Python's sorted(), Java's Arrays.sort(), and C++'s std::sort() (often hybridized with other sorting techniques).


class QuickSort{
    static void swap(int arr[], int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static void quickSort(int arr[], int low, int high){
        if(low < high){
            int pi = sort(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    static int sort(int arr[], int low, int high){
        int randomNum = (int)(Math.random() * (high - low + 1)) + low;
        swap(arr, randomNum, low);
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j){
            while(arr[i] <= pivot && i < high)i++;
            while(arr[j] > pivot && j > low)j--;
            if(i < j)swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }
    public static void main(String[] args) {
        int arr[] = {4,6,1,2,5,7,4,9,1,3};
        quickSort(arr, 0, arr.length-1);
        for(int i: arr)System.out.print(i+" ");

    }
}