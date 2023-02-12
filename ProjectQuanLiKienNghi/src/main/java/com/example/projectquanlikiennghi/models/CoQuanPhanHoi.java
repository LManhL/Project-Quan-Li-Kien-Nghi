package com.example.projectquanlikiennghi.models;

public class CoQuanPhanHoi {
    private String MaCoQuan;
    private String TenCoQuan;
    private String DiaChi;
    private String Hotline;

    public CoQuanPhanHoi(String maCoQuan, String tenCoQuan, String diaChi, String hotline) {
        MaCoQuan = maCoQuan;
        TenCoQuan = tenCoQuan;
        DiaChi = diaChi;
        Hotline = hotline;
    }

    public String getMaCoQuan() {
        return MaCoQuan;
    }

    public void setMaCoQuan(String maCoQuan) {
        MaCoQuan = maCoQuan;
    }

    public String getTenCoQuan() {
        return TenCoQuan;
    }

    public void setTenCoQuan(String tenCoQuan) {
        TenCoQuan = tenCoQuan;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getHotline() {
        return Hotline;
    }

    public void setHotline(String hotline) {
        Hotline = hotline;
    }
}
