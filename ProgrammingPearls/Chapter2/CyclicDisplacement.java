package ProgrammingPearls.Chapter2;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * 将x[N]向左旋转D个位置
 */
public class CyclicDisplacement {
    private static final int N = 10;
    private static final int D = 3;
    private int[] x;

    public CyclicDisplacement(){
        x = IntStream.range(0, N).toArray();
    }

    public int[] method1(){
        int[] res = Arrays.copyOf(x, N);
        int fin = gcd(D, N);
        for(int i = 0; i < fin; i++){       //分成gcd(D, N)次来移动
            int t = res[i], j = i;
            while(true){
                int k = j+D;
                if(k >= N) k -= N;
                if(k == i) break;
                res[j] = res[k];    
                j = k;
            }
            res[j] = t;
        }
        return res;
    }

    /*
     * res[0 ..p-i-1] 数组前面已经旋好的部分
     * res[p-i ..p-1]  = a
     * res[p ..p+j-1] = b
     * res[p+j ..n-1] 数组后面已经旋好的部分
     * 目标是要交换a b (a,b不等长)
     */
    public int[] method2(){
        int[] res = Arrays.copyOf(x, N);
        int i = D, p = D, j = N-p;
        while(i != j){
            if(i > j){      // al ar br --> br ar al ,br已经旋好了
                swap(res, p-i, p, j);
                i -= j;
            } else {        // al bl br --> br bl al ,al已经旋转好了
                swap(res, p-i, p-i+j, i);
                j -= i;
            }
        }
        swap(res, p-i, p, i);
        return res;
    }

    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    /*
     * 交换a[idx1 ..idx1+m-1] 和 a[idx2 ..idx2+m-1]
     */
    private void swap(int[] a, int idx1, int idx2, int m){
        for(int i = 0; i < m; i++){
            int t = a[idx1+i];
            a[idx1+i] = a[idx2+i];
            a[idx2+i] = t;
        }
    }
}
