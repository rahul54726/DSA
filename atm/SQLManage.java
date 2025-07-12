package com.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLManage {
    Connection con;

    SQLManage() throws SQLException {
        String usr = "root";
        String pass = "password";
        String url = "jdbc:mysql://localhost:3306/atm";
        con = DriverManager.getConnection(url, usr, pass);
    }

    public ResultSet check(String usr, String pass) throws SQLException {
        String str = "SELECT * FROM users WHERE card = ? AND pin = ?";
        PreparedStatement pstmt = con.prepareStatement(str);
        pstmt.setString(1, usr);
        pstmt.setString(2, pass);
        return pstmt.executeQuery();
    }

    public void deposit(int amt, int id) throws SQLException {
        String str = "UPDATE users SET bal = bal + ? WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(str);
        pstmt.setInt(1, amt);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();

        int bal = balCheck(id);
        str = "INSERT INTO transactions (id, amount, stat, bal) VALUES (?, ?, 'dep', ?)";
        pstmt = con.prepareStatement(str);
        pstmt.setInt(1, id);
        pstmt.setInt(2, amt);
        pstmt.setInt(3, bal);
        pstmt.executeUpdate();
    }

    public int withdraw(int amt, int id) throws SQLException {
        int bal = balCheck(id);
        if (bal >= amt) {
            String str = "UPDATE users SET bal = bal - ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(str);
            pstmt.setInt(1, amt);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

            bal -= amt;
            str = "INSERT INTO transactions (id, amount, stat, bal) VALUES (?, ?, 'wit', ?)";
            pstmt = con.prepareStatement(str);
            pstmt.setInt(1, id);
            pstmt.setInt(2, amt);
            pstmt.setInt(3, bal);
            pstmt.executeUpdate();
            return 1;
        }
        return 0;
    }

    public void pinchange(String pin, int id) throws SQLException {
        String str = "UPDATE users SET pin = ? WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(str);
        pstmt.setString(1, pin);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
    }

    public int balCheck(int id) throws SQLException {
        String str = "SELECT bal FROM users WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(str);
        pstmt.setInt(1, id);
        ResultSet rst = pstmt.executeQuery();
        if (rst.next()) {
            return rst.getInt("bal");
        }
        return 0;
    }

    public ResultSet stmt(int id) throws SQLException {
        String str = "SELECT * FROM transactions WHERE id = ? ORDER BY transid DESC";
        PreparedStatement pstmt = con.prepareStatement(str);
        pstmt.setInt(1, id);
        return pstmt.executeQuery();
    }

    public void adding(String card, String pin, String name, String bal) throws SQLException {
        String str = "INSERT INTO users (card, pin, uname, bal) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(str);
        pstmt.setString(1, card);
        pstmt.setString(2, pin);
        pstmt.setString(3, name);
        pstmt.setDouble(4, Double.parseDouble(bal));
        pstmt.executeUpdate();
    }
}
