package DesignPattern.Composite;

import java.util.ArrayList;
import java.util.Iterator;

//Component
public abstract class Entry {

    protected Entry fa;

    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) throws FileTreatmentException{
        throw new FileTreatmentException();
    }
    public void printList(){
        printList("");
    }
    protected abstract void printList(String prefix);
    public String toString(){
        return getName()+"("+ getSize() +")";
    }
    public String getMyPath(){
        Entry father = this.fa;
        StringBuilder sb = new StringBuilder();
        while(father != null){
            sb.insert(0, "/"+father.getName());
            father = father.fa;
        }
        
        sb.append("/").append(getName());
        return sb.toString();
    };
}

//Leaf
class File extends Entry{

    private String name;
    private int size;


    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix+"/"+this);
    } 
}

//Composite
class Directory extends Entry{

    private String name;
    private ArrayList<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public Entry add(Entry entry){
        entry.fa = this;
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
    protected void printList(String prefix) {
        System.out.println(prefix+"/"+this);
        Iterator<Entry> iterator = directory.iterator();
        prefix += "/"+name;
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.printList(prefix);
        }
    }
}
