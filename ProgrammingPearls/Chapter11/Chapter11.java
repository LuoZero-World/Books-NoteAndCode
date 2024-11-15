package ProgrammingPearls.Chapter11;

public class Chapter11 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 4, 23, 77, 78, -4, 15};
        Qsort q = new Qsort();
        q.qsort(a, 0, a.length-1);

        for(int i : a){
            System.out.println(i);
        }
    }
}
