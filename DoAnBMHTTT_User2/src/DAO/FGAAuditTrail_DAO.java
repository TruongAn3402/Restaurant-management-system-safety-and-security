/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import POJO.DBA_FGA_AUDIT_TRAIL;
import POJO.DBA_AUDIT_POLICIES;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class FGAAuditTrail_DAO {
    public static ArrayList<DBA_FGA_AUDIT_TRAIL> LayThongTinGiamSatFGA() {
        ArrayList<DBA_FGA_AUDIT_TRAIL> dfat = new ArrayList<DBA_FGA_AUDIT_TRAIL>();
        try {          
            String sql = "SELECT DB_USER, OBJECT_NAME, SQL_TEXT,POLICY_NAME, TIMESTAMP FROM sys.DBA_FGA_AUDIT_TRAIL";
            DBConnect conn = new DBConnect();
            conn.GetConnect();           
            ResultSet rs = conn.executeQuery(sql);           
            while (rs.next()) {  
            String DB_USER = rs.getString("DB_USER");
            Timestamp TIMESTAMP = rs.getTimestamp("TIMESTAMP");
            String SQL_TEXT = rs.getString("SQL_TEXT");
            String OBJECT_NAME = rs.getString("OBJECT_NAME");
            String POLICY_NAME = rs.getString("POLICY_NAME");

            DBA_FGA_AUDIT_TRAIL ds = new DBA_FGA_AUDIT_TRAIL(DB_USER, OBJECT_NAME, SQL_TEXT,POLICY_NAME, TIMESTAMP);
            dfat.add(ds);
            System.out.println("Lay du lieu nhan vien thanh cong!");
        }             
        } catch (Exception e) {
            //System.err.println("Lay du lieu nhan vien that bai!");
            e.printStackTrace();
        }
        return dfat;
    }
    
    public static ArrayList<DBA_AUDIT_POLICIES> LayThongTinChinhSachFGA() {
        ArrayList<DBA_AUDIT_POLICIES> dap = new ArrayList<DBA_AUDIT_POLICIES>();
        try {          
            String sql = "SELECT OBJECT_SCHEMA, OBJECT_NAME, POLICY_OWNER, POLICY_NAME, POLICY_COLUMN FROM dba_audit_policies";
            DBConnect conn = new DBConnect();
            conn.GetConnect();           
            ResultSet rs = conn.executeQuery(sql);           
            while (rs.next()) {  
            String OBJECT_SCHEMA = rs.getString("OBJECT_SCHEMA");    
            String OBJECT_NAME = rs.getString("OBJECT_NAME");
            String POLICY_OWNER = rs.getString("POLICY_OWNER");
            String POLICY_NAME = rs.getString("POLICY_NAME");
            String POLICY_COLUMN = rs.getString("POLICY_COLUMN");

            DBA_AUDIT_POLICIES ds = new DBA_AUDIT_POLICIES(OBJECT_SCHEMA, OBJECT_NAME, POLICY_OWNER, POLICY_NAME, POLICY_COLUMN);
            dap.add(ds);
            System.out.println("Lay du lieu nhan vien thanh cong!");
        }             
        } catch (Exception e) {
            //System.err.println("Lay du lieu nhan vien that bai!");
            e.printStackTrace();
        }
        return dap;
    }
    
    public static ArrayList<DBA_AUDIT_POLICIES> LayThongTinChinhSachFGA2() {
        ArrayList<DBA_AUDIT_POLICIES> dap = new ArrayList<DBA_AUDIT_POLICIES>();
        try {          
            String sql = "SELECT OBJECT_SCHEMA, OBJECT_NAME, POLICY_OWNER, POLICY_NAME, POLICY_COLUMN FROM dba_audit_policies where OBJECT_NAME = 'KHACHHANG'";
            DBConnect conn = new DBConnect();
            conn.GetConnect();           
            ResultSet rs = conn.executeQuery(sql);           
            while (rs.next()) {  
            String OBJECT_SCHEMA = rs.getString("OBJECT_SCHEMA");    
            String OBJECT_NAME = rs.getString("OBJECT_NAME");
            String POLICY_OWNER = rs.getString("POLICY_OWNER");
            String POLICY_NAME = rs.getString("POLICY_NAME");
            String POLICY_COLUMN = rs.getString("POLICY_COLUMN");

            DBA_AUDIT_POLICIES ds = new DBA_AUDIT_POLICIES(OBJECT_SCHEMA, OBJECT_NAME, POLICY_OWNER, POLICY_NAME, POLICY_COLUMN);
            dap.add(ds);
            System.out.println("Lay du lieu nhan vien thanh cong!");
        }             
        } catch (Exception e) {
            //System.err.println("Lay du lieu nhan vien that bai!");
            e.printStackTrace();
        }
        return dap;
    }
    
    public static int ThucHienChucNang(String sql) {
        int i = 0;
        try {

            DBConnect conn = new DBConnect();
            conn.GetConnect();
            i = conn.executeUpdate(sql);
//            conn.close();
            System.out.println("Chức năng thực hiện thành công");
        } catch (Exception e) {
            System.out.println("Chức năng thực hiện thất bại");
        }
        return i;
    }
}
