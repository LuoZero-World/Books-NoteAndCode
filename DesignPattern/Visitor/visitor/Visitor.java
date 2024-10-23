package DesignPattern.Visitor.visitor;

import DesignPattern.Visitor.element.*;

//Visitor
public interface Visitor {
    void visit(File file);
    void visit(Directory directory);
}
