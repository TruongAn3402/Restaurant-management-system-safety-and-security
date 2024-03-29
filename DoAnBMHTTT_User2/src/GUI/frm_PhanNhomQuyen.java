/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.NhanVien_DAO;
import POJO.NhanVien;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class frm_PhanNhomQuyen extends javax.swing.JFrame {
    Vector tblData = new Vector();
    Vector tblTitle = new Vector();
        
    DefaultTableModel tblModel;
    static ArrayList<NhanVien> dsnv = NhanVien_DAO.LayThongTinNhanVien();
    private String layQuyenNV;

    /**
     * Creates new form frm_PhanNhomQuyen
     */
    public frm_PhanNhomQuyen(String layQuyenNV) {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Decentralization");
        
        bangNhanVien();
        laydulieuNV(dsnv);
        
        this.layQuyenNV=layQuyenNV;
        this.txt_quyen1.setText(layQuyenNV); 
    }

    private frm_PhanNhomQuyen() {
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
        tb_nhanVien.setModel(new DefaultTableModel(tblData, tblTitle));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnTroLai = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_nhanVien = new javax.swing.JTable();
        txt_username = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_thuHoi = new javax.swing.JButton();
        btn_capQuyen = new javax.swing.JButton();
        rda_nhanvien = new javax.swing.JRadioButton();
        rda_admin = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btn_taiLai = new javax.swing.JButton();
        txt_quyen1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Phân Nhóm Quyền Trong Nghiệp Vụ");

        btnTroLai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTroLai.setText("Trở lại");
        btnTroLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroLaiActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14))); // NOI18N

        tb_nhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nhanVienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_nhanVien);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14))); // NOI18N

        btn_thuHoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_thuHoi.setText("Thu Hồi");
        btn_thuHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thuHoiActionPerformed(evt);
            }
        });

        btn_capQuyen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_capQuyen.setText("Cấp Quyền");
        btn_capQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capQuyenActionPerformed(evt);
            }
        });

        rda_nhanvien.setText("Role Nhân Viên");

        rda_admin.setText("Role Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rda_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_thuHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rda_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_capQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_capQuyen)
                    .addComponent(rda_nhanvien))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_thuHoi)
                    .addComponent(rda_admin))
                .addGap(20, 20, 20))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("User Name:");

        btn_taiLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_taiLai.setText("Tải lại");
        btn_taiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLaiActionPerformed(evt);
            }
        });

        txt_quyen1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_quyen1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(81, 81, 81)
                                .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_taiLai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_quyen1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_quyen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addComponent(btn_taiLai)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTroLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroLaiActionPerformed
        frm_QLNhanVien qlnv = new frm_QLNhanVien(layQuyenNV);
        qlnv.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTroLaiActionPerformed

    private void btn_thuHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thuHoiActionPerformed
        // TODO add your handling code here:      
        String manv = txt_username.getText().trim();

        if(rda_admin.isSelected()==true){
            String sql = "REVOKE QuanTriVien_ROLE from "+manv;
            String sql1= "update NV001.nhanvien set QUYEN ='' where MANV='"+manv+"'";
            if(NhanVien_DAO.ThemXoaSuaNhanVien(sql) == 0 && NhanVien_DAO.ThemXoaSuaNhanVien(sql1) > 0 ){
                System.out.println(sql1);
                JOptionPane.showMessageDialog(this,"Thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(rda_nhanvien.isSelected()==true){
            String sql = "REVOKE NhanVien_ROLE from "+manv;
            String sql2= "update NV001.nhanvien set QUYEN ='' where MANV='"+manv+"'";
            if(NhanVien_DAO.ThemXoaSuaNhanVien(sql) == 0 && NhanVien_DAO.ThemXoaSuaNhanVien(sql2) > 0 ){
                JOptionPane.showMessageDialog(this,"Thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }       
    }//GEN-LAST:event_btn_thuHoiActionPerformed

    private void tb_nhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nhanVienMouseClicked
        // TODO add your handling code here:
        int i = tb_nhanVien.getSelectedRow();
        String manv = tb_nhanVien.getValueAt(i, 0).toString().trim();
        txt_username.setText(manv);
    }//GEN-LAST:event_tb_nhanVienMouseClicked

    private void btn_capQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capQuyenActionPerformed
        // TODO add your handling code here:
        String manv = txt_username.getText().trim();
            
        if(rda_admin.isSelected()==true){
            String sql = "GRANT QuanTriVien_ROLE to " +manv;
            String sql1= "update NV001.nhanvien set QUYEN ='Admin' where MANV='"+manv+"'";
            if(NhanVien_DAO.ThemXoaSuaNhanVien(sql) == 0 && NhanVien_DAO.ThemXoaSuaNhanVien(sql1) > 0 ){
                System.out.println(sql1);
                JOptionPane.showMessageDialog(this,"Thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(rda_nhanvien.isSelected()==true){
            String sql = "GRANT NhanVien_ROLE to " +manv;
            String sql2= "update NV001.nhanvien set QUYEN ='NhanVien' where MANV='"+manv+"'";
            if(NhanVien_DAO.ThemXoaSuaNhanVien(sql) == 0 && NhanVien_DAO.ThemXoaSuaNhanVien(sql2) > 0 ){
                JOptionPane.showMessageDialog(this,"Thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }          
    }//GEN-LAST:event_btn_capQuyenActionPerformed

    private void btn_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLaiActionPerformed
        // TODO add your handling code here:
            NhanVien_DAO.LayThongTinNhanVien();
            dsnv = NhanVien_DAO.LayThongTinNhanVien();
            laydulieuNV(dsnv);
    }//GEN-LAST:event_btn_taiLaiActionPerformed

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
            java.util.logging.Logger.getLogger(frm_PhanNhomQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_PhanNhomQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_PhanNhomQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_PhanNhomQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_PhanNhomQuyen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTroLai;
    private javax.swing.JButton btn_capQuyen;
    private javax.swing.JButton btn_taiLai;
    private javax.swing.JButton btn_thuHoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rda_admin;
    private javax.swing.JRadioButton rda_nhanvien;
    private javax.swing.JTable tb_nhanVien;
    private javax.swing.JTextField txt_quyen1;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
