package com.example.projectquanlikiennghi.models;

public class KienNghi {
    private int STT;
    private String Ma_kien_nghi;
    private String Ngaygui;
    private String Noidung;
    private int Trangthai;
    private String Noidungphanhoi;
    private String Ngayphanhoi;
    private String Loai;

    public KienNghi(int stt,String ma_kien_nghi, String ngaygui, String noidung, int trangthai,
                      String noidungphanhoi, String ngayphanhoi, String loai) {
        STT=stt;
        Ma_kien_nghi = ma_kien_nghi;
        Ngaygui = ngaygui;
        Noidung = noidung;
        Trangthai = trangthai;
        Noidungphanhoi = noidungphanhoi;
        Ngayphanhoi = ngayphanhoi;
        Loai = loai;
    }

    public KienNghi(int stt, String ngaygui, int trangthai) {
        this.STT=stt;
        this.Trangthai=trangthai;
        this.Ngaygui=ngaygui;
    }

    public String getMa_kien_nghi() {
        return Ma_kien_nghi;
    }

    public void setMa_kien_nghi(String ma_kien_nghi) {
        Ma_kien_nghi = ma_kien_nghi;
    }

    public String getNgaygui() {
        return Ngaygui;
    }

    public void setNgaygui(String ngaygui) {
        Ngaygui = ngaygui;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String noidung) {
        Noidung = noidung;
    }

    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(int trangthai) {
        Trangthai = trangthai;
    }

    public String getNoidungphanhoi() {
        return Noidungphanhoi;
    }

    public void setNoidungphanhoi(String noidungphanhoi) {
        Noidungphanhoi = noidungphanhoi;
    }

    public String getNgayphanhoi() {
        return Ngayphanhoi;
    }

    public void setNgayphanhoi(String ngayphanhoi) {
        Ngayphanhoi = ngayphanhoi;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }
}
