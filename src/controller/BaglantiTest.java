/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author can yard
 */
public class BaglantiTest {
    
   
  
    public void Baglan() {
        try {
          
           
           Connection con=getConnection();

            System.out.println("Bağlantı başarılı");
        } catch (Exception ex) {
            System.out.println("deneme");
            
        }
    }
    
      public Connection getConnection() {
      Connection con;

        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/izintakipsistemi","root","1234");
            return con;
        }catch(SQLException e){
            e.getErrorCode();
            return null;
        }
        }
    
}
