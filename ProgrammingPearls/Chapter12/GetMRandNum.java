package ProgrammingPearls.Chapter12;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/*
 * 从0 - n-1中获取m个随机数(m<=n)
 * 总共进行m次随机获取， 此法是方法2的一种变体
 * 优点是时间复杂度固定为O(mlogm) 缺点是每个子集的概率不相等
 */
public class GetMRandNum {

    public Set<Integer> getMRandNum(int m, int n){
        Set<Integer> res = new TreeSet<>();
        Random r = new Random(System.currentTimeMillis());

        for(int j = n-m; j < n; j++){
            int t = r.nextInt() % (j+1);
            if(res.contains(t)) res.add(j);
            else res.add(t);
        }

        return res;
    }

    public static void main(String[] args) {
        GetMRandNum r = new GetMRandNum();
        Set<Integer> mRandNum = r.getMRandNum(5, 20);
        for(int i : mRandNum){
            System.out.print(i+" ");
        }
    }
}
