/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author can yard
 */
public class İzinTalebleri {
    private String ad;
    private String soyad;
    private String tcno;
    private String izinSayisi;
    private String izinTuru;
    private String izinOnay;
    private String baslangicTarihi;
    private String bitisTarihi;

    public String getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(String baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public String getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(String bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public String getIzinOnay() {
        return izinOnay;
    }

    public void setIzinOnay(String izinOnay) {
        this.izinOnay = izinOnay;
    }
    
    public İzinTalebleri(String ad,String soyad,String tcno,String izinSayisi,String izinTuru){
        this.ad=ad;
        this.soyad=soyad;
        this.tcno=tcno;
      
        this.izinSayisi=izinSayisi;
        this.izinTuru=izinTuru;
                
                
    }
     public İzinTalebleri(String ad,String soyad,String tcno,String izinSayisi,String izinTuru,String baslangic,String bitis){
        this.ad=ad;
        this.soyad=soyad;
        this.tcno=tcno;
      this.baslangicTarihi=baslangic;
      this.bitisTarihi=bitis;
        this.izinSayisi=izinSayisi;
        this.izinTuru=izinTuru;
                
                
    }
     public İzinTalebleri(String ad,String soyad,String tcno,String izinSayisi,String izinTuru,String izin_onay,String baslangic,String bitis){
        this.ad=ad;
        this.soyad=soyad;
        this.tcno=tcno;
      this.baslangicTarihi=baslangic;
      this.bitisTarihi=bitis;
        this.izinSayisi=izinSayisi;
        this.izinTuru=izinTuru;
        this.izinOnay=izin_onay;
                
                
    }
    

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    public İzinTalebleri() {
    
    
    }
    
        
    

    public String getIzinSayisi() {
        return izinSayisi;
    }

    public void setIzinSayisi(String izinSayisi) {
        this.izinSayisi = izinSayisi;
    }

    public String getIzinTuru() {
        return izinTuru;
    }

    public void setIzinTuru(String izinTuru) {
        this.izinTuru = izinTuru;
    }
    
}
