package hacker.rank.interviewpreparation.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSort {
    
    @Test
    public void testMergeSort() {
        
        //int[] arr = {8, 4, 2, 3, 9, 6, 7, 5, 1};
        int[] arr = {2, 1, 3, 1, 2};
        
        //sort(arr, 0, arr.length - 1);
        int count = swapMergesort(arr, 0, arr.length - 1);
        
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(count);
        
    }
    
    public void mergeSort(int[] arr) {
        
        sort(arr, 0, arr.length);
        
    }
    
    private void sort(int[] arr, int begin, int end) {
        
        if (begin < end - 1) {
            int mid = (begin + end) / 2;
            
            sort(arr, begin, mid);
            sort(arr, mid, end);
            merge(arr, begin, mid, end);
        }
    }
    
    private void merge(int[] arr, int begin, int mid, int end) {
        int[] l = Arrays.copyOfRange(arr, begin, mid);
        int[] r = Arrays.copyOfRange(arr, mid, end);
        
        int lLength = mid - begin;
        int rLength = end - mid;
        
        int i = 0, j = 0, k = begin;
        
        while (i < lLength && j < rLength) {
            if (l[i] < r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        
        while (i < lLength) {
            arr[k++] = l[i++];
        }
        
        while (j < rLength) {
            arr[k++] = r[j++];
        }
        
    }
    
    private int swapMergesort(int[] arr, int begin, int end) {
        int count = 0;
        if (end - begin > 1) {
            int mid = (begin + end) / 2;
            
            count += swapMergesort(arr, begin, mid);
            count += swapMergesort(arr, mid + 1, end);
            count += swapMerge(arr, begin, mid, end);
        } else if (end - begin == 1) {
            if (arr[end] < arr[begin]) {
                swap(arr, begin, end);
                count++;
            }
        }
        
        return count;
    }
    
    private int swapMerge(int[] arr, int begin, int mid, int end) {
        
        int count = 0;
        int i = mid;
        int k = begin;
        
        while (i < end && arr[i] > arr[i + 1]) {
            
            int tmp = arr[i + 1];
            int j = i;
            
            do {
                arr[j + 1] = arr[j];
                j--;
                count++;
                
            } while (j >= k && arr[j] > tmp);
            
            arr[j + 1] = tmp;
            i++;
        }
        
        return count;
    }
    
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
