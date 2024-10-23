package DesignPattern.Composite;

public class Main {
    public static void main(String[] args){
        Directory d1 = new Directory("root");
        Directory d2 = new Directory("bin");
        Directory d3 = new Directory("src");

        d1.add(d2).add(d3);
        
        Directory d4 = new Directory("pipi");
        Directory d5 = new Directory("jackLi");
        d2.add(d4).add(d5);

        d3.add(new File("ppap.txt", 100));
        d2.add(new File("wa.txt", 1234));
        d4.add(new File("jj.java", 1998)).add(new File("mdg.php", 1009));
        
        Entry f1 = new File("io.c", 100);
        d5.add(f1);

        
        System.out.println(f1.getMyPath());
    }
}
