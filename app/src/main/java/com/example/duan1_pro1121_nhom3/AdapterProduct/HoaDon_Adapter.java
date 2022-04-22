package com.example.duan1_pro1121_nhom3.AdapterProduct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duan1_pro1121_nhom3.Product.HoaDon;
import com.example.duan1_pro1121_nhom3.R;

import java.util.ArrayList;

public class HoaDon_Adapter extends BaseAdapter {
    ArrayList<HoaDon> hoaDons;

    public HoaDon_Adapter(ArrayList<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    @Override
    public int getCount() {
        return hoaDons.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_hd,viewGroup,false);
        TextView tvMaHD,tvTenKH,tvTenSP,tvNgayMua,tvTongTien;
        tvMaHD = view1.findViewById(R.id.tvRowMaHD);
        tvTenKH = view1.findViewById(R.id.tvRowHD_TENKH);
        tvTenSP = view1.findViewById(R.id.tvRowHD_TENSP);
        tvNgayMua =view1.findViewById(R.id.tvRowHD_NGAYMUA);
        tvTongTien = view1.findViewById(R.id.tvRowHD_TONGTIEN);
        HoaDon hoaDon = hoaDons.get(i);
        tvMaHD.setText(hoaDon.getMaHoaDon());
        tvTenKH.setText(hoaDon.getTenKH());
        tvTenSP.setText(hoaDon.getTenDT());
        tvNgayMua.setText(hoaDon.getNgayBan());
        tvTongTien.setText(hoaDon.getTongGia());
        return view1;
    }
}
