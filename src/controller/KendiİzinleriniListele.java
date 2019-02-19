/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.İzinTalebleri;
import static view.KullaniciForm.tc_no;

/**
 *
 * @author can yard
 */
public class KendiİzinleriniListele {
    
       private Vector<String> sutunlar = new Vector<>();
            private JTable ElemanTablosu;
            private Vector<Object> satir;
            private DefaultTableModel model;
            PreparedStatement ps;
            Connection conn=null;
                        BaglantiTest bt;
    
     public void TumTalepleriListele(JTable ElemanlarTablosu){
         this.ElemanTablosu=ElemanlarTablosu;
            sutunlar.add("Ad");
            sutunlar.add("Soyad");
            sutunlar.add("Tc no");
            sutunlar.add("İzin Sayisi");
            sutunlar.add("İzin Türü");
            sutunlar.add("İzin Onay");
          sutunlar.add("Baslangic Tarihi");
          sutunlar.add("Bitis Tarihi");
            model=(DefaultTableModel)ElemanTablosu.getModel();
            model.setColumnIdentifiers(sutunlar);
            System.out.println("hata burada değil");
                listele();
    }
        public void listele(){
                                System.out.println("hata burada değil1");

                         TalepListesi();
                                     System.out.println("hata burada değil2");

                         Show_User_In_JTable();}
        public ArrayList<İzinTalebleri> TalepListesi()
            {   
                bt=new BaglantiTest();
                bt.Baglan();
                 
                ArrayList<İzinTalebleri> userlist=new ArrayList<İzinTalebleri>();

                             try {
                                 System.out.println(tc_no);
                                 String sorgu="select * from izinliler where tc_no ="+tc_no;

                                       Connection con=bt.getConnection();
                                       Statement st=con.createStatement();
                                      PreparedStatement ps= con.prepareStatement(sorgu);

                                        ResultSet rs;
                                      rs=ps.executeQuery(sorgu);
                                     İzinTalebleri italep;
                         while(rs.next()){
                         italep=new İzinTalebleri(rs.getString("ad"),rs.getString("soyad"),rs.getString("tc_no"),rs.getString("izin_gun"),rs.getString("izin_turu"),rs.getString("izin_onay"),rs.getString("Baslangic_Tarihi"),rs.getString("Bitis_Tarihi"));
                         userlist.add(italep);
                }

            }catch(Exception e){
                e.printStackTrace();
            }

            return userlist;



        }
          public void Show_User_In_JTable(){
            ArrayList<İzinTalebleri> list=TalepListesi();
            DefaultTableModel model=(DefaultTableModel)ElemanTablosu.getModel();
            Object[] satirlar=new Object[8];
            for(int i=0;i<list.size();i++){
               satirlar[0]=list.get(i).getAd();
               satirlar[1]=list.get(i).getSoyad();
               satirlar[2]=list.get(i).getTcno();
               satirlar[3]=list.get(i).getIzinSayisi();
               satirlar[4]=list.get(i).getIzinTuru();
               satirlar[5]=list.get(i).getIzinOnay();
              satirlar[6]=list.get(i).getBaslangicTarihi();
              satirlar[7]=list.get(i).getBitisTarihi();
               model.addRow(satirlar);
            }

         }
                     
}
