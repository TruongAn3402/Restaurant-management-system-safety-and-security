/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String MANV;
    private String TENNV;
    private String GIOITINH;
    private String NGAYSINH;
    private String DIACHI;
    private String SODT;
    private String EMAIL;
    private String PASS;
    private String QUYEN;

    public NhanVien(String MANV, String TENNV, String GIOITINH, String NGAYSINH, String DIACHI, String SODT, String EMAIL, String PASS, String QUYEN) {
        this.MANV = MANV;
        this.TENNV = TENNV;
        this.GIOITINH = GIOITINH;
        this.NGAYSINH = NGAYSINH;
        this.DIACHI = DIACHI;
        this.SODT = SODT;
        this.EMAIL = EMAIL;
        this.PASS = PASS;
        this.QUYEN = QUYEN;
    }

    public NhanVien() {
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getTENNV() {
        return TENNV;
    }

    public void setTENNV(String TENNV) {
        this.TENNV = TENNV;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getSODT() {
        return SODT;
    }

    public void setSODT(String SODT) {
        this.SODT = SODT;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public String getQUYEN() {
        return QUYEN;
    }

    public void setQUYEN(String QUYEN) {
        this.QUYEN = QUYEN;
    }
    
}
