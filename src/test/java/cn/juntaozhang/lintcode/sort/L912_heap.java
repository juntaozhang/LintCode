package cn.juntaozhang.lintcode.sort;

import java.util.Arrays;

public class L912_heap {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L912_heap().sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(new L912_heap().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }

    public int[] sortArray(int[] nums) {
        buildMaxHeap(nums);
        System.out.println("buildMaxHeap:" + Arrays.toString(nums));
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            swap(nums, 0, len - 1 - i);
            maxHeapify(nums, len - 1 - i, 0);
            System.out.println(i + ":" + Arrays.toString(nums));
        }
        return nums;
    }

    public void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            maxHeapify(nums, nums.length, i);
        }
    }

    public void maxHeapify(int[] nums, int len, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < len && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < len && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, len, largest);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
