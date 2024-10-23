package DesignPattern.Commandd;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import DesignPattern.Commandd.commandd.Command;
import DesignPattern.Commandd.commandd.MacroCommand;
import DesignPattern.Commandd.drawer.DrawCanvas;
import DesignPattern.Commandd.drawer.DrawCommand;

//Client
//Invoker
public class Main{

    private MacroCommand history = new MacroCommand();
    //绘制区域
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    //删除按钮
    private JButton clearButton = new JButton("clear");
    private JButton undoButton = new JButton("undo");

    public Main(Frame mainFrame){

        Panel p1 = new Panel();

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint());
                history.append(cmd);
                cmd.execute();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == clearButton){
                    history.clear();
                    canvas.repaint();
                }
            }
        });
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == undoButton){
                    history.undo();
                    canvas.repaint();
                }
            }
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(undoButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        p1.add(mainBox);
        mainFrame.add(p1);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Frame mainFrame = new Frame("Command Pattern");

        new Main(mainFrame);
    }
    
}
