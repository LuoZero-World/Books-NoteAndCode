package ProgrammingPearls.Chapter11;

/*
 * 快速排序就是分治，若划分标准为pivot，那目标就是将当前区间划分为 >=pivot 和 <=pivot
 *  均为升序排序
 */
public class Qsort {

    private static int THRESHOLD = 5;
    
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

    //使用朴素优化的快速排序
    //上述排序算法，在输入均相同，或总体升序的情况下时间复杂度退化为O(n^2)
    //使用双向划分解决输入均相同的情况，使用 pivot=三数取中 解决总体升序的情况
    public void qsort2(int[] array, int l, int r){
        if(l >= r) return;
        // 小数组时执行插入排序
        if(r-l <= THRESHOLD){
            insertionSort(array, l, r);
            return;
        }

        int i = l - 1, j = r + 1, pivot = getAndSetMidNum(array, l, r, l+r >> 1);

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
        
        qsort2(array, l, i-1);
        qsort2(array, i, r);
    }

    // 插入排序
    private void insertionSort(int[] arr, int l, int r){
        for (int i = l; i <= r ; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > l && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) arr[j] = tmp;
        }
    }

    //找到中间值 并将数组中间位置的值与中间值交换
    private int getAndSetMidNum(int[] array, int i1, int i2, int i3){
        int a = array[i1], b = array[i2], c = array[i3];
        if(a >= b && b >= c || c >= b && b >= a){
            array[i3] = b;
            array[i2] = c;
            return b;
        }
        if(b >= a && a >= c || c >= a && a >= b){
            array[i3] = a;
            array[i1] = c;
            return a;
        } 
        return c;
    }
}
