package ProgrammingPearls.Chapter11;

/*
 * 快速排序就是分治，若划分标准为pivot，那目标就是将当前区间划分为 >=pivot 和 <=pivot
 */
public class Qsort {
    
    //快速排序 [l,r]
    public void qsort(int[] array, int l, int r){
        if(l >= r) return;
        //选[l, r]中第一个元素为主元素
        int pivot = array[l], m = l;
        for(int i = l+1; i <= r; i++){
            //小于主元素，填入左边
            if(array[i] < pivot){
                int t = array[++m];
                array[m] = array[i];
                array[i] = t;
            }
        }
        //最后将主元素交换到对应位置
        array[l] = array[m];
        array[m] = pivot;

        //子区间排序
        qsort(array, l, m-1);
        qsort(array, m+1, r);
    }

    //上述排序算法，在输入均相同，或总体升序的情况下时间复杂度退化为O(n^2)
    //使用双向划分解决输入均相同的情况，使用随机选取pivot解决总体升序的情况
    public void qsort2(int[] array, int l, int r){
        if(l >= r) return;
        //选[l, r]中中间数(向上取)作为主元素
        int i = l - 1, j = r + 1, pivot = array[l+r+1 >> 1];
        while(i < j)
        {
            do i++; while(array[i] < pivot);
            do j--; while(array[j] > pivot);
            if(i < j){
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            } 
        }
        
        //选择用i划分，那么pivot必须向上取
        //否则会无限递归 e.g. array = [1,2]
        qsort2(array, l, i-1);
        qsort2(array, i, r);
    }
}
