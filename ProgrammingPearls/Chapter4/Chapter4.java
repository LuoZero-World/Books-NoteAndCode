package ProgrammingPearls.Chapter4;

public class Chapter4 {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch(10000, 115);
        long timeMillis = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++)bs.bs1();
        // System.out.println(bs.bs1());
        System.out.println(System.currentTimeMillis()-timeMillis);

        timeMillis = System.currentTimeMillis();
        // System.out.println(bs.bs2());
        for(int i = 0; i < 10000000; i++)bs.bs2();
        System.out.println(System.currentTimeMillis()-timeMillis);
    }
}
