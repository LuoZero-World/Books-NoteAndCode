package ProgrammingPearls.Chapter11;

public class Chapter11 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 4, 23, 77, 78, -4, 15};
        // KthSmallestElement kElement = new KthSmallestElement(a);
        // for(int i = 1; i <= a.length; i++){
        //     int num = kElement.getKthSmallestElement(0, a.length-1, i);
        //     System.out.println(num);
        // }

        ThreeWayQsort tQsort = new ThreeWayQsort();
        tQsort.threeWayQsort(a, 0, a.length-1);
        for(int i : a){
            System.out.print(i+" ");
        }
    }
}
