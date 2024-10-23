package ProgrammingPearls.Chapter1;

public class Chapter1 {
    public static void main(String[] args) {
        NonInitArray a = new NonInitArray(100);
        a.set(15, 12);
        a.set(15, 11);
        System.out.println(a.get(15));
        a.set(0, 0);
        System.out.println(a.get(1));
    }
}
