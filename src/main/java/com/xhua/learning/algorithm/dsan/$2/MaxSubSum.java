package com.xhua.learning.algorithm.dsan.$2;

/**
 * 最大子序列和
 * P28
 * 使用分治算法实现
 * TODO:test
 */
public class MaxSubSum {
    private static int maxSubSum(int[] array) {
        return maxSumRec(array, 0, array.length - 1);
    }

    private static int maxSumRec(int[] array, int left, int right) {
        if (left == right) {
            return Math.max(array[left], 0);
        }
        int mid = (left + right) >> 1;
        int leftMax = maxSumRec(array, left, mid);
        int rightMax = maxSumRec(array, mid + 1, right);
//        int nextToMidLeftMax = Integer.MIN_VALUE;
        //这里不能置为0是因为当中线左边的值最大就小于0的，那我们就不加了呗，加了反而变小，所以置为0
        int nextToMidLeftMax = 0;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += array[i];
            if (sum > nextToMidLeftMax) {
                nextToMidLeftMax = sum;
            }
        }
//        int nextToMidRightMax = Integer.MIN_VALUE;
        int nextToMidRightMax = 0;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += array[i];
            if (sum > nextToMidRightMax) {
                nextToMidRightMax = sum;
            }
        }
        int nextToSum = nextToMidLeftMax + nextToMidRightMax;
        return Math.max(nextToSum, Math.max(leftMax, rightMax));
    }
}
