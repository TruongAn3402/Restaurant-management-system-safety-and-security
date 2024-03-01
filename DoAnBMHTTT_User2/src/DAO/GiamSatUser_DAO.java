package DAO;
import POJO.GiamSatUser;
import POJO.GiamSatUserTheoLogin;
import POJO.GiamSatUserTheoLogout;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Timestamp;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class GiamSatUser_DAO {
    public static ArrayList<GiamSatUser> getDSGiamSat() {
        ArrayList<GiamSatUser> dsgs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NV001.GiamSatUser order by KEY_ID asc";
            DBConnect cn = new DBConnect();
            Connection connection = cn.GetConnect();
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                String key_id = rs.getString("key_id").trim();
                String username = rs.getString("username").trim();
                Timestamp login_time = rs.getTimestamp("login_time");
                Timestamp logout_time = rs.getTimestamp("logout_time");
                String hoat_dong = rs.getString("hoat_dong").trim();
                GiamSatUser gsU = new GiamSatUser(key_id, username,login_time,logout_time,hoat_dong);
                         dsgs.add(gsU);
                     }
//                     rs.close();
//                     connection.close();
                 } catch (SQLException e) {
                     System.err.println("Không thể lấy dữ liệu " + e.getMessage());
                 }
                 return dsgs;
             }
    public static ArrayList<GiamSatUserTheoLogin> getDSGiamSatTheoLogin() {
        ArrayList<GiamSatUserTheoLogin> dsgs2 = new ArrayList<>();
        try {
            String sql = "SELECT KEY_ID, USERNAME, LOGIN_TIME, HOAT_DONG FROM NV001.GiamSatUser where HOAT_DONG = 'Login' order by LOGIN_TIME desc";
            DBConnect cn = new DBConnect();
            Connection connection = cn.GetConnect();
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                String key_id = rs.getString("key_id").trim();
                String username = rs.getString("username").trim();
                Timestamp login_time = rs.getTimestamp("login_time");
                String hoat_dong = rs.getString("hoat_dong").trim();
                GiamSatUserTheoLogin gsU2 = new GiamSatUserTheoLogin(key_id, username,login_time,hoat_dong);
                         dsgs2.add(gsU2);
                     }
//                     rs.close();
//                     connection.close();
                 } catch (SQLException e) {
                     System.err.println("Không thể lấy dữ liệu " + e.getMessage());
                 }
                 return dsgs2;
             }
    public static ArrayList<GiamSatUserTheoLogout> getDSGiamSatTheoLogout() {
        ArrayList<GiamSatUserTheoLogout> dsgs3 = new ArrayList<>();
        try {
            String sql = "SELECT KEY_ID, USERNAME, LOGOUT_TIME, HOAT_DONG FROM NV001.GiamSatUser where HOAT_DONG = 'Logout' order by LOGOUT_TIME desc";
            DBConnect cn = new DBConnect();
            Connection connection = cn.GetConnect();
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                String key_id = rs.getString("key_id").trim();
                String username = rs.getString("username").trim();
                Timestamp logout_time = rs.getTimestamp("logout_time");
                String hoat_dong = rs.getString("hoat_dong").trim();
                GiamSatUserTheoLogout gsU3 = new GiamSatUserTheoLogout(key_id, username,logout_time,hoat_dong);
                         dsgs3.add(gsU3);
                     }
//                     rs.close();
//                     connection.close();
                 } catch (SQLException e) {
                     System.err.println("Không thể lấy dữ liệu " + e.getMessage());
                 }
                 return dsgs3;
             }
}
