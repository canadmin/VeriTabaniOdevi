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
public class Personel {
    private String kayitNo;

    public String getKayitNo() {
        return kayitNo;
    }

    public void setKayitNo(String kayitNo) {
        this.kayitNo = kayitNo;
    }
    private String ad;
    private String soyad;
    private String tc_no;
    private String sicilno;
    private String cinsiyet;
    private String dogum_tarihi;
    private String kullaniciadi;
    private String sehir;
    private String Birim;
    private String sifre;
    private String toplamizin;

    public String getToplamizin() {
        return toplamizin;
    }

    public void setToplamizin(String toplamizin) {
        this.toplamizin = toplamizin;
    }
    public Personel(){
        
    }
    public Personel(String ad,String soyad,String tcno,String sicilno,String cinsiyet,String dogumTarihi,String sehir,String birim ,String toplamizin){
        this.ad=ad;
        this.soyad=soyad;
        this.tc_no=tcno;
        this.sicilno=sicilno;
        this.cinsiyet=cinsiyet;
        this.dogum_tarihi=dogumTarihi;
        this.sehir=sehir;
        this.Birim=birim;
        this.toplamizin=toplamizin;
        
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getBirim() {
        return Birim;
    }

    public void setBirim(String Birim) {
        this.Birim = Birim;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
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

    public String getTc_no() {
        return tc_no;
    }

    public void setTc_no(String tc_no) {
        this.tc_no = tc_no;
    }

    public String getSicilno() {
        return sicilno;
    }

    public void setSicilno(String sicilno) {
        this.sicilno = sicilno;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(String dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }
}
