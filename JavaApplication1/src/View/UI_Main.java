/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Color;
import Utilities.MenuItem;
import View.Form.Bia;
import View.Form.DoanhThu;
import View.Form.HoaDon;
import View.Form.KhoBia;
import View.Form.NSX;
import View.Form.NhanVien;
import View.Form.UIMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Shiurd
 */

public class UI_Main extends javax.swing.JFrame {
    //Variable for drop down menu
    /**
     * Creates new form UI
     */
    Timer tm_MenuLayout;
 // the panels default height = 60
    Integer pl_MenuLayout = 0;
    
    public UI_Main() {
        initComponents();
        
        uiSettings();
        
        createMenuList();
        scrollDownMenu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void uiSettings(){
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
//        panelMain.setBackground(new Color(246, 239, 233,150));
//        headerPanel.setBackground(new Color(243, 156,18,100));
//        labelIcon.setBackground(new Color(243, 156,18,100));
 //       panelMenu_navBarPanel.setBackground(new Color(243, 156,18,100));
        mainUI_Layout.setBackground(new Color(0,0,0,0));
//        menuPanel_list.setBackground(new Color(237, 231, 225,50));
        menuPanel_FirstLayOut.setBackground(new Color(239, 239, 240, 1));
        menuPanel_FirstLayOut.setVisible(false);

        
    }
    
    private void scrollDownMenu(){
        tm_MenuLayout = new Timer(20, (ActionEvent e) -> {
            if (pl_MenuLayout >940) {
                tm_MenuLayout.stop();
                
            } else {
                menuPanel_FirstLayOut.setSize(menuPanel_FirstLayOut.getWidth(),pl_MenuLayout);
                pl_MenuLayout +=20;
            }
        });
        
    }
    private void createMenuList(){
        ImageIcon hoaDonIcon = new ImageIcon(getClass().getResource("/icon/icon/icon_HoaDon.png"));
        ImageIcon nhanVienIcon = new ImageIcon(getClass().getResource("/icon/icon/icon_NhanVien.png"));
        ImageIcon biaIcon = new ImageIcon(getClass().getResource("/icon/icon/icon_Bia.png"));
        ImageIcon khoBiaIcon = new ImageIcon(getClass().getResource("/icon/icon/icon_KhoBia.png"));
        ImageIcon doanhThuIcon = new ImageIcon(getClass().getResource("/icon/icon/icon_DoanhThu.png"));
        ImageIcon nhaSanXuatIcon = new ImageIcon(getClass().getResource("/icon/icon/icon_NSX.png"));
        
        
        MenuItem item1 = new MenuItem(hoaDonIcon,"H??a ????n", (ActionEvent e) -> {
            mainUI_Layout.removeAll();
            mainUI_Layout.add(new HoaDon());
            mainUI_Layout.repaint();
            mainUI_Layout.revalidate();
        });
        
        
        MenuItem item2 = new MenuItem(nhanVienIcon,"Nh??n vi??n", (ActionEvent e) -> {
            mainUI_Layout.removeAll();
            mainUI_Layout.add(new NhanVien());
            mainUI_Layout.repaint();
            mainUI_Layout.revalidate();
        });
        
        MenuItem item3 = new MenuItem(biaIcon,"Bia", (ActionEvent e) -> {
            mainUI_Layout.removeAll();
            mainUI_Layout.add(new Bia());
            mainUI_Layout.repaint();
            mainUI_Layout.revalidate();
        });
        
        MenuItem item4 = new MenuItem(khoBiaIcon,"Kho bia", (ActionEvent e) -> {
            mainUI_Layout.removeAll();
            mainUI_Layout.add(new KhoBia());
            mainUI_Layout.repaint();
            mainUI_Layout.revalidate();
        });
        
        MenuItem item5 = new MenuItem(doanhThuIcon,"Doanh thu", (ActionEvent e) -> {
            mainUI_Layout.removeAll();
            mainUI_Layout.add(new DoanhThu());
            mainUI_Layout.repaint();
            mainUI_Layout.revalidate();
        });
        
        MenuItem item6 = new MenuItem(nhaSanXuatIcon,"Nh?? s???n xu???t", (ActionEvent e) -> {
            mainUI_Layout.removeAll();
            mainUI_Layout.add(new NSX());
            mainUI_Layout.repaint();
            mainUI_Layout.revalidate();
        });
        addMenu(item1,item2,item3,item4,item5,item6);
        
    }
    
    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menuPanel_list.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menuPanel_list.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navbarPanel = new javax.swing.JPanel();
        btnBia = new javax.swing.JPanel();
        btnHoaDon = new javax.swing.JPanel();
        btnKhoBia = new javax.swing.JPanel();
        btnDoanhThu = new javax.swing.JPanel();
        btnNhanVien = new javax.swing.JPanel();
        btnKhuyenMai = new javax.swing.JPanel();
        panelMain = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        labelIcon = new javax.swing.JLabel();
        panelMenu_navBarPanel = new javax.swing.JPanel();
        labelMenu_narBarPanel = new javax.swing.JLabel();
        rod_1_navbarPanelMain = new javax.swing.JPanel();
        menuPanel_FirstLayOut = new javax.swing.JPanel();
        scrollMenuPanel = new javax.swing.JScrollPane();
        menuPanel_list = new javax.swing.JPanel();
        mainUI_Layout = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        navbarPanel.setBackground(new java.awt.Color(255, 204, 102));

        btnBia.setBackground(new java.awt.Color(255, 153, 51));
        btnBia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnBia.setPreferredSize(new java.awt.Dimension(0, 90));
        btnBia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBiaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btnBiaLayout = new javax.swing.GroupLayout(btnBia);
        btnBia.setLayout(btnBiaLayout);
        btnBiaLayout.setHorizontalGroup(
            btnBiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        btnBiaLayout.setVerticalGroup(
            btnBiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        btnHoaDon.setBackground(new java.awt.Color(255, 153, 51));
        btnHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));
        btnHoaDon.setPreferredSize(new java.awt.Dimension(0, 90));
        btnHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHoaDonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btnHoaDonLayout = new javax.swing.GroupLayout(btnHoaDon);
        btnHoaDon.setLayout(btnHoaDonLayout);
        btnHoaDonLayout.setHorizontalGroup(
            btnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        btnHoaDonLayout.setVerticalGroup(
            btnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        btnKhoBia.setBackground(new java.awt.Color(255, 153, 51));
        btnKhoBia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnKhoBia.setPreferredSize(new java.awt.Dimension(0, 90));
        btnKhoBia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnKhoBiaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btnKhoBiaLayout = new javax.swing.GroupLayout(btnKhoBia);
        btnKhoBia.setLayout(btnKhoBiaLayout);
        btnKhoBiaLayout.setHorizontalGroup(
            btnKhoBiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        btnKhoBiaLayout.setVerticalGroup(
            btnKhoBiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        btnDoanhThu.setBackground(new java.awt.Color(255, 153, 51));
        btnDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnDoanhThu.setDoubleBuffered(false);
        btnDoanhThu.setFocusTraversalPolicyProvider(true);
        btnDoanhThu.setPreferredSize(new java.awt.Dimension(0, 90));
        btnDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDoanhThuMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btnDoanhThuLayout = new javax.swing.GroupLayout(btnDoanhThu);
        btnDoanhThu.setLayout(btnDoanhThuLayout);
        btnDoanhThuLayout.setHorizontalGroup(
            btnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        btnDoanhThuLayout.setVerticalGroup(
            btnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        btnNhanVien.setBackground(new java.awt.Color(255, 153, 51));
        btnNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnNhanVien.setPreferredSize(new java.awt.Dimension(0, 90));
        btnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNhanVienMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btnNhanVienLayout = new javax.swing.GroupLayout(btnNhanVien);
        btnNhanVien.setLayout(btnNhanVienLayout);
        btnNhanVienLayout.setHorizontalGroup(
            btnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        btnNhanVienLayout.setVerticalGroup(
            btnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        btnKhuyenMai.setBackground(new java.awt.Color(255, 153, 51));
        btnKhuyenMai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnKhuyenMai.setPreferredSize(new java.awt.Dimension(0, 90));
        btnKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnKhuyenMaiMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btnKhuyenMaiLayout = new javax.swing.GroupLayout(btnKhuyenMai);
        btnKhuyenMai.setLayout(btnKhuyenMaiLayout);
        btnKhuyenMaiLayout.setHorizontalGroup(
            btnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        btnKhuyenMaiLayout.setVerticalGroup(
            btnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout navbarPanelLayout = new javax.swing.GroupLayout(navbarPanel);
        navbarPanel.setLayout(navbarPanelLayout);
        navbarPanelLayout.setHorizontalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBia, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(btnKhoBia, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(btnDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(btnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(btnKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        navbarPanelLayout.setVerticalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKhoBia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(322, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1033));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMain.setBackground(new java.awt.Color(255, 204, 153));
        panelMain.setMinimumSize(new java.awt.Dimension(1920, 1033));
        panelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(255, 153, 51));
        headerPanel.setForeground(new java.awt.Color(255, 255, 255));
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QU???N L?? C??NG VI???C B??N BIA");
        headerPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 380, 90));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Hello, Admin");
        headerPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1433, 30, 179, -1));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        headerPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1261, -9, 10, 110));

        labelIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-beer-bottle-64_1.png"))); // NOI18N
        labelIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelIconMouseEntered(evt);
            }
        });
        headerPanel.add(labelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 90));

        panelMain.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1740, 90));

        panelMenu_navBarPanel.setBackground(new java.awt.Color(255, 153, 0));

        labelMenu_narBarPanel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelMenu_narBarPanel.setForeground(new java.awt.Color(255, 255, 255));
        labelMenu_narBarPanel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelMenu_narBarPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_menu_48px_1.png"))); // NOI18N
        labelMenu_narBarPanel.setText("Menu");
        labelMenu_narBarPanel.setDisplayedMnemonicIndex(0);
        labelMenu_narBarPanel.setIconTextGap(10);
        labelMenu_narBarPanel.setMaximumSize(null);
        labelMenu_narBarPanel.setMinimumSize(new java.awt.Dimension(10, 10));
        labelMenu_narBarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMenu_narBarPanelMouseClicked(evt);
            }
        });

        rod_1_navbarPanelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout rod_1_navbarPanelMainLayout = new javax.swing.GroupLayout(rod_1_navbarPanelMain);
        rod_1_navbarPanelMain.setLayout(rod_1_navbarPanelMainLayout);
        rod_1_navbarPanelMainLayout.setHorizontalGroup(
            rod_1_navbarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        rod_1_navbarPanelMainLayout.setVerticalGroup(
            rod_1_navbarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMenu_navBarPanelLayout = new javax.swing.GroupLayout(panelMenu_navBarPanel);
        panelMenu_navBarPanel.setLayout(panelMenu_navBarPanelLayout);
        panelMenu_navBarPanelLayout.setHorizontalGroup(
            panelMenu_navBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu_navBarPanelLayout.createSequentialGroup()
                .addComponent(labelMenu_narBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rod_1_navbarPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelMenu_navBarPanelLayout.setVerticalGroup(
            panelMenu_navBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMenu_narBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rod_1_navbarPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelMain.add(panelMenu_navBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 90));

        menuPanel_FirstLayOut.setBackground(new java.awt.Color(255, 255, 255));
        menuPanel_FirstLayOut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollMenuPanel.setBackground(new java.awt.Color(255, 255, 255));
        scrollMenuPanel.setBorder(null);

        menuPanel_list.setBackground(new java.awt.Color(255, 255, 255));
        menuPanel_list.setLayout(new javax.swing.BoxLayout(menuPanel_list, javax.swing.BoxLayout.Y_AXIS));
        scrollMenuPanel.setViewportView(menuPanel_list);

        menuPanel_FirstLayOut.add(scrollMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 890));

        panelMain.add(menuPanel_FirstLayOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 180, 940));

        mainUI_Layout.setLayout(new javax.swing.BoxLayout(mainUI_Layout, javax.swing.BoxLayout.LINE_AXIS));
        panelMain.add(mainUI_Layout, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 1740, 890));

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1930, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        panelMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 980, 1930, 60));

        getContentPane().add(panelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1030));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBiaMousePressed
