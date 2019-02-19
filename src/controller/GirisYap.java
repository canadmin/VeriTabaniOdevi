/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author can yard
 */
public class GirisYap {
        BaglantiTest bt;
    public boolean login(String adi,String sifresi) throws SQLException{
            bt=new BaglantiTest();

      
        ResultSet rs=null;
         try{
            Connection con=bt.getConnection();
            Statement stat=con.createStatement();
                rs  =stat.executeQuery("select * from yoneticiler");

                 while(rs.next()){
                if(rs.getString("kullaniciadi").equals(adi)&&rs.getString("sifre").equals(sifresi)){

                    System.out.println("basarili giris");
                                   return true;

                }

            }
         }catch(Exception e){
             System.out.println("hata");

         }                     return false;

        
        
    }
    
    public String KullaniciGirisi(String ad,String sifre){
        bt=new BaglantiTest();
                ResultSet rs=null;
 try{
            Connection con=bt.getConnection();
            Statement stat=con.createStatement();
                rs  =stat.executeQuery("select * from personel");

                 while(rs.next()){
                if(rs.getString("ad").equals(ad)&&rs.getString("sifre").equals(sifre)){

                    System.out.println("basarili giris");
                                   return rs.getString("sicilno");

                }

            }
         }catch(Exception e){
             System.out.println("hata");

         }            
        
        return null;
    }
       
    }
    
    

