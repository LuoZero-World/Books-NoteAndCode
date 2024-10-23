package DesignPattern.Decorator.border;

import DesignPattern.Decorator.display.Display;
import DesignPattern.Decorator.display.MultiStringDisplay;
import DesignPattern.Decorator.display.StringDisplay;

public class Main {
    public static void main(String[] args) {
        Display d1 = new SideBorder(
                        new FullBorder(
                            new SideBorder(
                                new StringDisplay("Hello World!"),
                            '*')
                        ),
                    '&');
        d1.show();

        MultiStringDisplay md1 = new MultiStringDisplay();
        md1.add("What Fuck");
        md1.add("PPPP");
        Display d2 = new FullBorder(
                        new SideBorder(md1, '#')
                    );
        d2.show();
    }
}
