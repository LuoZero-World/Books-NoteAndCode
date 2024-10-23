package DesignPattern.Mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DesignPattern.Mediator.colleague.ColleagueButton;
import DesignPattern.Mediator.colleague.ColleagueCheckBox;
import DesignPattern.Mediator.colleague.ColleagueTextField;

//ConcreteMediator
public class LoginFrame implements ActionListener, Mediator{

    private ColleagueCheckBox checkGuest, checkLogin;
    private ColleagueButton buttonOK, buttonCancel;
    private ColleagueTextField textUser, textPass;

    // 构造函数。
    // 生成并配置各个Colleague后，显示对话框。
    public LoginFrame(Frame mainFrame) {
        mainFrame.setBackground(Color.lightGray);
        // 使用布局管理器生成4×2窗格
        mainFrame.setLayout(new GridLayout(4, 2));
        // 生成各个Colleague
        createColleagues();
        // 配置
        mainFrame.add(checkGuest);
        mainFrame.add(checkLogin);
        mainFrame.add(new Label("Username:"));
        mainFrame.add(textUser);
        mainFrame.add(new Label("Password:"));
        mainFrame.add(textPass);
        mainFrame.add(buttonOK);
        mainFrame.add(buttonCancel);
        // 设置初始的启用起用/禁用状态
        colleagueChanged();
        // 显示
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    // 生成各个Colleague。
    public void createColleagues() {
        // 生成
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckBox("Guest", g, true);
        checkLogin = new ColleagueCheckBox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOK = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        // 设置Mediator
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOK.setMediator(this);
        buttonCancel.setMediator(this);
        // 设置Listener
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOK.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // 接收来自于Colleage的通知然后判断各Colleage的启用/禁用状态。
    public void colleagueChanged() {
        if (checkGuest.getState()) { // Guest mode
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOK.setColleagueEnabled(true);
        } else { // Login mode
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }
    // 当textUser或是textPass文本输入框中的文字发生变化时
    // 判断各Colleage的启用/禁用状态
    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                buttonOK.setColleagueEnabled(true);
            } else {
                buttonOK.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOK.setColleagueEnabled(false);
        }
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

    public static void main(String[] args) {
        Frame mainFrame = new Frame("Login");
        new LoginFrame(mainFrame);
    }
    
}
