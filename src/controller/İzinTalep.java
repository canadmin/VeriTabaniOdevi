/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.İzinTalebleri;

/**
 *
 * @author can yard
 */
public class İzinTalep {
    
                BaglantiTest bt; 

    public boolean talepEt(İzinTalebleri it){
        try {
            bt=new BaglantiTest();
            bt.Baglan();
            
    
              String sql="INSERT INTO izin_talepleri"
                 + "(ad,soyad,tc_no,izin_gun,izin_turu,Baslangic_Tarihi,Bitis_Tarihi)"
                 +"VALUES(?,?,?,?,?,?,?)"
                 ;
        
             Connection con=bt.getConnection();
            Statement st=con.createStatement();
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, it.getAd());
            ps.setString(2, it.getSoyad());
            ps.setString(3, it.getTcno());

            ps.setString(4, it.getIzinSayisi());
            ps.setString(5, it.getIzinTuru());
            ps.setString(6, it.getBaslangicTarihi());
            ps.setString(7, it.getBitisTarihi());
            ps.executeUpdate();

            
        } catch (SQLException ex) {
    
            ex.printStackTrace();
                return false;
        }
        return true;
        
        
    }
    public boolean kabulEt(İzinTalebleri it,String onay){
         
         try {
        bt=new BaglantiTest();
            bt.Baglan();
            
             String sql="INSERT INTO izinliler"
                 + "(ad,soyad,tc_no,izin_gun,izin_turu,izin_onay,Baslangic_Tarihi,Bitis_Tarihi)"
                 +"VALUES(?,?,?,?,?,?,?,?)"
                 ;
              Connection con=bt.getConnection();
            Statement st=con.createStatement();
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, it.getAd());
            ps.setString(2, it.getSoyad());
            ps.setString(3, it.getTcno());
            ps.setString(4, it.getIzinSayisi());
            ps.setString(5, it.getIzinTuru());
            ps.setString(6, onay);
            ps.setString(7, it.getBaslangicTarihi());
            ps.setString(8, it.getBitisTarihi());
          
            ps.executeUpdate();
         }catch(Exception ex){
             ex.printStackTrace();
             return false;
         }
            
                        izinArttir(it.getIzinSayisi(),it.getTcno());
                        TalepSil(it.getTcno());

        return true;
    }
    
    public void izinArttir(String izinSayisi,String tcno){
        int izin=Integer.valueOf(izinSayisi);
         String c=null;
         int a;
        System.out.println(izinSayisi+tcno);
                    try {
                        bt=new BaglantiTest();
                        bt.Baglan();
                        
                        String sql="select * from personel";
                                       Connection con=bt.getConnection();
                                       Statement st=con.createStatement();
                                      PreparedStatement ps= con.prepareStatement(sql);

                                        ResultSet rs;
                                      rs=ps.executeQuery(sql);
                        while(rs.next()){
                           if(rs.getString("tc_no").equals(tcno)){
                            System.out.println(rs.getString("toplam_izin"));
                            a=Integer.valueOf(rs.getString("toplam_izin"));
                            izin+=a;
                             c =String.valueOf(izin);
                               System.out.println(c);
                           }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(İzinTalep.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    try{
                        String sql1="update personel set toplam_izin="+c+" where tc_no="+tcno;
                        
                        Connection con=bt.getConnection();
                           Statement st=con.createStatement();
                     st.executeUpdate(sql1);
                    }catch(Exception e ){
                        System.out.println("1");
                    }
                 
        return;
    }

    private void TalepSil(String tcno) {
            bt=new BaglantiTest();
              String sqlsorgusu="DELETE FROM izin_talepleri WHERE tc_no ="+tcno;
        try {
            Connection con=bt.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(sqlsorgusu);
       
                    
        } catch (SQLException ex) {
           ex.printStackTrace();
        }   
    return;
    
    }
    
    
    
}
