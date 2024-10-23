package DesignPattern.Commandd.commandd;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

//ConcreteCommand
public class MacroCommand implements Command{

    //命令集合
    private final Deque<Command> commands = new LinkedList<>();

    @Override
    public void execute() {
        Iterator<Command> iterator = commands.iterator();
        while(iterator.hasNext()){
            iterator.next().execute();
        }
    }

    public void append(Command cmd){
        if(cmd != this) commands.push(cmd);
    }

    public void undo(){
        if(!commands.isEmpty()) commands.pop();
    }

    public void clear(){
        commands.clear();
    }
    
}
