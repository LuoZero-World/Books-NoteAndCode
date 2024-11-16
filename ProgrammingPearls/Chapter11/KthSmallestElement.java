package ProgrammingPearls.Chapter11;

/*
 * 在O(n)时间内找到数组中第K小的元素
 * 最坏情况下 排序所用时间为n*(1+1/2+1/4+...+1/(2^k))~O(n), k=logn
 */
public class KthSmallestElement {
    private int[] array;

    public KthSmallestElement(int[] array){
        this.array = array;
    }

    //返回第k小元素 k > 0
    public int getKthSmallestElement(int l, int r, int k){
        // assert(l <= r);
        if(l == r) return array[l];
        int i = l, j = r + 1, pivot = array[l];

        while(i <= j)
        {
            do i++; while(i <= r && array[i] < pivot);
            do j--; while(array[j] > pivot);
            if(i < j){
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            } 
        }
        array[l] = array[j];
        array[j] = pivot;

        if(j+1 < k) return getKthSmallestElement(j+1, r, k);
        else if(j+1 == k) return array[j];
        else return getKthSmallestElement(l, j-1, k);
    }
}
