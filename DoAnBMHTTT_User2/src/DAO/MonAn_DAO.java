/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.MonAn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Types;


/**
 *
 * @author Admin
 */
public class MonAn_DAO {
    public static ArrayList<MonAn> getDSMAn() {
        ArrayList<MonAn> dsma = new ArrayList<MonAn>();
        try {
            String sql = "select * from NV001.MONAN";
            DBConnect cn = new DBConnect();
            cn.GetConnect();
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                String maMon = rs.getString("maMon");
                
                Connection connection = cn.GetConnect(); // Lấy đối tượng Connection
                CallableStatement cs = connection.prepareCall("{CALL NV001.GiaiMaVaXuatThongTin_MONAN(?,?)}");
                cs.setString(1, maMon);
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.execute();
                String tenMon_GiaiMa = cs.getString(2);
                String loaiMon = rs.getString("loaiMon");
                String giaTien = rs.getString("giaTien");

                MonAn ma = new MonAn(maMon, tenMon_GiaiMa, loaiMon, giaTien);
                dsma.add(ma);
            }
        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu món ăn" + e.getMessage());
        }
        return dsma;
    }

    public static int ThemXoaSuaMonAn(String sql) {
        int i = 0;
        try {
            DBConnect cn = new DBConnect();
            cn.GetConnect();
            i = cn.executeUpdate(sql);
            cn.GetConnect();
            System.out.println("Thêm/xóa/sửa thành công");

        } catch (Exception e) {
            System.out.println("Thêm/xóa/sửa không thành công");

        }
        return i;
    }
}
