package ProgrammingPearls.Chapter11;

import java.util.Random;

/*
 * 三路快速排序是快速排序和基数排序的混合。它的算法思想基于 荷兰国旗问题 的解法
 * 三路快速排序在处理含有多个重复值的数组时，效率远高于原始快速排序
 */
public class ThreeWayQsort {

    private Random random = new Random();

    public void threeWayQsort(int[] array, int l, int r){
        if(l >= r) return;

        int pivot = array[l+random.nextInt(r-l+1)];
        int i = l, p_start = l, p_end = r;

        while (i <= p_end) {
            if(array[i] > pivot){
                int t = array[p_end];
                array[p_end--] = array[i];
                array[i] = t;
            } else if(array[i] < pivot){
                if(p_start != i){
                    array[p_start] = array[p_start]^array[i];
                    array[i] = array[p_start]^array[i];
                    array[p_start] = array[p_start]^array[i];
                }
                p_start++;
                i++;
            } else i++;
        }

        threeWayQsort(array, l, p_start-1);
        threeWayQsort(array, p_end+1, r);
    }
}
