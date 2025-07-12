package com.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIDemo {
    private final JFrame frame;
    private final JTextField input;
    private JTextArea area;
    private final JLabel label;
    private final JButton button1;
    private final JButton button2;
    private final int width;
    private final int height;
    public GUIDemo(int w,int h){
        frame = new JFrame();
        area = new JTextArea("Hello.\n This is a Jtext Area.");
        label = new JLabel("Hello");
        input = new JTextField(10);
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        this.width=w;
        this.height=h;
    }
    public  void setUpGUI(){
        Container cp = frame.getContentPane();
//        FlowLayout flow = new FlowLayout();
        BorderLayout brdr = new BorderLayout();
        cp.setLayout(brdr);
        frame.setSize(width,height);
        frame.setTitle("This is My First JAVA GUI program");
//        frame.add(button1);
        cp.add(input,BorderLayout.NORTH);
        cp.add(label,BorderLayout.SOUTH);
        cp.add(button1,BorderLayout.WEST);
        cp.add(button2,BorderLayout.EAST);
        cp.add(area,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    // event -> event Listner -> event Response
    public void setUpButtonListeners(){
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(ae.getSource() == button1){
//                System.out.println("Every Time You Press Button 1 I'll Print !");
                    String s = input.getText();
                    label.setText(s);
                    System.out.println(s);
                    input.setText("");

                } else if (ae.getSource() == button2) {
                    int num = Integer.parseInt(input.getText());
                    label.setText(String.valueOf(num));
                    System.out.println(num);
                    input.setText("");
                }
            }
        };
        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
    }
    // layout Manager sin JAVA

}
