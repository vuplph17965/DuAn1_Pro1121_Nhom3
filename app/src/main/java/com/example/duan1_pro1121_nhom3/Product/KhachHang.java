package com.example.duan1_pro1121_nhom3.Product;

public class KhachHang {
    int MaKhach;
    String TenKhach;
    int SoDienThoai;
    String DiaChi,GioiTinh;

    public KhachHang() {
    }

    public KhachHang(int maKhach, String tenKhach, int soDienThoai, String diaChi, String gioiTinh) {
        MaKhach = maKhach;
        TenKhach = tenKhach;
        SoDienThoai = soDienThoai;
        DiaChi = diaChi;
        GioiTinh = gioiTinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public int getMaKhach() {
        return MaKhach;
    }

    public void setMaKhach(int maKhach) {
        MaKhach = maKhach;
    }

    public String getTenKhach() {
        return TenKhach;
    }

    public void setTenKhach(String tenKhach) {
        TenKhach = tenKhach;
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
