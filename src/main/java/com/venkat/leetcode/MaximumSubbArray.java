package com.venkat.leetcode;

import java.util.Arrays;
import java.util.List;

public class MaximumSubbArray {

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        int value = maxSubArray(nums);
        System.out.println("max value: "+value);
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(currentSum < 0) {
                currentSum = 0;
            }
            currentSum = currentSum + nums[i];
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }
}
