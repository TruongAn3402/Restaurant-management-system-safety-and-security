/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String mahd, ngayhd, manv, makh, maban;
    private Integer tongtien;

    public HoaDon() {
    }

    public HoaDon(String mahd, String ngayhd, String manv, String makh, String maban, Integer tongtien) {
        this.mahd = mahd;
        this.ngayhd = ngayhd;
        this.manv = manv;
        this.makh = makh;
        this.maban = maban;
        this.tongtien = tongtien;
    }

    public String getMahd() {
        return mahd;
    }

    public String getNgayhd() {
        return ngayhd;
    }

    public String getManv() {
        return manv;
    }

    public String getMakh() {
        return makh;
    }

    public String getMaban() {
        return maban;
    }

    public Integer getTongtien() {
        return tongtien;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setNgayhd(String ngayhd) {
        this.ngayhd = ngayhd;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setMaban(String maban) {
        this.maban = maban;
    }

    public void setTongtien(Integer tongtien) {
        this.tongtien = tongtien;
    }
}
