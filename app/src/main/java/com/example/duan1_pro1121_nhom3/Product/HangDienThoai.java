package com.example.duan1_pro1121_nhom3.Product;

public class HangDienThoai {
    int MaHang;
    String TenHang;

    public HangDienThoai() {
    }

    public HangDienThoai(int maHang, String tenHang) {
        MaHang = maHang;
        TenHang = tenHang;
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
}
