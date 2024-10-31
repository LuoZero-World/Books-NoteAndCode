package ProgrammingPearls.Chapter4;

import java.util.stream.IntStream;

public class BinarySearch {
    private int[] array, power = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536};
    private int t, st;

    public BinarySearch(int n, int target){
        array = IntStream.rangeClosed(1, n).toArray();
        t = target;
        for(int p : power){
            if(n < p){
                st = (p>>1);
                break;
            }
        }
    }

    //经典二分
    public int bs1(){
        int l = 0, r = array.length-1;
        while(l < r){
            int mid = l+(r-l)/2;
            if(array[mid] < t) l = mid+1;
            else r = mid; 
        }
        return r;
    }

    //优化后的二分
    //使用下限值l以及增量i(i总为2的幂)，暗含r=l+i，mid=l+i/2
    public int bs2(){
        int i = st, l = -1, n = array.length;
        if(array[i-1] < t) l = n-i;     
        while(i > 1){
            i /= 2;
            if(array[l+i] < t) l += i;
        }
        l += 1;
        return l;
    }
}
