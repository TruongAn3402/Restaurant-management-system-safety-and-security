/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.KhachHang;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import javax.crypto.Cipher;

/**
 *
 * @author Admin
 */
public class KhachHang_DAO {
    public static ArrayList<KhachHang> getDSKh() {
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        try {
            String privateKeyBase64 = "MIIEuwIBADANBgkqhkiG9w0BAQEFAASCBKUwggShAgEAAoIBAQC58mi0lUHkjq0frb/MZgSDn4F1qAkaNN7YP9BJnMAzZH8zQa0oolrkjUcRfcLzgY5dsqOG5TTFCHai0whLzzFulR4tD3TWOv5VK5NhD7+TKzrE744IFnxnW8SQ3kvlAAIJbgA65GvPnx9b1ZazzzUB6+wEVLSwkvb+sPFyQfAw9o01DGVZQKdbMCBGE2dieL0aS2BMZlA8BkP94b105/l8wViRw9M/Q1eHlfhmxLYbIZ19jXcgufPV4zT1Xgtp1yoLd8AhYsX3B9DypkZ2KT4NljkNPuzLfw5SpOy442HcWlQUBsLSO8X+HO2mRmnQs/DxdvXZURdejlZYsNJ1cB6NAgMBAAECgf8Xmy6vvkMfQP25h9VRnaH1E8rbpPmC2jNwQKmwrrW30IpVd4EEJ5hia40aK10UjN4GBye7eF26pdhp02C6PxOHdmbeUZgDmnmvVljfeaBYjqRnXAIsBK7GcGAEBDSeXeHkUJK250jIkuroPbVkHmocVFciNZ66y+2PZ+c/Gh/kFzFJh71+IsTvmA9AKNSIqFX3DD9sukSEm5b1A8LGtJ27YXF+joeiHMDz7Km4D8lyCihpOiYFDXfDeNiZNKBMQ5w4XYhkhzi3qD/Uo4t9eYe/kC74Oy+3T5tSXAA4SRbv9MC77/2i9yZy/3C2nLYAX4ChXIY6pNZgphPl8N+TvSECgYEAyp8HPODw1QGcdiFyJqlWr8d7VvjhlZ/lvYQWPm0n2kKJof3sjtDyDcNqMyk7DRDoWG6XuvLyZJ6T92Uw1bbAE2DlzL7FHmojadaKjffQL0D9wl7oN3TWXgJDo8uHrxFA/V59XIpScbAjsJvUNF4ppdwCouQ/QrzkUVCdB/Ie0F0CgYEA6u7ZnnFpU8ENyt/zUuSNauGDh5K6Wib0WqRLv7Fegi5teIv2laRWHe4XKoKpHyM4dLVH+T/jOgSVROJ6NawT36bS6XnEI6V6U4Njl/hJJKxZ/FRtHCdrEbr8SE2QZjUT5u8dSiDfMYfiemSeINw3jgLVkUKDhbGG7QfuNLWiY/ECgYAtIsXS+uzLFmPLMOIj2J8V4yMHmcNuuELON8lYuKojBaVxL4Ztvf/drwVORkYAQB7x7BjirVHvth+SAbmiMeaRqokmVezFPLGM1xzgSS7YB+s/TDMAf4dtQ6Xbq/AawIYwqsbUQX/iEXGx2tSnob43U05HCP9Kl5dowcNpTLcuhQKBgQDm2oPvZMQ6L9csxrnkd3/bSfSkcPM7iVHOC+n/WPxkcdjSfr50t0KEMKSE+lXTqhlc3ZH3A+d16HEBeobaXNg+ikBwel3ZJU855z8jYzAEoHPgNtnss3NLvfEP32AIfxmqcMbYQ8rucfeDi4GzCpJwsqpIDhMNea/7FTLmiqEjEQKBgF92olVD6xZQnRpj6qKrCDbn6ZSaSUU+yx7hQkLMvu045cm0EGV4bsd8F8ithK8lwQh9OUvg230GpEA1mAZjgGQ2yfUTXiNJU7lnhPOvVBPy3bBDUuKAFiue3xHKgEHlrsMkEY6KBDSGMNskqHCbcth4SoAL+1azo2bWGGj6PJ59"; // Thay thế bằng khóa bí mật thực tế
        
            PrivateKey privateKey = decodePrivateKey(privateKeyBase64);
            String sql = "select * from NV001.KHACHHANG ORDER BY MAKH";
            DBConnect cn = new DBConnect();
            cn.GetConnect();
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {          
                String makh = rs.getString("makh");
//                String tenkh = rs.getString("tenkh");
                
                Connection connection = cn.GetConnect(); // Lấy đối tượng Connection
                CallableStatement cs = connection.prepareCall("{CALL NV001.GiaiMaVaXuatThongTinKhachHang(?,?)}");
                cs.setString(1, makh);
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.execute();
                String tenkh_GiaiMa = cs.getString(2);
                
                String gioitinh = rs.getString("gioitinh");
                Date ngaysinh = rs.getDate("ngaysinh"); // Sử dụng kiểu Date cho NgaySinh
                String diachi = rs.getString("diachi");
                String soDTEncrypted = rs.getString("sodt"); // Số điện thoại đã mã hóa

                // Giải mã số điện thoại
                String sodt = decrypt(soDTEncrypted, privateKey);
                
                KhachHang kh = new KhachHang(makh, tenkh_GiaiMa, gioitinh, ngaysinh.toString(), diachi, sodt);
                dskh.add(kh);
            }

        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu khách hàng");
        }
        return dskh;
    }

    public static int ThemXoaSuaKhachHang(String sql) {
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
    
     // Giải mã dữ liệu bằng khóa riêng tư
    public static String decrypt(String encryptedData, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Phân tích khóa riêng tư từ chuỗi Base64
    public static PrivateKey decodePrivateKey(String privateKeyBase64) {
        try {
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
