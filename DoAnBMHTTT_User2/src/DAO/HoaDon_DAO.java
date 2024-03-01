/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.HoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDon_DAO {
    public static ArrayList<HoaDon> getDSHD() {
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "select * from NV001.hoadon";
            DBConnect cn = new DBConnect();
            cn.GetConnect();
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon(
                        rs.getString("MaHD").trim(),
                        rs.getString("NgayHD"),
                        rs.getString("MaNV").trim(),
                        rs.getString("MaKH").trim(),
                        rs.getString("MaBan").trim(),
                        rs.getInt("TongTien")
                );
                dshd.add(hd);
            }
        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu hoá đơn");
        }
        return dshd;
    }

    public static int ThemXoaSuaHoaDon(String sql) {
        int i = 0;
        try {
            DBConnect cn = new DBConnect();
            cn.GetConnect();
            i = cn.executeUpdate(sql);
            System.out.println("Thêm/xóa/sửa thành công");
        } catch (Exception e) {
            System.out.println("Thêm/xóa/sửa không thành công");
        }
        return i;
    }
}
