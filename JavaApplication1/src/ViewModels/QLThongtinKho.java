/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ViewModels;

/**
 *
 * @author Shiurd
 */
public class QLThongtinKho {
    private String MaKho, DiaChi,TenKho;

    public QLThongtinKho() {
    }

    public QLThongtinKho(String MaKho, String DiaChi, String TenKho) {
        this.MaKho = MaKho;
        this.DiaChi = DiaChi;
        this.TenKho = TenKho;
    }

    

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getTenKho() {
        return TenKho;
    }

    public void setTenKho(String TenKho) {
        this.TenKho = TenKho;
    }


}
