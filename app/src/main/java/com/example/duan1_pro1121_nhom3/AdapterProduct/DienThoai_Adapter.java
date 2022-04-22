package com.example.duan1_pro1121_nhom3.AdapterProduct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duan1_pro1121_nhom3.Product.DienThoai;
import com.example.duan1_pro1121_nhom3.Product.NhanVien;
import com.example.duan1_pro1121_nhom3.R;

import java.util.ArrayList;

public class DienThoai_Adapter extends BaseAdapter {
    ArrayList<DienThoai> dienThoais;

    public DienThoai_Adapter(ArrayList<DienThoai> dienThoais) {
        this.dienThoais = dienThoais;
    }

    @Override
    public int getCount() {
        return dienThoais.size();
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
        View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_dt,viewGroup,false);
        TextView tvRowTEN,tvRowTENHANG,tvRowSL,tvRowTrangThai;
        tvRowSL = view1.findViewById(R.id.txtRowSoluongDT);
        tvRowTEN = view1.findViewById(R.id.txtRowTenDT);
        tvRowTENHANG = view1.findViewById(R.id.txtRowTenHangDT_DT);
        tvRowTrangThai = view1.findViewById(R.id.txtRowTrangThaiDT);
        DienThoai dienThoai = dienThoais.get(i);
        tvRowTEN.setText(dienThoai.getTenDT());
        tvRowTENHANG.setText(dienThoai.getTenHang());
        tvRowSL.setText(dienThoai.getSoLuongNhap()+"");
        if(dienThoai.getSoLuongNhap()<=0)
        {
            tvRowTrangThai.setText("Hết Hàng");
        }
        if(dienThoai.getSoLuongNhap()>0)
        {
            tvRowTrangThai.setText("Còn Hàng");
        }

        return view1;
    }
}
