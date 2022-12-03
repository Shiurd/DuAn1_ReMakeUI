/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Sevices;

import DomainModels.NhanVien_DomainModels;
import Repositories.NhanVienRepositores;
import Repositories.impRepo.INhanVienRepository;
import Sevices.impSevices.INhanVienSevices;
import ViewModels.QLNhanVien;
import java.util.ArrayList;

/**
 *
 * @author Shiurd
 */
public class NhanVienSevices implements INhanVienSevices{
    private final ArrayList<QLNhanVien> lstQLNhanViens;
    private final INhanVienRepository nhanVienRepository;
    
    public NhanVienSevices() {
        lstQLNhanViens = new ArrayList<>();
        nhanVienRepository = new NhanVienRepositores();
    }
    
    @Override
    public ArrayList<QLNhanVien> fillListNhanViens() {
        ArrayList<QLNhanVien> lst = new ArrayList<>();
        ArrayList<NhanVien_DomainModels> lstNhanViens = nhanVienRepository.getAllNhanViens();
        for (NhanVien_DomainModels nv : lstNhanViens) {
            QLNhanVien qlnv = new QLNhanVien();
            qlnv.setMaQLNV(nv.getMa());
            qlnv.setTenQLNV(nv.getTen());
            qlnv.setgTinhQLNV(nv.getGioiTinh());
            qlnv.setNgaySinhQLNV(nv.getNgaySinh());
            qlnv.setDiaChiQLNV(nv.getDiaChi());
            qlnv.setSdtQLNV(nv.getSdt());
            qlnv.setEmailQLNV(nv.getEmail());
            qlnv.setCmndQLNV(nv.getCmnd());
            qlnv.setAnhQLNV(nv.getAnh());
            qlnv.setGhiChuQLNV(nv.getGhiChu());

            lst.add(qlnv);
        }
        return lst;
    }
    
    @Override
    public String themNhanVien(QLNhanVien qlnv) {
        int affectedRows = nhanVienRepository.themNhanVien(qlnv);
        if (affectedRows > 0) {
            return "Thêm Thành Công";
        }
        return "Thêm Thất Bại";
    }
    
    @Override
    public String suaNhanVien(String maNV, QLNhanVien qlnv) {
        int affectedRows = nhanVienRepository.suaNhanVien(maNV, qlnv);
        if (affectedRows > 0) {
            return "Sửa Thành Công";
        }
        return "Sửa Thất Bại";
    }
    
    @Override
    public String xoaNhanVien(String maNV) {
        int affectedRows = nhanVienRepository.xoaNhanVien(maNV);
        if (affectedRows > 0) {
            return "Xóa Thành Công";
        }
        return "Xóa Thất Bại";
    }
}
    
