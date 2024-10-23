package DesignPattern.Decorator.border;

import DesignPattern.Decorator.display.Display;

//ConcreteDecorator
public class SideBorder extends Border{

    private char borderChar;

    protected SideBorder(Display display, char ch) {
        super(display);
        borderChar = ch;
    }

    @Override
    public int getColumns() {
        return 2+display.getColumns();      // #origin#
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return borderChar+display.getRowText(row)+borderChar;
    }
    
}
