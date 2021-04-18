package leetcode.amazon.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class KthLargestElementInArray {
    
    @Test
    public void testSample1() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        assertThat(findKthLargest(arr, 2)).isEqualTo(5);
    }
    
    @Test
    public void testQuickSort() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        quickSortAll(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
    
    public int findKthLargest(int[] nums, int k) {
        
        quickSortKthLargest(nums, 0, nums.length - 1, k);
        
        return nums[k - 1];
        
    }
    
    private void quickSortKthLargest(int[] nums, int begin, int end, int k) {
        if (end > begin) {
            int pi = partition(nums, begin, end);
            
            if (pi > k-1) {
                quickSortKthLargest(nums, begin, pi - 1, k);
            } else if (pi < k-1) {
                quickSortKthLargest(nums, pi, end, k);
            }
        }
    }
    
    private void quickSortAll(int[] nums, int begin, int end) {
        if (begin < end) {
            int pi = partition(nums, begin, end);
            
            quickSortAll(nums, begin, pi - 1);
            quickSortAll(nums, pi + 1, end);
        }
    }
    
    private int partition(int[] nums, int begin, int end) {
        
        int pivot = nums[end];
        int i = begin;
        for (int j = begin; j < end; j++) {
            if (nums[j] > pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        
        swap(nums, i, end);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}
