package DesignPattern.Commandd.drawer;

import java.awt.Point;

import DesignPattern.Commandd.commandd.Command;

//ConcreteCommand
public class DrawCommand implements Command{

    //绘制对象 Reciver
    protected Drawable drawable;
    private Point position;

    public DrawCommand(Drawable drawable, Point position){
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
    
}
