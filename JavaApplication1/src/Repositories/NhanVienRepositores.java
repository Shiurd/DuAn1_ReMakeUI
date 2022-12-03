/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Repositories;

import DomainModels.NhanVien_DomainModels;
import Repositories.impRepo.INhanVienRepository;
import Utilities.JDBCHelper;
import ViewModels.QLNhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shiurd
 */
public class NhanVienRepositores implements INhanVienRepository{
    private final ArrayList<NhanVien_DomainModels> listNhanVien ;
    private final JDBCHelper helper;
    
    public NhanVienRepositores(){
        listNhanVien = new ArrayList<>();
        helper = new JDBCHelper();
    }
    
    @Override
    public ArrayList<NhanVien_DomainModels> getAllNhanViens() {
        ArrayList<NhanVien_DomainModels> lst = new ArrayList<>();
        try {
            String sql = "Select * from NhanVien";
            ResultSet rs = JDBCHelper.selectTongQuat(sql);
            while (rs.next()) {
                NhanVien_DomainModels nv = mappingNhanVien(rs);
                if (nv != null) {
                    lst.add(nv);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepositores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    @Override
    public NhanVien_DomainModels mappingNhanVien(ResultSet rs) {
        if (rs != null) {
            try {
                String ma = rs.getString("MaNV");
                String ten = rs.getString("TenNv");
                String gioiTinh = rs.getString("GioiTinh");
                String ngaySinh = rs.getString("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                String email = rs.getString("Email");
                String cmnd = rs.getString("CMND");
                String anh = rs.getString("Anh");
                String ghiChu = rs.getString("GhiChu");

                return new NhanVien_DomainModels(ma, ten, gioiTinh, ngaySinh, diaChi, sdt, email, cmnd, anh, ghiChu);
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienRepositores.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }
    @Override
    public int themNhanVien(QLNhanVien qlnv) {
        String sql = "insert into NhanVien VALUES (?,?,?,?,?,?,"
                + "?,?,?,?)";
        int affectedRows = JDBCHelper.updateTongQuat(sql, qlnv.getMaQLNV(), qlnv.getTenQLNV(), qlnv.getgTinhQLNV(), qlnv.getNgaySinhQLNV(),
                qlnv.getDiaChiQLNV(), qlnv.getSdtQLNV(), qlnv.getEmailQLNV(), qlnv.getCmndQLNV(), qlnv.getAnhQLNV(), qlnv.getGhiChuQLNV());
        return affectedRows;
    }
    
    @Override
    public int suaNhanVien(String maNV, QLNhanVien qlnv) {
        String sql = "update NhanVien set MaNV = ?, TenNv = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, Sdt = ?, Email = ?, CMND = ?, Anh = ?, GhiChu = ? where MaNV like ?";
        int affectedRows = JDBCHelper.updateTongQuat(sql, qlnv.getMaQLNV(), qlnv.getTenQLNV(), qlnv.getgTinhQLNV(), qlnv.getNgaySinhQLNV(),
                qlnv.getDiaChiQLNV(), qlnv.getSdtQLNV(), qlnv.getEmailQLNV(), qlnv.getCmndQLNV(), qlnv.getAnhQLNV(), qlnv.getGhiChuQLNV(), maNV);
        return affectedRows;
    }
    
    @Override
    public int xoaNhanVien(String maNV) {
        String sql = "Delete NhanVien where MaNV like ?";
        int affectedRows = JDBCHelper.updateTongQuat(sql, maNV);
        return affectedRows;
    }
}
