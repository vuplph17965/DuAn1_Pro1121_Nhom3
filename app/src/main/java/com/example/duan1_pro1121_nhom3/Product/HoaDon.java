package com.example.duan1_pro1121_nhom3.Product;

public class HoaDon {
    int MaHoaDon,MaDT;
    String TenDT;
    int MaKH;
    String TenKH;
    int PHONE;
    int TongGia;
    int TongTienTT;
    String NgayBan;
    int MaNV;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, int maDT, String tenDT, int maKH, String tenKH, int PHONE, int tongGia, int tongTienTT, String ngayBan, int maNV) {
        MaHoaDon = maHoaDon;
        MaDT = maDT;
        TenDT = tenDT;
        MaKH = maKH;
        TenKH = tenKH;
        this.PHONE = PHONE;
        TongGia = tongGia;
        TongTienTT = tongTienTT;
        NgayBan = ngayBan;
        MaNV = maNV;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        MaHoaDon = maHoaDon;
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

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public int getPHONE() {
        return PHONE;
    }

    public void setPHONE(int PHONE) {
        this.PHONE = PHONE;
    }

    public int getTongGia() {
        return TongGia;
    }

    public void setTongGia(int tongGia) {
        TongGia = tongGia;
    }

    public int getTongTienTT() {
        return TongTienTT;
    }

    public void setTongTienTT(int tongTienTT) {
        TongTienTT = tongTienTT;
    }

    public String getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(String ngayBan) {
        NgayBan = ngayBan;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }
}
