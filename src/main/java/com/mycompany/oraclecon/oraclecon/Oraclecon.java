package com.mycompany.oraclecon.oraclecon;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Oraclecon {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement stmt=(Statement) con.createStatement();
            PreparedStatement st = null;
            String sql="select * from student";
            st = con.prepareStatement(sql);
            ResultSet re=st.executeQuery();
            int i = 0;
            while(re.next())
                System.out.println(re.getInt(1)+" "+re.getString(2)+" "+re.getString(3));
            con.close();
        }
        catch(Exception e)
        {
            System.out.print(e+" error");
        }
    }
}
