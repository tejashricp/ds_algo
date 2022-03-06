package array;


/*
* Re-arrange Sorted Array in Max/Min Form
*
* Given an array, can you re-arrange the elements such that the first position will have the largest number,
* the second will have the smallest, the third will have the second-largest, and so on.
*
* i/p : arr = {1, 2, 3, 4, 5}
* o/p : arr = {5, 1, 4, 2, 3}
*
*
* trick : how to store 2 numbers at same index?
*
* */
public class MaxMinPatternSortedArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        generateMaxMinPattern(arr);
        for (int j : arr) {
            System.out.print(j + ",");
        }
    }

    private static void generateMaxMinPattern(int[] arr) {
        int n = arr.length;
        int maxId = n-1;
        int minId = 0;
        int multiplyer = arr[maxId] + 1;

        for(int i=0;i<n;i++){
            //even indices
            if(i % 2 == 0){
                arr[i] = arr[i] + (arr[maxId] % multiplyer * multiplyer);
                maxId--;
            }
            else {
                arr[i] = arr[i] + (arr[minId] % multiplyer * multiplyer);
                minId++;
            }
        }

        for(int i=0;i<n;i++){
            arr[i] = arr[i] / multiplyer;
        }
    }
}
