package com.example.duan1_pro1121_nhom3.Product;

import java.io.Serializable;

public class NhanVien implements Serializable {
    int MaNhanVien;
    String TenNhanVien;
    String UserName;
    String PassWord;
    int SoDienThoai;
    String DiaChi,NgaySinh,GioiTinh,VaiTro;

    public NhanVien() {
    }

    public NhanVien(int maNhanVien, String tenNhanVien, String userName, String passWord, int soDienThoai, String diaChi, String ngaySinh, String gioiTinh, String vaiTro) {
        MaNhanVien = maNhanVien;
        TenNhanVien = tenNhanVien;
        UserName = userName;
        PassWord = passWord;
        SoDienThoai = soDienThoai;
        DiaChi = diaChi;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        VaiTro = vaiTro;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String vaiTro) {
        VaiTro = vaiTro;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        MaNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        TenNhanVien = tenNhanVien;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public int getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
}
