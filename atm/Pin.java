package com.atm;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Pin {
    public void pinView(String cardNum) {
        Commons common = new Commons();
        JFrame frame = (JFrame) common.Frame();
        Font txt = new Font("", Font.BOLD, 15);
        Home home = new Home();
        Admin admin = new Admin();

        //---------------PASSWORD----------------
        JLabel pswd = new JLabel("ENTER YOUR PIN");
        pswd.setBounds(50, 270, 250, 20);
        pswd.setFont(txt);
        JPasswordField pswdField = new JPasswordField();
        pswdField.setBounds(50, 300, 500, 35);
        pswdField.setFont(txt);
        frame.add(pswdField);
        frame.add(pswd);
        //-----------------------------------------

        //-----------------BUTTON-----------------
        JButton cont = new JButton("CONTINUE");
        cont.setBounds(200, 400, 200, 50);
        cont.setFont(new Font("Rockwell", Font.BOLD, 25));
        frame.add(cont);
        cont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SQLManage man = new SQLManage();
                    System.out.println("Card Number: " + cardNum);
                    System.out.println("Entered PIN: " + new String(pswdField.getPassword()));
                    ResultSet rst = man.check(cardNum, new String(pswdField.getPassword()));
                    if (rst.next()) {
                        System.out.println("Result Set has next. User found.");
                        if (rst.getString("card").equals("admin")) {
                            System.out.println("Admin user logged in.");
                            admin.adminView();
                            frame.dispose();
                        } else {
                            System.out.println("Regular user logged in. User ID: " + rst.getInt("id"));
                            home.homeView(rst.getInt("id"));
                            frame.dispose();
                        }
                    } else {
                        System.out.println("No matching user found. Wrong PIN.");
                        Fail fail = new Fail();
                        fail.failView("WRONG PIN!!!");
                        frame.dispose();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //----------------------------------------
        frame.setVisible(true);
    }
}
