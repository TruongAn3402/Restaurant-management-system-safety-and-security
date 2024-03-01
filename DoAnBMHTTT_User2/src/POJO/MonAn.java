/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class MonAn {
    private String maMon, tenMon, loaiMon, giaTien;
//    private int giaTien;

    public MonAn() {
    }

    public MonAn(String maMon, String tenMon, String loaiMon, String giaTien) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.loaiMon = loaiMon;
        this.giaTien = giaTien;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }
}
