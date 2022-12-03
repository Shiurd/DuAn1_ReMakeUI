/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Form;

import Sevices.NhanVienSevices;
import Sevices.impSevices.INhanVienSevices;
import View.UI_Webcams;
import ViewModels.QLNhanVien;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hacke
 */
public class NhanVien extends javax.swing.JPanel {

    /**
     * Creates new form HoaDon
     */
    DefaultTableModel model;
    INhanVienSevices nhanVienService;
    String anhNhanVien = null;
    String timKiem;
    public String qrcode_Data = null;
    public NhanVien() {
        initComponents();
        model = (DefaultTableModel) tblNhanVien.getModel();
        nhanVienService = new NhanVienSevices();
        loadTblNhanVien();
        detail_NhanVienPanel.setBackground(new Color(237, 231, 225, 100));
        Infomation_Data_NhanVien.setBackground(new Color(237, 231, 225));
        panelQR.setBackground(new Color(237, 231, 225, 100));
        ChucNangPanelNhanVien.setBackground(new Color(237, 231, 225, 200));;
                jPanel1.setBackground(new Color(237, 231, 225, 200));
        rdoNam.setBackground(new Color(237, 231, 225, 100));
        rdoNu.setBackground(new Color(237, 231, 225, 100));
        
        tblNhanVien.removeColumn(tblNhanVien.getColumnModel().getColumn(9));
    }
    
    public void loadTblNhanVien() {
        model.setNumRows(0);
        ArrayList<QLNhanVien> lst = nhanVienService.fillListNhanViens();
        for (QLNhanVien qLNhanVien : lst) {
            model.addRow(new Object[]{
                qLNhanVien.getMaQLNV(),
                qLNhanVien.getTenQLNV(),
                qLNhanVien.getgTinhQLNV(),
                qLNhanVien.getNgaySinhQLNV(),
                qLNhanVien.getDiaChiQLNV(),
                qLNhanVien.getSdtQLNV(),
                qLNhanVien.getCmndQLNV(),
                qLNhanVien.getEmailQLNV(),
                qLNhanVien.getGhiChuQLNV(),
                qLNhanVien.getAnhQLNV()
            });
        }
    }
    private void loadTblTimKiem(String timKiem) {
        ArrayList<QLNhanVien> lst = nhanVienService.fillListNhanViens();
        if (timKiem == null) {
            
            return;
        }
        model.setNumRows(0);
        for (QLNhanVien qlnv : lst) {
            if (qlnv.getMaQLNV().toLowerCase().contains(timKiem.toLowerCase()) || qlnv.getTenQLNV().toLowerCase().contains(timKiem.toLowerCase())
                    || qlnv.getgTinhQLNV().toLowerCase().contains(timKiem.toLowerCase()) || qlnv.getNgaySinhQLNV().toLowerCase().contains(timKiem.toLowerCase())
                    || qlnv.getDiaChiQLNV().toLowerCase().contains(timKiem.toLowerCase()) || qlnv.getSdtQLNV().toLowerCase().contains(timKiem.toLowerCase())
                    || qlnv.getCmndQLNV().toLowerCase().contains(timKiem.toLowerCase()) || qlnv.getEmailQLNV().toLowerCase().contains(timKiem.toLowerCase())
                    || qlnv.getGhiChuQLNV().toLowerCase().contains(timKiem.toLowerCase()) || qlnv.getAnhQLNV().toLowerCase().contains(timKiem.toLowerCase())) {
                model.addRow(new Object[]{
                    qlnv.getMaQLNV(),
                    qlnv.getTenQLNV(),
                    qlnv.getgTinhQLNV(),
                    qlnv.getNgaySinhQLNV(),
                    qlnv.getDiaChiQLNV(),
                    qlnv.getSdtQLNV(),
                    qlnv.getCmndQLNV(),
                    qlnv.getEmailQLNV(),
                    qlnv.getGhiChuQLNV(),
                    qlnv.getAnhQLNV()
                });
            }
        }
    }

