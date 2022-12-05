package com.example.projectquanlikiennghi;

public class KienNghi {
    private String id;
    private String ngay_gui;
    private String noi_dung;
    private String trang_thai;

    public KienNghi(String id, String ngay_gui, String noi_dung, String trang_thai) {
        this.id = id;
        this.ngay_gui = ngay_gui;
        this.noi_dung = noi_dung;
        this.trang_thai = trang_thai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNgay_gui() {
        return ngay_gui;
    }

    public void setNgay_gui(String ngay_gui) {
        this.ngay_gui = ngay_gui;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }
}
