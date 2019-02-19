/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.BaglantiTest;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Personel;

import view.YoneticiFormu;

/**
 *
 * @author can yard
 */
public class Listelemeİslemleri  extends JTextField{
            private Vector<String> sutunlar = new Vector<>();
            private JTable ElemanTablosu;
            private Vector<Object> satir;
            private DefaultTableModel model;
            PreparedStatement ps;
            Connection conn=null;
            
            BaglantiTest bt;
            
            
            
            
            public void TumPersoneliListele(JTable ElemanTablosu,String tablo){
            this.ElemanTablosu=ElemanTablosu;
            sutunlar.add("Ad");
            sutunlar.add("Soyad");
            sutunlar.add("Tc No");
            sutunlar.add("Sicil No");
            sutunlar.add("Cinsiyet");
            sutunlar.add("Dogum Tarihi");
            sutunlar.add("Sehir");
            sutunlar.add("Birim");
            sutunlar.add("Toplam İzin");
            sutunlar.add("Kalan İzin");
            model=(DefaultTableModel)ElemanTablosu.getModel();
            model.setColumnIdentifiers(sutunlar);
               listele(tablo);
         }
    
               public void listele(String tabloAdi){
                     if(tabloAdi.equalsIgnoreCase("personel")){
                         System.out.println(tabloAdi);
                         PersonelListesi();
                         Show_User_In_JTable();
                     }
               }

   
    
    
    
            public ArrayList<Personel> PersonelListesi()
            {   
                bt=new BaglantiTest();
                bt.Baglan();

                ArrayList<Personel> userlist=new ArrayList<Personel>();

                             try {
                                 String sorgu="select * from personel";

                                       Connection con=bt.getConnection();
                                       Statement st=con.createStatement();
                                      PreparedStatement ps= con.prepareStatement(sorgu);

                                        ResultSet rs;
                                      rs=ps.executeQuery(sorgu);
                                     Personel personel;
                         while(rs.next()){
                         personel=new Personel(rs.getString("ad"),rs.getString("soyad"),rs.getString("tc_no"),rs.getString("sicilno"),rs.getString("cinsiyet"),rs.getString("dogum"),rs.getString("sehir"),rs.getString("birim"),rs.getString("toplam_izin"));
                         userlist.add(personel);
                }

            }catch(Exception e){
                e.printStackTrace();
            }

            return userlist;



        }
         public void Show_User_In_JTable(){
             
             
            ArrayList<Personel> list=PersonelListesi();
            DefaultTableModel model=(DefaultTableModel)ElemanTablosu.getModel();
            Object[] satirlar=new Object[10];
            
            for(int i=0;i<list.size();i++){
                             int kalan_izin=30;

               satirlar[0]=list.get(i).getAd();
               satirlar[1]=list.get(i).getSoyad();
               satirlar[2]=list.get(i).getTc_no();
               satirlar[3]=list.get(i).getSicilno();
               satirlar[4]=list.get(i).getCinsiyet();
               satirlar[5]=list.get(i).getDogum_tarihi();
               satirlar[6]=list.get(i).getSehir();
               satirlar[7]=list.get(i).getBirim();
               satirlar[8]=list.get(i).getToplamizin();
               kalan_izin=kalan_izin-Integer.valueOf(list.get(i).getToplamizin());
               satirlar[9]=kalan_izin;
               model.addRow(satirlar);
            }

         }
     
     
    
}
