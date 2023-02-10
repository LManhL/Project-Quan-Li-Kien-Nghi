package com.example.projectquanlikiennghi.models;

public class Account {
    private int ID;
    private String Hovaten;
    private String SDT;
    private String Diachi;
    private String Gioitinh;
    private String Namsinh;
    private String CCCD;
    private String Username;
    private String Password;
    private String role;
    private int SoKN;

    public Account(int id, String hovaten, String sdt, String diachi, String gioitinh,
                   String namsinh, String cccd, String username,int sokn) {
        this.ID = id;
        this.Hovaten = hovaten;
        this.SDT = sdt;
        this.Diachi = diachi;
        this.Gioitinh = gioitinh;
        this.Namsinh = namsinh;
        this.CCCD = cccd;
        this.Username = username;
        this.SoKN = sokn;
    }
    public Account(String hovaten, String sdt, String diachi, String gioitinh,
                   String namsinh, String cccd, String username, String password, String quyen) {
        this.Hovaten = hovaten;
        this.SDT = sdt;
        this.Diachi = diachi;
        this.Gioitinh = gioitinh;
        this.Namsinh = namsinh;
        this.CCCD = cccd;
        this.Username = username;
        this.Password = password;
        this.role = quyen;
        this.SoKN = 0;
    }

    public Account() {

    }


    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public String getHovaten() {
        return Hovaten;
    }

    public void setHovaten(String hovaten) {
        Hovaten = hovaten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String sdt) {
        this.SDT = sdt;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        Gioitinh = gioitinh;
    }

    public String getNamsinh() {
        return Namsinh;
    }

    public void setNamsinh(String namsinh) {
        Namsinh = namsinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String cccd) {
        this.CCCD = cccd;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getSoKN() {
        return SoKN;
    }

    public void setSoKN(int soKN) {
        SoKN = soKN;
    }
}