    private boolean validateThongTinNhanVien() {
        ArrayList<QLNhanVien> lst = nhanVienService.fillListNhanViens();
        //Mã
        if (txtMaNV.getText().trim().isEmpty()) {
            txtMaNV.setText("Không được để trống");
            txtMaNV.setForeground(Color.red);
            return false;
        }

        if (txtMaNV.getText().length() > 10) {
            txtMaNV.setText("Độ dài không hợp lệ(<10)");
            txtMaNV.setForeground(Color.red);
            return false;
        }

        //Tên
        if (txtTenNV.getText().trim().isEmpty()) {
            txtTenNV.setText("Không được để trống");
            txtTenNV.setForeground(Color.red);
            return false;
        }

        //Ngày Sinh
        Date day = null;
        try {
            SimpleDateFormat fm = new SimpleDateFormat("MM/dd/yyyy");
            day = fm.parse(txtNgaySinh.getText());
        } catch (Exception e) {
            txtNgaySinh.setText("Ngày sinh không hợp lệ(MM/dd/yyyy)!");
            txtNgaySinh.setForeground(Color.red);
            return false;
        }

        //Địa chỉ
        if (txtDiaChi.getText().trim().isEmpty()) {
            txtDiaChi.setText("Không được để trống");
            txtDiaChi.setForeground(Color.red);
            return false;
        }

        //Số điện thoại
        String dinhDangSDT = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if (!txtSDT.getText().matches(dinhDangSDT)) {
            txtSDT.setText("Số điện thoại không hợp lệ!");
            txtSDT.setForeground(Color.red);
            return false;
        }

        //CMND
        String dinhDangCMND = "\\d{12}";
        if (!txtCMND.getText().matches(dinhDangCMND)) {
            txtCMND.setText("Số CMND không hợp lệ!");
            txtCMND.setForeground(Color.red);
            return false;
        }
        for (QLNhanVien qLNhanVien : lst) {
            if (qLNhanVien.getCmndQLNV().equalsIgnoreCase(txtCMND.getText())) {
                txtCMND.setText("Số CMND trùng");
                txtCMND.setForeground(Color.red);
                return false;
            }
        }

        //Email
        String dinhDangEmail = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if (!txtEmail.getText().matches(dinhDangEmail)) {
            txtEmail.setText("Email không hợp lệ!");
            txtEmail.setForeground(Color.red);
            return false;
        }

        //Ghi Chú:
        if (txtGhiChu.getText().trim().isEmpty()) {
            txtGhiChu.setText("Không được để trống");
            txtGhiChu.setForeground(Color.red);
            return false;
        }

        //ảnh
        if (anhNhanVien == null) {
            JOptionPane.showMessageDialog(this, "Ảnh để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void themThongTinNhanVien(QLNhanVien qlnv) {
        String ketQua = nhanVienService.themNhanVien(qlnv);
        loadTblNhanVien();
        JOptionPane.showMessageDialog(this, ketQua);
    }

    private void suaThongTinNhanVien(String maNV, QLNhanVien qlnv) {
        String ketQua = nhanVienService.suaNhanVien(maNV, qlnv);
        loadTblNhanVien();
        JOptionPane.showMessageDialog(this, ketQua);
    }

    private void xoaThongTinNhanVien(String maNV) {
        String ketQua = nhanVienService.xoaNhanVien(maNV);
        loadTblNhanVien();
        txtMaNV.setText("");
        txtTenNV.setText("");
        rdoNam.setSelected(true);
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtCMND.setText("");
        txtEmail.setText("");
        txtGhiChu.setText("");
        //lblAnh
        lblAnhNhanVien.setIcon(null);
        lblAnhNhanVien.setText("Hình ảnh");
        anhNhanVien = null;
        JOptionPane.showMessageDialog(this, ketQua);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        MainTitle = new javax.swing.JLabel();
        panelQR = new javax.swing.JPanel();
        ChucNangPanelNhanVien = new javax.swing.JPanel();
        btnThemNhanVien = new javax.swing.JButton();
        btnSuaNhanVien = new javax.swing.JButton();
        btnXoaNhanVien = new javax.swing.JButton();
        btnTaoMoiNhanVien = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtQRData = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Infomation_Data_NhanVien = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblAnhNhanVien = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtNgaySinh = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        detail_NhanVienPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 102));

        MainTitle.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        MainTitle.setForeground(new java.awt.Color(255, 102, 0));
        MainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MainTitle.setText("QUẢN LÝ NHÂN VIÊN");

        ChucNangPanelNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18))); // NOI18N

        btnThemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        btnThemNhanVien.setText("Thêm");
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        btnSuaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSuaNhanVien.setText("Sửa");
        btnSuaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNhanVienActionPerformed(evt);
            }
        });

        btnXoaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoaNhanVien.setText("Xóa");
        btnXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhanVienActionPerformed(evt);
            }
        });

        btnTaoMoiNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add_1.png"))); // NOI18N
        btnTaoMoiNhanVien.setText("Mới");
        btnTaoMoiNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ChucNangPanelNhanVienLayout = new javax.swing.GroupLayout(ChucNangPanelNhanVien);
        ChucNangPanelNhanVien.setLayout(ChucNangPanelNhanVienLayout);
        ChucNangPanelNhanVienLayout.setHorizontalGroup(
            ChucNangPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucNangPanelNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChucNangPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(ChucNangPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoMoiNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        ChucNangPanelNhanVienLayout.setVerticalGroup(
            ChucNangPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucNangPanelNhanVienLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(ChucNangPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNhanVien)
                    .addComponent(btnSuaNhanVien))
                .addGap(36, 36, 36)
                .addGroup(ChucNangPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaNhanVien)
                    .addComponent(btnTaoMoiNhanVien))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quét QR CCCD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14))); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/qr-code-scan.png"))); // NOI18N
        jButton1.setText("Quét QR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtQRData)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(190, 190, 190))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtQRData, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout panelQRLayout = new javax.swing.GroupLayout(panelQR);
        panelQR.setLayout(panelQRLayout);
        panelQRLayout.setHorizontalGroup(
            panelQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQRLayout.createSequentialGroup()
                .addComponent(ChucNangPanelNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelQRLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelQRLayout.setVerticalGroup(
            panelQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQRLayout.createSequentialGroup()
                .addComponent(ChucNangPanelNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        Infomation_Data_NhanVien.setBackground(new java.awt.Color(102, 102, 102));
        Infomation_Data_NhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18))); // NOI18N
        Infomation_Data_NhanVien.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã Nhân Viên:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Họ Tên:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Giới Tính:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Ngày sinh:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Địa Chỉ:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Số điện thoại:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("CMND:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Email:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Ghi Chú:");

        lblAnhNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblAnhNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblAnhNhanVien.setText("Ảnh");
        lblAnhNhanVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAnhNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhNhanVienMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        txtCMND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCMNDActionPerformed(evt);
            }
        });

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        javax.swing.GroupLayout Infomation_Data_NhanVienLayout = new javax.swing.GroupLayout(Infomation_Data_NhanVien);
        Infomation_Data_NhanVien.setLayout(Infomation_Data_NhanVienLayout);
        Infomation_Data_NhanVienLayout.setHorizontalGroup(
            Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Infomation_Data_NhanVienLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel5)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel26))
                .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Infomation_Data_NhanVienLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rdoNam)
                        .addGap(71, 71, 71)
                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Infomation_Data_NhanVienLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(txtTenNV)
                            .addComponent(txtNgaySinh)
                            .addComponent(txtCMND))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel24)
                    .addComponent(jLabel28)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSDT)
                    .addComponent(txtEmail)
                    .addComponent(txtDiaChi)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(lblAnhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Infomation_Data_NhanVienLayout.setVerticalGroup(
            Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Infomation_Data_NhanVienLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Infomation_Data_NhanVienLayout.createSequentialGroup()
                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Infomation_Data_NhanVienLayout.createSequentialGroup()
                                .addComponent(rdoNu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Infomation_Data_NhanVienLayout.createSequentialGroup()
                        .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Infomation_Data_NhanVienLayout.createSequentialGroup()
                                .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Infomation_Data_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCMND)))
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Infomation_Data_NhanVienLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(95, 95, 95))))
            .addGroup(Infomation_Data_NhanVienLayout.createSequentialGroup()
                .addComponent(lblAnhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        detail_NhanVienPanel.setBackground(new java.awt.Color(255, 255, 255));
        detail_NhanVienPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        detail_NhanVienPanel.setForeground(new java.awt.Color(153, 153, 153));

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaNV", "TenNV", "Giới Tính", "Ngày sinh", "Địa Chỉ ", "Số điện thoại", "CMND", "Email", "GhiChu", "Ảnh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhanVienMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel29.setText("Tìm Kiếm:");

        javax.swing.GroupLayout detail_NhanVienPanelLayout = new javax.swing.GroupLayout(detail_NhanVienPanel);
        detail_NhanVienPanel.setLayout(detail_NhanVienPanelLayout);
        detail_NhanVienPanelLayout.setHorizontalGroup(
            detail_NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detail_NhanVienPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(detail_NhanVienPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1653, Short.MAX_VALUE)
                .addContainerGap())
        );
        detail_NhanVienPanelLayout.setVerticalGroup(
            detail_NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detail_NhanVienPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detail_NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(detail_NhanVienPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Infomation_Data_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(533, 533, 533)
                                .addComponent(MainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(panelQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Infomation_Data_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(detail_NhanVienPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(776, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMousePressed
        // TODO add your handling code here:
        txtQRData.setText("");
        int selectedRow = tblNhanVien.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Chọn 1 nhân viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        txtMaNV.setText(tblNhanVien.getValueAt(selectedRow, 0).toString());
        txtTenNV.setText(tblNhanVien.getValueAt(selectedRow, 1).toString());
        if (tblNhanVien.getValueAt(selectedRow, 2).toString().equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtNgaySinh.setText(tblNhanVien.getModel().getValueAt(selectedRow, 3).toString());
        txtDiaChi.setText(tblNhanVien.getModel().getValueAt(selectedRow, 4).toString());
        txtSDT.setText(tblNhanVien.getModel().getValueAt(selectedRow, 5).toString());
        txtEmail.setText(tblNhanVien.getModel().getValueAt(selectedRow, 7).toString());
        txtCMND.setText(tblNhanVien.getModel().getValueAt(selectedRow, 6).toString());
        txtGhiChu.setText(tblNhanVien.getModel().getValueAt(selectedRow, 8).toString());

        //Load ảnh
        lblAnhNhanVien.setText("");
        anhNhanVien = (String) tblNhanVien.getModel().getValueAt(selectedRow, 9);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/img/" + anhNhanVien));
        Image img = imgIcon.getImage();
        img.getScaledInstance(lblAnhNhanVien.getWidth(), lblAnhNhanVien.getY(), 0);
        lblAnhNhanVien.setIcon(imgIcon);
    }//GEN-LAST:event_tblNhanVienMousePressed

    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed
        // TODO add your handling code here:
        boolean check = validateThongTinNhanVien();
        if (check == false) {
            return;
        }
        //mã trùng
        boolean checkMaTrung = true;
        ArrayList<QLNhanVien> lst = nhanVienService.fillListNhanViens();
        for (QLNhanVien qLNhanVien : lst) {
            if (qLNhanVien.getMaQLNV().equalsIgnoreCase(txtMaNV.getText())) {
                txtMaNV.setText("Mã trùng");
                txtMaNV.setForeground(Color.red);
                checkMaTrung = false;
            }
        }
        if (checkMaTrung == false) {
            return;
        }
        txtMaNV.setForeground(Color.black);
        txtTenNV.setForeground(Color.black);
        txtNgaySinh.setForeground(Color.black);
        txtDiaChi.setForeground(Color.black);
        txtSDT.setForeground(Color.black);
        txtEmail.setForeground(Color.black);
        txtCMND.setForeground(Color.black);
        txtGhiChu.setForeground(Color.black);

        String maNV = txtMaNV.getText();
        String ten = txtTenNV.getText();
        String gioiTinh = "Nam";
        if (rdoNu.isSelected() == true) {
            gioiTinh = "Nữ";
        }
        String ngaySinh = txtNgaySinh.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        String email = txtEmail.getText();
        String cmnd = txtCMND.getText();
        String ghiChu = txtGhiChu.getText();

        QLNhanVien qlnv = new QLNhanVien(maNV, ten, gioiTinh, ngaySinh, diaChi, sdt, cmnd, email, anhNhanVien, ghiChu);

        themThongTinNhanVien(qlnv);
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void btnSuaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNhanVienActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblNhanVien.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Chọn 1 nhân viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String maCanSua = tblNhanVien.getValueAt(selectedRow, 0).toString();

        boolean check = validateThongTinNhanVien();
        if (check == false) {
            return;
        }
        //check mã tồn tại
        boolean checkMa = false;
        ArrayList<QLNhanVien> lst = nhanVienService.fillListNhanViens();
        for (QLNhanVien qLNhanVien : lst) {
            if (qLNhanVien.getMaQLNV().equalsIgnoreCase(maCanSua)) {
                checkMa = true;
            }
        }
        if (checkMa == false) {
            JOptionPane.showMessageDialog(this, "Mã không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        txtMaNV.setForeground(Color.black);
        txtTenNV.setForeground(Color.black);
        txtNgaySinh.setForeground(Color.black);
        txtDiaChi.setForeground(Color.black);
        txtSDT.setForeground(Color.black);
        txtEmail.setForeground(Color.black);
        txtCMND.setForeground(Color.black);
        txtGhiChu.setForeground(Color.black);

        String maNV = txtMaNV.getText();
        String ten = txtTenNV.getText();
        String gioiTinh = "Nam";
        if (rdoNu.isSelected() == true) {
            gioiTinh = "Nữ";
        }
        String ngaySinh = txtNgaySinh.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        String email = txtEmail.getText();
        String cmnd = txtCMND.getText();
        String ghiChu = txtGhiChu.getText();

        QLNhanVien qlnv = new QLNhanVien(maNV, ten, gioiTinh, ngaySinh, diaChi, sdt, cmnd, email, anhNhanVien, ghiChu);

        suaThongTinNhanVien(maCanSua, qlnv);
        selectedRow = -1;
    }//GEN-LAST:event_btnSuaNhanVienActionPerformed

    private void btnXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhanVienActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblNhanVien.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Chọn 1 nhân viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String maCanXoa = tblNhanVien.getValueAt(selectedRow, 0).toString();

        xoaThongTinNhanVien(maCanXoa);
        selectedRow = -1;
    }//GEN-LAST:event_btnXoaNhanVienActionPerformed

    private void btnTaoMoiNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiNhanVienActionPerformed
        // TODO add your handling code here:
        txtMaNV.setText("");
        txtTenNV.setText("");
        rdoNam.setSelected(true);
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtCMND.setText("");
        txtEmail.setText("");
        txtGhiChu.setText("");
        //lblAnh
        lblAnhNhanVien.setIcon(null);
        lblAnhNhanVien.setText("Hình ảnh");
        anhNhanVien = null;

        txtMaNV.setForeground(Color.black);
        txtTenNV.setForeground(Color.black);
        txtNgaySinh.setForeground(Color.black);
        txtDiaChi.setForeground(Color.black);
        txtSDT.setForeground(Color.black);
        txtEmail.setForeground(Color.black);
        txtCMND.setForeground(Color.black);
        txtGhiChu.setForeground(Color.black);
    }//GEN-LAST:event_btnTaoMoiNhanVienActionPerformed

    private void lblAnhNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhNhanVienMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            JFileChooser jfc = new JFileChooser("C:\\Users\\Admin\\Downloads\\DuAn1\\src\\icon");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            anhNhanVien = file.getName();
            lblAnhNhanVien.setText("");
            int width = lblAnhNhanVien.getWidth();
            int height = lblAnhNhanVien.getHeight();
            lblAnhNhanVien.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            //Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblAnhNhanVienMouseClicked

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        // TODO add your handling code here:
        timKiem = txtTimKiem.getText();
        if (timKiem.trim().isEmpty()) {
            model.setNumRows(0);
                    loadTblNhanVien();
            return;
        }
        loadTblTimKiem(timKiem);
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        // TODO add your handling code here:
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtCMNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCMNDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCMNDActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new UI_Webcams().setVisible(true);
        
        txtMaNV.setText("");
        txtTenNV.setText("");
        rdoNam.setSelected(true);
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtCMND.setText("");
        txtEmail.setText("");
        txtGhiChu.setText("");
        //lblAnh
        lblAnhNhanVien.setIcon(null);
        lblAnhNhanVien.setText("Hình ảnh");
        anhNhanVien = null;

        txtMaNV.setForeground(Color.black);
        txtTenNV.setForeground(Color.black);
        txtNgaySinh.setForeground(Color.black);
        txtDiaChi.setForeground(Color.black);
        txtSDT.setForeground(Color.black);
        txtEmail.setForeground(Color.black);
        txtCMND.setForeground(Color.black);
        txtGhiChu.setForeground(Color.black);
        
        txtQRData.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChucNangPanelNhanVien;
    private javax.swing.JPanel Infomation_Data_NhanVien;
    private javax.swing.JLabel MainTitle;
    private javax.swing.JButton btnSuaNhanVien;
    private javax.swing.JButton btnTaoMoiNhanVien;
    private javax.swing.JButton btnThemNhanVien;
    private javax.swing.JButton btnXoaNhanVien;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel detail_NhanVienPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnhNhanVien;
    private javax.swing.JPanel panelQR;
    public static javax.swing.JRadioButton rdoNam;
    public static javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    public static javax.swing.JTextField txtCMND;
    public static javax.swing.JTextField txtDiaChi;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextArea txtGhiChu;
    public static javax.swing.JTextField txtMaNV;
    public static javax.swing.JTextField txtNgaySinh;
    public static javax.swing.JTextField txtQRData;
    public static javax.swing.JTextField txtSDT;
    public static javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
