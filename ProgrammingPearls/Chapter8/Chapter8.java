package ProgrammingPearls.Chapter8;

import java.util.Arrays;

public class Chapter8 {
    public static void main(String[] args) {
        SubArray subArray = new SubArray();
        int[] array = new int[]{-2, -1, 0, 1, 5, 11, 34};
        int[] closestToZero = subArray.findClosestToZero(array);
        int[] closestToGivenNums = subArray.findClosestToGivenNums(array, 43);

        Arrays.stream(closestToZero).forEach(a -> System.out.print(a+" "));
        System.out.println();
        Arrays.stream(closestToGivenNums).forEach(a -> System.out.print(a+" "));
    }
}
