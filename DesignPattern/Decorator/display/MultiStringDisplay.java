package DesignPattern.Decorator.display;

import java.util.ArrayList;

//ConcreteComponent
public class MultiStringDisplay extends Display{

    int maxCol = 0;
    ArrayList<String> strs = new ArrayList<>();

    public void add(String str){
        maxCol = Math.max(maxCol, str.length());
        strs.add(str);
    }

    @Override
    public int getColumns() {
        return maxCol;
    }

    @Override
    public int getRows() {
        return strs.size();
    }

    @Override
    public String getRowText(int row) {
        StringBuilder sb = new StringBuilder(strs.get(row));
        int num = maxCol-strs.get(row).length();
        while(num-- > 0) sb.append(" ");
        return sb.toString();
    }
    
}
