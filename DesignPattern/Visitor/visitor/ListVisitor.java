package DesignPattern.Visitor.visitor;

import java.util.Iterator;
import DesignPattern.Visitor.element.*;

//ConcreteVisitor
public class ListVisitor implements Visitor{

    private String currentdir = "";

    @Override
    public void visit(File file) {
        System.out.println(currentdir+"/"+file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir+"/"+directory);
        String tdir = currentdir;
        currentdir = currentdir+"/"+directory.getName();

        Iterator<? extends Entry> iterator = directory.iterator();
        while(iterator.hasNext()){
            Entry entry = iterator.next();
            entry.accept(this);
        }

        currentdir = tdir;
    }
    
}
