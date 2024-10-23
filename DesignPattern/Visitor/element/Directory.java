package DesignPattern.Visitor.element;

import java.util.ArrayList;
import java.util.Iterator;

import DesignPattern.Visitor.visitor.Visitor;

//ConcreteElement
//ObjectStructure —— 负责处理Element角色
public class Directory extends Entry{

    private String name;
    private ArrayList<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public Entry add(Entry entry){
        directory.add(entry);
        return this;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getSize() {
        int res = 0;
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            res += entry.getSize();
        }
        return res;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Iterator<? extends Entry> iterator(){
        return directory.iterator();
    }

}
