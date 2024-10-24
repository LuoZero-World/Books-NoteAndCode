package ProgrammingPearls.Chapter2;

import java.util.Arrays;

public class Chapter2 {
    public static void main(String[] args) {
        CyclicDisplacement cd = new CyclicDisplacement();

        Arrays.stream(cd.method1()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(cd.method2()).forEach(System.out::println);
    }
}
