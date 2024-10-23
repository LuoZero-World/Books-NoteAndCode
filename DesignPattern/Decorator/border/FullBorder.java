package DesignPattern.Decorator.border;

import DesignPattern.Decorator.display.Display;

//ConcreteDecorator
public class FullBorder extends Border{

    protected FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        return 2+display.getColumns();  // |origin|
    }

    @Override
    public int getRows() {              // +------+
        return 2+display.getRows();     // |origin|
    }                                   // +------+

    @Override
    public String getRowText(int row) {
        if(row == 0 || row == display.getRows()+1) 
            return "+" + makeLine('-', display.getColumns()) + "+";
        else return "|" + display.getRowText(row-1) + "|";
    }

    private String makeLine(char c, int num) {
        StringBuilder sb = new StringBuilder();
        while(num-- > 0) sb.append(c);
        return sb.toString();
    }
    
}