;
    }//GEN-LAST:event_btnBiaMousePressed

    private void btnHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHoaDonMousePressed

    }//GEN-LAST:event_btnHoaDonMousePressed

    private void btnKhoBiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhoBiaMousePressed

    }//GEN-LAST:event_btnKhoBiaMousePressed

    private void btnDoanhThuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoanhThuMousePressed

    }//GEN-LAST:event_btnDoanhThuMousePressed

    private void btnNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanVienMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnNhanVienMousePressed

    private void btnKhuyenMaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhuyenMaiMousePressed

    }//GEN-LAST:event_btnKhuyenMaiMousePressed

    private void labelIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_labelIconMouseEntered

    private void labelMenu_narBarPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenu_narBarPanelMouseClicked
        // TODO add your handling code here:
        if (menuPanel_FirstLayOut.isVisible()) {
            tm_MenuLayout.stop();
            pl_MenuLayout = 0;
            
            menuPanel_FirstLayOut.setVisible(false);
            
            
        } else {
            menuPanel_FirstLayOut.setSize(menuPanel_FirstLayOut.getWidth(), 0);
            tm_MenuLayout.start();
            menuPanel_FirstLayOut.setVisible(true);
            
        }
    }//GEN-LAST:event_labelMenu_narBarPanelMouseClicked

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
            java.util.logging.Logger.getLogger(UI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnBia;
    private javax.swing.JPanel btnDoanhThu;
    private javax.swing.JPanel btnHoaDon;
    private javax.swing.JPanel btnKhoBia;
    private javax.swing.JPanel btnKhuyenMai;
    private javax.swing.JPanel btnNhanVien;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelIcon;
    private javax.swing.JLabel labelMenu_narBarPanel;
    private javax.swing.JPanel mainUI_Layout;
    private javax.swing.JPanel menuPanel_FirstLayOut;
    private javax.swing.JPanel menuPanel_list;
    private javax.swing.JPanel navbarPanel;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelMenu_navBarPanel;
    private javax.swing.JPanel rod_1_navbarPanelMain;
    private javax.swing.JScrollPane scrollMenuPanel;
    // End of variables declaration//GEN-END:variables
}
