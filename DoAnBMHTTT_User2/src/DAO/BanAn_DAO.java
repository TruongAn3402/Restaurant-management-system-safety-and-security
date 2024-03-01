/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.BanAn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BanAn_DAO {
//    public static ArrayList<BanAn> getDSBAnTrong() {
//        ArrayList<BanAn> dsma = new ArrayList<BanAn>();
//        try {
//            String sql = "select *from NV001.banan where TrangThai = 'Trong' ";
//            DBConnect cn = new DBConnect();
//            cn.GetConnect();
//            ResultSet rs = cn.executeQuery(sql);
//            while (rs.next()) {
//                BanAn ma = new BanAn(rs.getString("MaBan").trim(), rs.getString("TenBan").trim(), rs.getString("TrangThai").trim());
//                dsma.add(ma);
//            }
//        } catch (Exception e) {
//            System.err.println("Không thể lấy dữ liệu bàn ăn" + e.getMessage());
//        }
//        return dsma;
//    }
    public static ArrayList<BanAn> getDSBAn() {
        ArrayList<BanAn> dsba = new ArrayList<BanAn>();
        try {
            String sql = "select * from NV001.banan   ";
            DBConnect cn = new DBConnect();
            cn.GetConnect();
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                String maba = rs.getString("MaBan");
                
                Connection connection = cn.GetConnect(); // Lấy đối tượng Connection
                CallableStatement cs = connection.prepareCall("{CALL NV001.GiaiMaVaXuatThongTinBanAn(?,?)}");
                cs.setString(1, maba);
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.execute();
                String tenba_GiaiMa = cs.getString(2);
                
                String TrangThai = rs.getString("TrangThai");
                
                BanAn ba = new BanAn(maba, tenba_GiaiMa, TrangThai);
                dsba.add(ba);
            }
        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu bàn ăn" + e.getMessage());
        }
        return dsba;     
    }

    public static int ThemXoaSuaBanAn(String sql) {
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
