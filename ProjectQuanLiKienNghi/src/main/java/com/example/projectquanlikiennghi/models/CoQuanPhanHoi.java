package com.example.projectquanlikiennghi.models;

public class CoQuanPhanHoi {
    private int ID;
    private String MaCoQuan;
    private String TenCoQuan;
    private String DiaChi;
    private String Hotline;

    public CoQuanPhanHoi(int ID, String maCoQuan, String tenCoQuan, String diaChi, String hotline) {
        this.ID = ID;
        MaCoQuan = maCoQuan;
        TenCoQuan = tenCoQuan;
        DiaChi = diaChi;
        Hotline = hotline;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
