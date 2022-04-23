package com.example.duan1_pro1121_nhom3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.duan1_pro1121_nhom3.Product.DienThoai;
import com.example.duan1_pro1121_nhom3.Product.HangDienThoai;
import com.example.duan1_pro1121_nhom3.Product.HoaDon;
import com.example.duan1_pro1121_nhom3.Product.KhachHang;
import com.example.duan1_pro1121_nhom3.Product.NhanVien;

import java.util.ArrayList;

public class DAOSP extends SQLiteOpenHelper {
    Context contextx;
    public DAOSP(@Nullable Context context) {
        super(context, "dtbs.txt", null, 1);
        contextx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS NHANVIEN");
        db.execSQL("DROP TABLE IF EXISTS KHACHHANG");
        db.execSQL("DROP TABLE IF EXISTS HANGDT");
        db.execSQL("DROP TABLE IF EXISTS DIENTHOAI");
        db.execSQL("DROP TABLE IF EXISTS HOADON");
        db.execSQL("CREATE TABLE NHANVIEN(MANV INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TENNV TEXT NOT NULL," +
                "USERNAME TEXT NOT NULL," +
                "PASSWORD TEXT NOT NULL," +
                "NUMBERPHONE INTEGER NOT NULL," +
                "DIACHI TEXT NOT NULL," +
                "NGAYSINH TEXT NOT NULL," +
                "GIOITINH TEXT NOT NULL," +
                "VAITRO TEXT NOT NULL) ");
        db.execSQL("CREATE TABLE KHACHHANG(MAKH INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TENKH TEXT NOT NULL," +
                "NUMBERPHONE INTEGER NOT NULL," +
                "DIACHI TEXT NOT NULL," +
                "GIOITINH TEXT NOT NULL) ");
        db.execSQL("CREATE TABLE HANGDT(MAHANG INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TENHANG TEXT NOT NULL)");
        db.execSQL("CREATE TABLE DIENTHOAI(MADT INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TENDT TEXT NOT NULL," +
                "GIANHAP INTEGER NOT NULL," +
                "NGAYSANXUAT TEXT NOT NULL," +
                "SOLUONGNHAP INTEGER NOT NULL," +
                "SOLUONGXUAT INTEGER NOT NULL,"+
                "MAHANG INTEGER REFERENCES HANGDT(MAHANG)," +
                "TENHANG TEXT REFERENCES HANGDT(TENHANG))");
        db.execSQL("CREATE TABLE HOADON(MAHD INTEGER PRIMARY KEY AUTOINCREMENT," +
                "MADT TEXT NOT NULL," +
                "TENDT TEXT NOT NULL," +
                "MAKH INTEGER REFERENCES KHACHHANG(MAKH)," +
                "TENKH TEXT REFERENCES KHACHHANG(TENKH)," +
                "NUMBERPHONE INTEGER REFERENCES KHACHHANG(NUMBERPHONE)," +
                "TONGGIA INTEGER NOT NULL," +
                "TONGTIENTT INTEGER NOT NULL," +
                "NGAYXUAT DATE NOT NULL," +
                "MANV INTEGER REFERENCES NHANVIEN(MANV))");
    }
    public void AddNhanVien(NhanVien nhanVien)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TENNV",nhanVien.getTenNhanVien());
        contentValues.put("USERNAME",nhanVien.getUserName());
        contentValues.put("PASSWORD",nhanVien.getPassWord());
        contentValues.put("NUMBERPHONE",nhanVien.getSoDienThoai());
        contentValues.put("DIACHI",nhanVien.getDiaChi());
        contentValues.put("NGAYSINH",nhanVien.getNgaySinh());
        contentValues.put("GIOITINH",nhanVien.getGioiTinh());
        contentValues.put("VAITRO",nhanVien.getVaiTro());
        SQLiteDatabase database = getReadableDatabase();
        database.insert("NHANVIEN",null,contentValues);


    }

    public NhanVien getOneNV(String MANV_)
    {
        SQLiteDatabase database = getReadableDatabase();
        NhanVien nhanVien = new NhanVien();
        Cursor cursor = database.rawQuery("SELECT * FROM NHANVIEN WHERE MANV = '"+MANV_+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                int MANV = cursor.getInt(0);
                String NAMENV = cursor.getString(1);
                String USERNAME = cursor.getString(2);
                String PASSWORD = cursor.getString(3);
                int NUMBERPHONE = cursor.getInt(4);
                String DIACHI = cursor.getString(5);
                String NGAYSINH = cursor.getString(6);
                String GIOITINH = cursor.getString(7);
                String VAITRO = cursor.getString(8);
                nhanVien = new NhanVien(MANV,NAMENV,USERNAME,PASSWORD,NUMBERPHONE,DIACHI,NGAYSINH,GIOITINH,VAITRO);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return nhanVien;
    }
    public ArrayList<NhanVien> getALLNV()
    {
        SQLiteDatabase database = getReadableDatabase();
        ArrayList<NhanVien> nhanViens = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM NHANVIEN",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                int MaNV = cursor.getInt(0);
                String TENNV = cursor.getString(1);
                String USERNAME = cursor.getString(2);
                String PASSWORD = cursor.getString(3);
                int NUMBERPHONE = cursor.getInt(4);
                String DIACHI = cursor.getString(5);
                String NgaySinh = cursor.getString(6);
                String GIOITINH = cursor.getString(7);
                String VaiTro = cursor.getString(8);
                NhanVien nhanVien = new NhanVien(MaNV,TENNV,USERNAME,PASSWORD,NUMBERPHONE,DIACHI,NgaySinh,GIOITINH,VaiTro);
                nhanViens.add(nhanVien);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return nhanViens;
    }
    public void DeleteNV(String MANV1)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("NHANVIEN","MANV=?",new String[]{MANV1+""});
    }
    public void UpdateNV(NhanVien nhanVien)
    {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TENNV",nhanVien.getTenNhanVien());
        contentValues.put("USERNAME",nhanVien.getUserName());
        contentValues.put("PASSWORD",nhanVien.getPassWord());
        contentValues.put("NUMBERPHONE",nhanVien.getSoDienThoai());
        contentValues.put("DIACHI",nhanVien.getDiaChi());
        contentValues.put("NGAYSINH",nhanVien.getNgaySinh());
        contentValues.put("GIOITINH",nhanVien.getGioiTinh());
        contentValues.put("VAITRO",nhanVien.getVaiTro());
        database.update("NHANVIEN",contentValues,"MANV=?",new String[]{nhanVien.getMaNhanVien()+""});
    }
    //
    public void AddKhachhang(KhachHang khachHang)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TENKH",khachHang.getTenKhach());
        contentValues.put("NUMBERPHONE",khachHang.getSoDienThoai());
        contentValues.put("DIACHI",khachHang.getDiaChi());
        contentValues.put("GIOITINH",khachHang.getGioiTinh());
        SQLiteDatabase database = getWritableDatabase();
        database.insert("KHACHHANG",null,contentValues);
    }
    public KhachHang getOneKH(String MAKH_)
    {
        SQLiteDatabase database = getReadableDatabase();
        KhachHang khachHang = new KhachHang();
        Cursor cursor = database.rawQuery("SELECT * FROM KHACHHANG WHERE MAKH = '"+MAKH_+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                int MAKH = cursor.getInt(0);
                String NAMEKH = cursor.getString(1);
                int NUMBERPHONE = cursor.getInt(2);
                String DIACHI = cursor.getString(3);
                String GIOITINH = cursor.getString(4);
                khachHang = new KhachHang(MAKH,NAMEKH,NUMBERPHONE,DIACHI,GIOITINH);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return khachHang;
    }
    public ArrayList<KhachHang> getALLKH()
    {
        SQLiteDatabase database = getReadableDatabase();
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM KHACHHANG",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                int MAKH = cursor.getInt(0);
                String NAMEKH = cursor.getString(1);
                int NUMBERPHONE = cursor.getInt(2);
                String DIACHI = cursor.getString(3);
                String GIOITINH = cursor.getString(4);
                KhachHang khachHang = new KhachHang(MAKH,NAMEKH,NUMBERPHONE,DIACHI,GIOITINH);
                khachHangs.add(khachHang);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return khachHangs;
    }

    public void DeleteKH(String MAKH)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("KHACHHANG","MAKH=?",new String[]{MAKH+""});
    }
    public void UpdateKH(KhachHang khachHang)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TENKH",khachHang.getTenKhach());
        contentValues.put("NUMBERPHONE",khachHang.getSoDienThoai());
        contentValues.put("DIACHI",khachHang.getDiaChi());
        contentValues.put("GIOITINH",khachHang.getGioiTinh());
        SQLiteDatabase database = getWritableDatabase();
        database.update("KHACHHANG",contentValues,"MAKH=?",new String[]{khachHang.getMaKhach()+""});
    }
    public void AddHangDT(HangDienThoai HDT)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TENHANG",HDT.getTenHang());
        SQLiteDatabase database = getWritableDatabase();
        database.insert("HANGDT",null,contentValues);
    }
    public ArrayList<HangDienThoai> getALL_HDT()
    {
        SQLiteDatabase database = getReadableDatabase();
        ArrayList<HangDienThoai> hangDienThoais = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM HANGDT",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                int MAHANG = cursor.getInt(0);
                String TENHANG = cursor.getString(1);

                HangDienThoai hangDienThoai = new HangDienThoai(MAHANG,TENHANG);
                hangDienThoais.add(hangDienThoai);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return hangDienThoais;
    }

    public void DeleteHDT(HangDienThoai HDT)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("HANGDT","MAHANG=?",new String[]{HDT.getMaHang()+""});
    }
    public void UpdateHDT(HangDienThoai HDT)
    {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TENHANG",HDT.getTenHang());
        database.update("HANGDT",contentValues,"MAHANG=?",new String[]{HDT.getMaHang()+""});
    }
    public void AddHoaDon(HoaDon hoaDon)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("MADT",hoaDon.getMaDT());
        contentValues.put("TENDT",hoaDon.getTenDT());
        contentValues.put("MAKH",hoaDon.getMaKH());
        contentValues.put("TENKH",hoaDon.getTenKH());
        contentValues.put("NUMBERPHONE",hoaDon.getPHONE());
        contentValues.put("TONGGIA",hoaDon.getTongGia());
        contentValues.put("TONGTIENTT",hoaDon.getTongTienTT());
        contentValues.put("NGAYXUAT",hoaDon.getNgayBan());
        contentValues.put("MANV",hoaDon.getMaNV());
        SQLiteDatabase database = getWritableDatabase();
        database.insert("HOADON",null,contentValues);
    }
    public void DeleteHD(String MAHD)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("HOADON","MAHD=?",new String[]{MAHD});
    }
    public void UpdateHoaDon(HoaDon hoaDon)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("MADT",hoaDon.getMaDT());
        contentValues.put("TENDT",hoaDon.getTenDT());
        contentValues.put("MAKH",hoaDon.getMaKH());
        contentValues.put("TENKH",hoaDon.getTenKH());
        contentValues.put("NUMBERPHONE",hoaDon.getPHONE());
        contentValues.put("TONGGIA",hoaDon.getTongGia());
        contentValues.put("TONGTIENTT",hoaDon.getTongTienTT());
        contentValues.put("NGAYXUAT",hoaDon.getNgayBan());
        contentValues.put("MANV",hoaDon.getMaNV());
        SQLiteDatabase database = getWritableDatabase();
        database.update("HOADONCT",contentValues,"MAHDCT=?",new String[]{hoaDon.getMaHoaDon()+""});
    }

    public ArrayList<HoaDon> getALLHD()
    {
        SQLiteDatabase database = getReadableDatabase();
        ArrayList<HoaDon> hoaDonS = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM HOADON",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                int MAHDCT = cursor.getInt(0);
                int MADT = cursor.getInt(1);
                String TENDT = cursor.getString(2);
                int MAKH = cursor.getInt(3);
                String NAMEKH = cursor.getString(4);
                int NUMBERPHONE = cursor.getInt(5);
                int TONGGIA = cursor.getInt(6);
                int TONGTIENTT = cursor.getInt(7);
                String NGAYXUAT = cursor.getString(8);
                int MANV = cursor.getInt(9);
                HoaDon hoaDon = new HoaDon(MAHDCT,MADT,TENDT,MAKH,NAMEKH,NUMBERPHONE,TONGGIA,TONGTIENTT,NGAYXUAT,MANV);
                hoaDonS.add(hoaDon);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return hoaDonS;

    }
    public void AddDT(DienThoai dienThoai)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TENDT",dienThoai.getTenDT());
        contentValues.put("GIANHAP",dienThoai.getGia());
        contentValues.put("NGAYSANXUAT",dienThoai.getNgaySanXuat());
        contentValues.put("SOLUONGNHAP",dienThoai.getSoLuongNhap());
        contentValues.put("SOLUONGXUAT",dienThoai.getSoLuongXuat());
        contentValues.put("MAHANG",dienThoai.getMaHang());
        contentValues.put("TENHANG",dienThoai.getTenHang());
        SQLiteDatabase database = getWritableDatabase();
        database.insert("DIENTHOAI",null,contentValues);
    }
    public ArrayList<DienThoai> getALLDT()
    {
        SQLiteDatabase database = getReadableDatabase();
        ArrayList<DienThoai> dienThoais = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DIENTHOAI",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                int MADT = cursor.getInt(0);
                String TENDT = cursor.getString(1);
                int GIANHAP = cursor.getInt(2);
                String NGAYSANXUAT = cursor.getString(3);
                int SLN = cursor.getInt(4);
                int SLX = cursor.getInt(5);
                int MAHANG = cursor.getInt(6);
                String TENHANG = cursor.getString(7);
                DienThoai dienThoai = new DienThoai(MADT,TENDT,GIANHAP,NGAYSANXUAT,SLN,SLX,MAHANG,TENHANG);
                dienThoais.add(dienThoai);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return dienThoais;
    }

    public void DeleteDT(String MADT)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("DIENTHOAI","MADT=?",new String[]{MADT});
    }
    public void UpdateDT(DienThoai dienThoai)
    {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TENDT",dienThoai.getTenHang());
        contentValues.put("GIANHAP",dienThoai.getGia());
        contentValues.put("NGAYSANXUAT",dienThoai.getNgaySanXuat());
        contentValues.put("SOLUONGNHAP",dienThoai.getSoLuongNhap());
        contentValues.put("SOLUONGXUAT",dienThoai.getSoLuongXuat());
        contentValues.put("MAHANG",dienThoai.getMaHang());
        contentValues.put("TENHANG",dienThoai.getTenHang());
        database.update("DIENTHOAI",contentValues,"MADT=?",new String[]{dienThoai.getMaDT()+""});
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
