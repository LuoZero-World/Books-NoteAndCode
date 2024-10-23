package DesignPattern.Visitor.element;

import DesignPattern.Visitor.visitor.Visitor;

//Element
public interface Element {
    void accept(Visitor v);
}
