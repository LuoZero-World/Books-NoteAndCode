package ProgrammingPearls.Chapter8;

import java.util.Arrays;

/*
 * 一系列 求子数组和的问题
 */
public class SubArray {

    //求子数组和最接近0 的子数组
    //求前缀和数组，然后对其排序，找数值最邻近的两个位置
    public int[] findClosestToZero(int[] nums) {
        int n = nums.length;
        int[][] prefixSumsWithIdx = new int[n][2];

        prefixSumsWithIdx[0][0] = 0;
        prefixSumsWithIdx[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSumsWithIdx[i][0] = i;
            prefixSumsWithIdx[i][1] = prefixSumsWithIdx[i-1][1] + nums[i];
        }

        Arrays.sort(prefixSumsWithIdx, (a, b)->a[1]-b[1]);

        int minDiff = Integer.MAX_VALUE;
        int start = 0, end = 0;

        for (int i = 1; i < n; i++) {
            int diff = Math.abs(prefixSumsWithIdx[i][1] - prefixSumsWithIdx[i-1][1]);
            if (diff < minDiff) {
                minDiff = diff;
                //[start, end]
                start = Math.min(prefixSumsWithIdx[i][0], prefixSumsWithIdx[i-1][0])+1;
                end = Math.max(prefixSumsWithIdx[i][0], prefixSumsWithIdx[i-1][0]);
            }
        }

        //[start, end+1)
        return Arrays.copyOfRange(nums, start, end+1);
    }

    //求子数组和最接近t 的子数组
    //前缀和+二分
}
