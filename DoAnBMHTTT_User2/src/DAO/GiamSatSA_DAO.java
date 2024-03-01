/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.DBA_AUDIT_TRAIL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class GiamSatSA_DAO {
    public static ArrayList<DBA_AUDIT_TRAIL> LayThongTinGiamSat() {
        ArrayList<DBA_AUDIT_TRAIL> dat = new ArrayList<DBA_AUDIT_TRAIL>();
        try {          
            String sql = "SELECT username, timestamp, obj_name, action_name FROM DBA_AUDIT_TRAIL";
            DBConnect conn = new DBConnect();
            conn.GetConnect();           
            ResultSet rs = conn.executeQuery(sql);           
            while (rs.next()) {  
            String username = rs.getString("username");
            Timestamp timestamp = rs.getTimestamp("timestamp");
            String obj_name = rs.getString("obj_name");
            String action_name = rs.getString("action_name");

            DBA_AUDIT_TRAIL ds = new DBA_AUDIT_TRAIL(username, timestamp, obj_name, action_name);
            dat.add(ds);
            System.out.println("Lay du lieu nhan vien thanh cong!");
        }             
        } catch (Exception e) {
            //System.err.println("Lay du lieu nhan vien that bai!");
            e.printStackTrace();
        }
        return dat;
    }
}
