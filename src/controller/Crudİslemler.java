/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Personel;

/**
 *
 * @author can yard
 */
public class Crudİslemler {
    BaglantiTest bt;

    /*String ad,String soyad,String tcno,String sicilno,String cinsiyet,String dogumTarihi,String sehir,String birim,String sifre*/
   /*  */
          
          public boolean İnsert(Personel p){
          
        try {
            bt=new BaglantiTest();
            bt.Baglan();
            
    
              String sql="INSERT INTO personel"
                 + "(ad,soyad,tc_no,sicilno,cinsiyet,dogum,sehir,birim,sifre,toplam_izin)"
                 +"VALUES(?,?,?,?,?,?,?,?,?,?)"
                 ;
        
             Connection con=bt.getConnection();
            Statement st=con.createStatement();
            PreparedStatement ps= con.prepareStatement(sql);
       
            ps.setString(1,p.getAd());
            ps.setString(2,p.getSoyad());
            ps.setString(3,p.getTc_no());
            ps.setString(4,p.getSicilno());
            ps.setString(5,p.getCinsiyet());
            ps.setString(6,p.getDogum_tarihi());
            ps.setString(7,p.getSehir());
            ps.setString(8,p.getBirim());
            ps.setString(9,p.getSifre());
            ps.setString(10, "0");
            ps.executeUpdate();

            
        } catch (SQLException ex) {
    
            ex.printStackTrace();
                return false;
        }
        return true;
    }
    public boolean Update(Personel p){
        
        bt=new BaglantiTest();
        String sql="UPDATE personel SET ad=? ,soyad=?,tc_no=?,sicilno=?,cinsiyet=?,dogum=?,sehir=?,birim=? WHERE kayit_no=?";
        
        try{
            Connection con=bt.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, p.getAd());
            ps.setString(2, p.getSoyad());
            ps.setString(3, p.getTc_no());
            ps.setString(4, p.getSicilno());
            ps.setString(5, p.getCinsiyet());
            ps.setString(6, p.getDogum_tarihi());
            ps.setString(7, p.getSehir());
            ps.setString(8, p.getBirim());
            ps.setString(9, p.getKayitNo());
            ps.execute();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return false;
    }
    public boolean Delete(String silinecekSicil){
        bt=new BaglantiTest();
              String sqlsorgusu="DELETE FROM personel WHERE sicilno =?";
        try {
            Connection con=bt.getConnection();
            PreparedStatement ps=con.prepareStatement(sqlsorgusu);
            ps.setString(1, silinecekSicil);
            ps.execute();
       
            return true;
                    
        } catch (SQLException ex) {
           ex.printStackTrace();
           return false;
        }
          
        
      
    }
    
    
}

