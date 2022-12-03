/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.impRepo;

import DomainModels.Kho.ThongTinKho;
import DomainModels.Kho.ToanBoKho;
import ViewModels.QLThongtinKho;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hacke
 */
public interface IKhoRepository {
    ArrayList<ToanBoKho> gatAllDSKho();
    
    ToanBoKho mappingDSKho (ResultSet rs);
    
    ArrayList<ThongTinKho> getAllThongtin();
    
    ThongTinKho mappingThongTinKho(ResultSet rs);
    
    int themThongTinKho (QLThongtinKho ttk);
    
    int suaThongTinKho (String maKho, QLThongtinKho ttk);
    
    int xoaThongTinKho (String maKho);
}
