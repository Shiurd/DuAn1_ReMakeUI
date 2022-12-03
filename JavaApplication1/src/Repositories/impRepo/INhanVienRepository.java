/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.impRepo;

import DomainModels.NhanVien_DomainModels;
import ViewModels.QLNhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hacke
 */
public interface INhanVienRepository {
    ArrayList<NhanVien_DomainModels> getAllNhanViens();
    
    NhanVien_DomainModels mappingNhanVien(ResultSet rs);

    int themNhanVien(QLNhanVien qlnv);

    int suaNhanVien(String maNV, QLNhanVien qlnv);

    int xoaNhanVien(String maNV);
}
