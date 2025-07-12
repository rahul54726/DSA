package com.AgeCalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.awt.GridLayout;
public class AgeCalcGUI {
    // Create main frame
    public static void main(String[] args) {
        JFrame frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLayout(new GridLayout(5, 2 ,10, 10));
        JLabel birthYearLabel = new JLabel("Birth Year (YYYY)");
        JTextField birthYearField = new JTextField();
        JLabel birthMonthLabel = new JLabel("Birth Month (MM)");
        JTextField birthMonthField = new JTextField();
        JLabel birthDayLabel = new JLabel("Birth Day (DD)");
        JTextField birthDayField = new JTextField();
        //Buttons
        JButton calculateButton = new JButton("Calculate Age");
        //output Field
        JLabel ageResultLabel = new JLabel("Your Age : ");
        frame.add(birthYearLabel);
        frame.add(birthYearField);
        frame.add(birthMonthLabel);
        frame.add(birthMonthField);
        frame.add(birthDayLabel);
        frame.add(birthDayField);
        frame.add(calculateButton);
        frame.add(ageResultLabel);

        // ActonListener for the button

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                        int year = Integer.parseInt(birthYearField.getText());
                        int month = Integer.parseInt(birthMonthField.getText());
                        int day = Integer.parseInt(birthDayField.getText());
                        LocalDate birthDate = LocalDate.of(year,month,day);
                        LocalDate currentDate = LocalDate.now();
                        if(birthDate.isAfter(currentDate)){
                            ageResultLabel.setText("Invvalid Birth date");
                        }
                        else {
                            // calculate Age
                            Period age = Period.between(birthDate,currentDate);
                            ageResultLabel.setText("Your Age : " + age.getYears() +" Years "+age.getMonths()+" Months "+age.getDays()+" Days.");
                        }

                    } catch (Exception ex) {
                    ageResultLabel.setText("Please Enter Valid inputs! ");
                }
                }

        });

        frame.setVisible(true);
    }


}
