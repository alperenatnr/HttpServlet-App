package model;

import java.time.LocalDate;
import java.util.Date;

public class Personel {

    private String ad;
    private String soyad;
    private int sicilNumarasi;
    private String departman;
    private String telefon;
    private LocalDate iseGirisTarihi;
    private double maasTutari;
    private boolean aktiflik;

    public Personel() {
    }

    public Personel(String ad, String soyad, int sicilNumarasi, String departman, String telefon, LocalDate iseGirisTarihi, double maasTutari, boolean aktiflik) {
        this.ad = ad;
        this.soyad = soyad;
        this.sicilNumarasi = sicilNumarasi;
        this.departman = departman;
        this.telefon = telefon;
        this.iseGirisTarihi = iseGirisTarihi;
        this.maasTutari = maasTutari;
        this.aktiflik = aktiflik;
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

    public int getSicilNumarasi() {
        return sicilNumarasi;
    }

    public void setSicilNumarasi(int sicilNumarasi) {
        this.sicilNumarasi = sicilNumarasi;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public LocalDate getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(LocalDate iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }

    public double getMaasTutari() {
        return maasTutari;
    }

    public void setMaasTutari(double maasTutari) {
        this.maasTutari = maasTutari;
    }

    public boolean isAktiflik() {
        return aktiflik;
    }

    public void setAktiflik(boolean aktiflik) {
        this.aktiflik = aktiflik;
    }

    public boolean bosAlanKontrol() {
        return ad.isEmpty() || soyad.isEmpty() || iseGirisTarihi == null || maasTutari == 0;
    }
}
