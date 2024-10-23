package ProgrammingPearls.Chapter1;

/*
 * 数组不需要在创建后初始化，当访问时会自动初始化
 */
public class NonInitArray {
    private int[] array;
    private int[] from, to;
    private int top = 0;        //指示top数组的顶部

    public NonInitArray(int n){
        array = new int[n];     //假设我们不知道java已经将array全初始化为0了
        from = new int[n];
        to = new int[n];
    }

    public int get(int pos){
        int to_pos = from[pos];
        if(to_pos < top){      //在to数组中找对应
            int pos2 = to[to_pos];
            if(pos2 == pos) return array[pos];
        } 
        throw new RuntimeException("pos "+ pos +" is not be initialized");
    }

    public void set(int pos, int num){
        int to_pos = from[pos];
        //该位置已经被初始化
        if(to_pos < top && to[to_pos] == pos){
            array[pos] = num;
        } else{     //该位置未被初始化，则初始化
            array[pos] = num;
            to[top] = pos;
            from[pos] = top;
            top++;
        }
    }
}
