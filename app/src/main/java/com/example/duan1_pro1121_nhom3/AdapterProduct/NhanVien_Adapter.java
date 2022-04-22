package com.example.duan1_pro1121_nhom3.AdapterProduct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duan1_pro1121_nhom3.Product.NhanVien;
import com.example.duan1_pro1121_nhom3.R;

import java.util.ArrayList;

public class NhanVien_Adapter extends BaseAdapter {
    ArrayList<NhanVien> nhanViens;

    public NhanVien_Adapter(ArrayList<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    @Override
    public int getCount() {
        return nhanViens.size();
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
        View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_nv,viewGroup,false);
        NhanVien nhanVien = nhanViens.get(i);
        TextView tvName,tvGioiTinh,tvVaiTro;
        tvName = view1.findViewById(R.id.txtRowTenNV);
        tvGioiTinh = view1.findViewById(R.id.txtRowGioiTinhNV);
        tvVaiTro = view1.findViewById(R.id.txtRowVaiTroNV);

        tvName.setText(nhanVien.getTenNhanVien());
        tvGioiTinh.setText(nhanVien.getGioiTinh());
        tvVaiTro.setText(nhanVien.getVaiTro());
        return view1;
    }
}
