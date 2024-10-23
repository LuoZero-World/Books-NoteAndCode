package DesignPattern.Commandd.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import DesignPattern.Commandd.commandd.MacroCommand;

//Invoker
//Reciver
public class DrawCanvas extends Canvas implements Drawable{

    private Color color = Color.RED;
    private int radius = 6;
    //命令集合以及封装的一些操作 在Invoker中使用
    private MacroCommand history;

    public DrawCanvas(int w, int h, MacroCommand history){
        setSize(w, h);
        setBackground(Color.PINK);
        this.history = history;
    }

    @Override
    public void repaint() {
        super.paint(getGraphics());     //父类绘制 相当于重新刷上一面漆
        history.execute();
    }

    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
    }
    
}
