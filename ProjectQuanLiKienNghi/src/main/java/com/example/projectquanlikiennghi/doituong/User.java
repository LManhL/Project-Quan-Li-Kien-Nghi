package com.example.projectquanlikiennghi.doituong;

public class User {
    private String ho_ten ;
    private String dia_chi;
    private String ngay_sinh;
    private String so_cccd;
    private String gioi_tinh;
    private String so_dt ;

    public User() {
    }

    public User(String ho_ten, String dia_chi, String ngay_sinh, String so_cccd, String gioi_tinh, String so_dt) {
        this.ho_ten = ho_ten;
        this.dia_chi = dia_chi;
        this.ngay_sinh = ngay_sinh;
        this.so_cccd = so_cccd;
        this.gioi_tinh = gioi_tinh;
        this.so_dt = so_dt;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getSo_cccd() {
        return so_cccd;
    }

    public void setSo_cccd(String so_cccd) {
        this.so_cccd = so_cccd;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getSo_dt() {
        return so_dt;
    }

    public void setSo_dt(String so_dt) {
        this.so_dt = so_dt;
    }
}
