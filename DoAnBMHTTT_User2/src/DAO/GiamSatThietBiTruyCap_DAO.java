/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import POJO.GiamSatThietBiTruyCap;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class GiamSatThietBiTruyCap_DAO {
    public static ArrayList<GiamSatThietBiTruyCap> getDSThietBiGiamSat() {
        ArrayList<GiamSatThietBiTruyCap> dstbgs = new ArrayList<>();
        try {
            String sql = "SELECT SCHEMANAME, MACHINE, PROGRAM, TYPE, MODULE FROM v$session WHERE TYPE = 'USER'";
            DBConnect cn = new DBConnect();
            Connection connection = cn.GetConnect();
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                String SCHEMANAME = rs.getString("SCHEMANAME").trim();
                String MACHINE = rs.getString("MACHINE").trim();
                String PROGRAM = rs.getString("PROGRAM").trim();
                String TYPE = rs.getString("TYPE").trim();
                String MODULE = rs.getString("MODULE").trim();
                GiamSatThietBiTruyCap gstb = new GiamSatThietBiTruyCap(SCHEMANAME, MACHINE,PROGRAM,TYPE,MODULE);
                         dstbgs.add(gstb);
                     }
                 } catch (SQLException e) {
                     System.err.println("Không thể lấy dữ liệu " + e.getMessage());
                 }
                 return dstbgs;
             }
}
