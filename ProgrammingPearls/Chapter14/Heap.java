package ProgrammingPearls.Chapter14;

//小根堆,容量不可变
public class Heap {
    int[] arrheap;
    int size;       //当前大小
    int capacity;   //当前容量
    public static void main(String[] args){
        int[] arr = new int[]{23, 44, 1, 17, 78, 84, 23};
        Heap.Sort(arr);
        for(int t : arr) System.out.print(t+" ");
    }

    //创建
    Heap(int[] arr, boolean ifInsert){
        int len = arr.length;
        if(ifInsert){
            capacity = len + 100;
            arrheap = new int[capacity];
            size = 0;
            for(int i = 0; i < len; i++){
                insert(arr[i]);
            }
        } else{
            arrheap = arr;
            size = len;
        }
    }

    //添加
    private void insert(int value){
        //说明不能再存了
        if(size == capacity) return;
        arrheap[size++] = value;
        ShiftUp(size-1);
    }

    //获取堆顶元素
    @SuppressWarnings("unused")
    private int extractMin(){
        if(size == 0) return -1;
        return arrheap[0];
    }

    //堆排序 (原地排序)
    public static void Sort(int[] arrayToBeSorted){
        Heap heap_tmp = new Heap(arrayToBeSorted, false);
        int n = arrayToBeSorted.length;
        //先由前到后建立堆
        for(int i = 0; i < n; i++) heap_tmp.ShiftUp(i);
        //再由后到前对数组排序
        for(int i = n-1; i >= 0; i--){
            heap_tmp.swap(0, i);
            heap_tmp.size -= 1;
            heap_tmp.ShiftDown(0);
        }
    }

    //向下调整
    void ShiftDown(int curidx){
        int child = curidx * 2;
        while(child < size){
            if(child+1 < size && arrheap[child] > arrheap[child+1])
                child++;
            if(arrheap[child] < arrheap[curidx]){
                swap(child, curidx);
                curidx = child;
                child = 2 * child;
            }
            else break;
        }
    }

    //向上调整
    void ShiftUp(int curidx){
        int parent = (curidx-1)/2;
        while(curidx > 0){
            if(arrheap[curidx] < arrheap[parent]){
                swap(curidx, parent);
                curidx = parent;
                parent = (parent-1)/2;
            }
            else break;
        }
    }

    private void swap(int index1, int index2){
        if(index1 >= size || index2 >= size || index1 == index2) return;
        int tmp = arrheap[index1];
        arrheap[index1] = arrheap[index2];
        arrheap[index2] = tmp;
    }
}
