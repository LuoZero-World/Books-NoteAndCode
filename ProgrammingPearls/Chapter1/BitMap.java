package ProgrammingPearls.Chapter1;

/*
 * 位图，对int32格式的数的设置、清除和检测功能
 * N-表示该位图的容量，即可以存储0-N中的所有数
 */
public class BitMap {
    public static final int BITSPERWORD = 32;
    public static final int SHIFT = 5;
    public static final int MASK = 0x1F;
    public static final int N = 10000000;
    private int[] a = new int[1+N/BITSPERWORD];

    // 将位图中第i位置为1
    public void set(int i){
        a[i>>SHIFT] |= (1 << (i&MASK));
    }

    // 将位图中第i位置为0
    public void clear(int i){
        a[i>>SHIFT] &= ~(1 << (i&MASK));
    }

    // 检测位图中第i位是否为1
    public boolean test(int i){
        return (a[i>>SHIFT] & (1 << (i&MASK))) > 0;
    }
}
