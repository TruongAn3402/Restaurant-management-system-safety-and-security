/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class BanAn {
    private String MaBan, TenBan, TrangThai;

    public BanAn() {
    }

    public BanAn(String MaBan, String TenBan, String TrangThai) {
        this.MaBan = MaBan;
        this.TenBan = TenBan;
        this.TrangThai = TrangThai;
    }

    public void setMaBan(String MaBan) {
        this.MaBan = MaBan;
    }

    public void setTenBan(String TenBan) {
        this.TenBan = TenBan;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaBan() {
        return MaBan;
    }

    public String getTenBan() {
        return TenBan;
    }

    public String getTrangThai() {
        return TrangThai;
    }
}
