/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Repositories;

import DomainModels.Kho.ThongTinKho;
import DomainModels.Kho.ToanBoKho;
import Repositories.impRepo.IKhoRepository;
import Utilities.JDBCHelper;
import ViewModels.QLThongtinKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shiurd
 */
public class KhoRepositories implements IKhoRepository{
    private final ArrayList<ToanBoKho> listDSBiaTrongKho ;
    private final ArrayList<ThongTinKho> listThongTinKho ;
    
    public KhoRepositories(){
        listDSBiaTrongKho = new ArrayList<>();
        listThongTinKho = new ArrayList<>();
    }
    //----------------------------------------------------------------------------------------------
    //Bảng danh sách bia trong kho
    @Override
    public ArrayList<ToanBoKho> gatAllDSKho(){
        ArrayList<ToanBoKho> lst = new ArrayList<>();
        try {
            String sql = "select A.MaKho, A.TenKho,C.MaBia,C.Ten,A.DiaChi,B.SoLuong from Kho A join KhoChiTiet B on A.MaKho = B.MaKho join Bia C on B.MaBia = C.MaBia order by A.MaKho";
            ResultSet rs = JDBCHelper.selectTongQuat(sql);
            while (rs.next()) {                
                ToanBoKho ds = mappingDSKho(rs);
                lst.add(ds);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoRepositories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
    @Override
    public ToanBoKho mappingDSKho (ResultSet rs){
        if (rs != null) {
            try{
                String maKho = rs.getString("MaKho");
                String tenKho = rs.getString("TenKho");
                String maBia = rs.getString("TenKho");
                String tenBia = rs.getString("TenBia");
                String diaChi = rs.getString("DiaChi");
                Integer soLuong = rs.getInt("Soluong");
                
                return new ToanBoKho(maKho, tenKho, maBia, tenBia, diaChi, soLuong);
            } catch (SQLException ex) {
                Logger.getLogger(KhoRepositories.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------
    //Bang thong tin kho
    @Override
    public ArrayList<ThongTinKho> getAllThongtin(){
        ArrayList<ThongTinKho> lst = new ArrayList<>();
        try {
            String sql = "SELECT * FROM KHO";
            ResultSet rs = JDBCHelper.selectTongQuat(sql);
            while (rs.next()) {                
                ThongTinKho nv = mappingThongTinKho(rs);
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

    public ThongTinKho mappingThongTinKho(ResultSet rs){
        if (rs !=null) {
            try {
                String maKho = rs.getString("MaKho");
                String diaChi = rs.getString("DiaChi");
                String tenKho = rs.getString("TenKho");
                
                return new ThongTinKho(maKho, diaChi, tenKho);
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienRepositores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    @Override
    public int themThongTinKho (QLThongtinKho ttk){
        String sql = "Insert into Kho (MaKho,DiaChi,TenKho) values(?,?,?)";
        int affectedRows = JDBCHelper.updateTongQuat(sql, ttk.getMaKho(),ttk.getDiaChi(),ttk.getTenKho());
        return affectedRows;
    }
    
    @Override
    public int suaThongTinKho (String maKho, QLThongtinKho ttk){
        String sql = "update MaKho = ?, DiaChi =?, TenKho = ? where MaKho like ?";
        int affectedRows = JDBCHelper.updateTongQuat(sql, ttk.getMaKho(),ttk.getDiaChi(),ttk.getTenKho(), maKho);
        return affectedRows;
    }
    
    @Override
    public int xoaThongTinKho (String maKho){
        String sql = "Delete Kho where MaKho like ?";
        int affectedRows = JDBCHelper.updateTongQuat(sql, maKho);
        return affectedRows;
    }
}
