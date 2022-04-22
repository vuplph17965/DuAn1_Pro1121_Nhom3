package com.example.duan1_pro1121_nhom3.Product;

public class DienThoai {
    int MaDT;
    String TenDT;
    int Gia;
    String NgaySanXuat;
    int SoLuongNhap;
    int SoLuongXuat;
    int MaHang;
    String TenHang;

    public DienThoai() {
    }

    public DienThoai(int maDT, String tenDT, int gia, String ngaySanXuat, int soLuongNhap, int soLuongXuat, int maHang, String tenHang) {
        MaDT = maDT;
        TenDT = tenDT;
        Gia = gia;
        NgaySanXuat = ngaySanXuat;
        SoLuongNhap = soLuongNhap;
        SoLuongXuat = soLuongXuat;
        MaHang = maHang;
        TenHang = tenHang;
    }

    public int getMaDT() {
        return MaDT;
    }

    public void setMaDT(int maDT) {
        MaDT = maDT;
    }

    public String getTenDT() {
        return TenDT;
    }

    public void setTenDT(String tenDT) {
        TenDT = tenDT;
    }

    public int getMaHang() {
        return MaHang;
    }

    public void setMaHang(int maHang) {
        MaHang = maHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String tenHang) {
        TenHang = tenHang;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public String getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        NgaySanXuat = ngaySanXuat;
    }

    public int getSoLuongNhap() {
        return SoLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        SoLuongNhap = soLuongNhap;
    }

    public int getSoLuongXuat() {
        return SoLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        SoLuongXuat = soLuongXuat;
    }
}
