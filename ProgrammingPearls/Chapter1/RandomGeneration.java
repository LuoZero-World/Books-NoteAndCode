package ProgrammingPearls.Chapter1;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/*
 * 生成位于0至n-1之间的k个不同的随机顺序的随机整数
 */
public class RandomGeneration {
    public static final int N = 10000;
    public static final int K = 5;

    public int[] rand(){
        int[] array = IntStream.range(0, N).toArray();
        Random r = new Random(System.currentTimeMillis());
        for(int i = 0; i < K; i++){
            int pos = r.nextInt(i, N);
            int a = array[pos];
            array[pos] = array[i];
            array[i] = a;
        }
        return Arrays.copyOf(array, K);
    }
}
