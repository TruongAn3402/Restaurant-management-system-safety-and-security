/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.DBConnect;
import DAO.NhanVien_DAO;
import DAO.GiamSatSA_DAO;
import POJO.DBA_AUDIT_TRAIL;
import POJO.NhanVien;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class frm_GiamSatSA extends javax.swing.JFrame {
    Vector tblData = new Vector();
    Vector tblTitle = new Vector();
    DefaultTableModel tblModel;
    
    Vector tblData2 = new Vector();
    Vector tblTitle2 = new Vector();
    DefaultTableModel tblModel2;
    
    static ArrayList<NhanVien> dsnv = NhanVien_DAO.LayThongTinNhanVien();
    static ArrayList<DBA_AUDIT_TRAIL> dat = GiamSatSA_DAO.LayThongTinGiamSat();
    private String layQuyenNV;
    /**
     * Creates new form frm_GiamSatSA
     */
    public frm_GiamSatSA(String layQuyenNV) {
        initComponents();    
        this.setLocationRelativeTo(null);       
      
        bangNhanVien();
        laydulieuNV(dsnv);
        
        bangGiamSatNV();
        layDuLieuGiamSat(dat);
        
        this.layQuyenNV=layQuyenNV;
        this.txt_quyen1.setText(layQuyenNV); 
    }

    private frm_GiamSatSA() {
    }
    
    public void bangNhanVien() {
        tblTitle.add("MANV");
        tblTitle.add("TENNV");
        tblTitle.add("GIOITINH");
        tblTitle.add("NGAYSINH");
        tblTitle.add("DIACHI");
        tblTitle.add("SODT");
        tblTitle.add("EMAIL");
        tblTitle.add("PASSWORD");
        tblTitle.add("QUYEN");
    }
    public void laydulieuNV(ArrayList<NhanVien> dsnv) {
        tblData.removeAllElements();
        for (NhanVien b : dsnv) {
            Vector v = new Vector();
            v.add(b.getMANV());
            v.add(b.getTENNV());
            v.add(b.getGIOITINH());
            v.add(b.getNGAYSINH());
            v.add(b.getDIACHI());
            v.add(b.getSODT());
            v.add(b.getEMAIL());
            v.add(b.getPASS());
            v.add(b.getQUYEN());
            tblData.add(v);
        }
        tb_NhanVien.setModel(new DefaultTableModel(tblData, tblTitle));
    }
    
    public void bangGiamSatNV() {
        tblTitle2.add("username");
        tblTitle2.add("timestamp");
        tblTitle2.add("obj_name");
        tblTitle2.add("action_name");
    }
    public void layDuLieuGiamSat(ArrayList<DBA_AUDIT_TRAIL> dat) {
        tblData2.removeAllElements();
        for (DBA_AUDIT_TRAIL a : dat) {
            Vector v = new Vector();
            v.add(a.getUsername());
            v.add(a.getTimestamp());
            v.add(a.getObj_name());
            v.add(a.getAction_name());
            tblData2.add(v);
        }
        tb_giamSat.setModel(new DefaultTableModel(tblData2, tblTitle2));
    }
    public void layDuLieuGiamSatNV(ArrayList<DBA_AUDIT_TRAIL> LoadDuLieuGiamSatNV) {
        tblData2.removeAllElements();
        for (DBA_AUDIT_TRAIL a : LoadDuLieuGiamSatNV) {
            Vector v = new Vector();
            v.add(a.getUsername());
            v.add(a.getTimestamp());
            v.add(a.getObj_name());
            v.add(a.getAction_name());
            tblData2.add(v);
        }
        tb_giamSat.setModel(new DefaultTableModel(tblData2, tblTitle2));
    }
    
    public ArrayList<DBA_AUDIT_TRAIL> LoadDuLieuGiamSatNV() {
        ArrayList<DBA_AUDIT_TRAIL> dat2 = new ArrayList<DBA_AUDIT_TRAIL>();
        String manv = txt_maNV.getText();
        String tenBang = txt_tenBang.getText();
        try {
            String sql = "SELECT username, TO_CHAR(timestamp, 'YYYY-MM-DD HH24:MI:SS') AS formatted_timestamp, obj_name, action_name "
                    + "FROM dba_audit_trail WHERE username = '"+manv+"' AND obj_name = '"+tenBang+"' "
                    + "GROUP BY username, timestamp, obj_name, action_name";
            DBConnect conn = new DBConnect();
            conn.GetConnect();           
            ResultSet rs = conn.executeQuery(sql);           
            while (rs.next()) {  
            String username = rs.getString("username");
            Timestamp timestamp = rs.getTimestamp("formatted_timestamp");
            String obj_name = rs.getString("obj_name");
            String action_name = rs.getString("action_name");

            DBA_AUDIT_TRAIL ds = new DBA_AUDIT_TRAIL(username, timestamp, obj_name, action_name);
            dat2.add(ds);
            System.out.println("Lay du lieu nhan vien thanh cong!");
        }             
        } catch (Exception e) {
            //System.err.println("Lay du lieu nhan vien that bai!");
            e.printStackTrace();
        }
        return dat2;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_troVe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_NhanVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_maNV = new javax.swing.JTextField();
        btn_GiamSat = new javax.swing.JButton();
        txt_tenBang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_giamSat = new javax.swing.JTable();
        txt_quyen1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_troVe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_troVe.setText("Trở về");
        btn_troVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_troVeActionPerformed(evt);
            }
        });

        tb_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_NhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_NhanVien);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã nhân viên:");

        btn_GiamSat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_GiamSat.setText("Giám sát");
        btn_GiamSat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GiamSatActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên bảng:");

        tb_giamSat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tb_giamSat);

        txt_quyen1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_quyen1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_GiamSat)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_troVe)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_tenBang, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_quyen1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_quyen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_tenBang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_troVe)
                            .addComponent(btn_GiamSat))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tb_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_NhanVienMouseClicked
        int i = tb_NhanVien.getSelectedRow();
        String manv = tb_NhanVien.getValueAt(i, 0).toString().trim();
         
        txt_maNV.setText(manv);
    }//GEN-LAST:event_tb_NhanVienMouseClicked

    private void btn_troVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_troVeActionPerformed
        // TODO add your handling code here:
        frm_QLNhanVien qlnv = new frm_QLNhanVien(layQuyenNV);
        qlnv.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_troVeActionPerformed

    private void btn_GiamSatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GiamSatActionPerformed
        // TODO add your handling code here:
        layDuLieuGiamSatNV(LoadDuLieuGiamSatNV());
    }//GEN-LAST:event_btn_GiamSatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_GiamSatSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_GiamSatSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_GiamSatSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_GiamSatSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_GiamSatSA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_GiamSat;
    private javax.swing.JButton btn_troVe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_NhanVien;
    private javax.swing.JTable tb_giamSat;
    private javax.swing.JTextField txt_maNV;
    private javax.swing.JTextField txt_quyen1;
    private javax.swing.JTextField txt_tenBang;
    // End of variables declaration//GEN-END:variables
}
