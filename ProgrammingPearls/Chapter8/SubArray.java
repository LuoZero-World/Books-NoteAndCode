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
            int diff = prefixSumsWithIdx[i][1] - prefixSumsWithIdx[i-1][1];
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
    public int[] findClosestToGivenNums(int[] nums, int t) {
       /*  前缀和+二分
        *  但此时不能和找接近0的子数组代码一样：直接对前缀和数组进行排序，然后对前缀和数组中每个数k 依次二分查找另一个数k'使得k'-k=t
        *  原因在于：假设排序后k和k'所对应的位置信息为i、i'
        *  如果i'>i 那么这个子数组和确实接近t；但若i>i' 那么这个子数组和实际上接近-t
        */

        /*
         * 因此二分查找所需的数据结构，既要保持元素有序，也要有【元素所对应位置都在当前被查元素之前】这一【顺序】特性
         * 不再对前缀和数组排序，使用TreeMap
         * 遍历前缀和数组，在每一次迭代时将当前元素k存入TreeMap，然后在TreeMap中二分查找 k-t
         */
        return new int[]{};
    }
}
