/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String makh, tenkh, gioitinh, ngaysinh, diachi, sodt;

    public KhachHang(String makh, String tenkh, String gioitinh, String ngaysinh, String diachi, String sodt) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sodt = sodt;
    }

    public KhachHang() {
    }

    public String getMakh() {
        return makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSodt() {
        return sodt;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }  
}
