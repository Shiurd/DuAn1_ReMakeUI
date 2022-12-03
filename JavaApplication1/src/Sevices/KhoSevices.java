/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Sevices;


import DomainModels.Kho.ThongTinKho;
import DomainModels.Kho.ToanBoKho;
import Repositories.KhoRepositories;
import Repositories.NhanVienRepositores;
import Repositories.impRepo.IKhoRepository;
import Sevices.impSevices.IKhosevices;
import ViewModels.QLThongtinKho;
import ViewModels.QLToanBoKho;
import java.util.ArrayList;

/**
 *
 * @author Shiurd
 */
public class KhoSevices implements IKhosevices{
    private final ArrayList<QLToanBoKho> listDSBiaTrongKho ;
    private final ArrayList<QLThongtinKho> listThongTinKho ;
    private final IKhoRepository khoRepository;
    
    public KhoSevices(){
        listDSBiaTrongKho = new ArrayList<>();
        listThongTinKho = new ArrayList<>();
        khoRepository= new KhoRepositories();
        
    }
    
    //Bang danh sach bia trong kho
    public ArrayList<QLToanBoKho> fillListDSKho(){
        ArrayList<QLToanBoKho> lst = new ArrayList<>();
        ArrayList<ToanBoKho> lstKho = khoRepository.gatAllDSKho();
        for (ToanBoKho tk : lstKho) {
            QLToanBoKho qltbk = new QLToanBoKho();
            qltbk.setMaKho(tk.getMaKho());
            qltbk.setTenKho(tk.getTenKho());
            qltbk.setMaBia(tk.getMaBia());
            qltbk.setTenBia(tk.getTenBia());
            qltbk.setDiaChi(tk.getDiaChi());
            qltbk.setSoLuong(tk.getSoLuong());
            
            lst.add(qltbk);
        }
        return lst;
    }
    
//    //Bang thong tin kho
//    public ArrayList<QLThongtinKho> fillListThongtinKho(){
//        ArrayList<QLThongtinKho> lst = new ArrayList<>();
//        ArrayList<ThongTinKho> listTT  =khoRepository.getAllThongtin();
//        for (ThongTinKho thongTinKho : listTT) {
//            QLThongtinKho qltt = new QLThongtinKho();
//
//        }
//    }
    
}
