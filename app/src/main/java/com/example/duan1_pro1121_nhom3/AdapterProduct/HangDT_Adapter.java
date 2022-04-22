package com.example.duan1_pro1121_nhom3.AdapterProduct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duan1_pro1121_nhom3.Product.HangDienThoai;
import com.example.duan1_pro1121_nhom3.R;

import java.util.ArrayList;

public class HangDT_Adapter extends BaseAdapter {
    ArrayList<HangDienThoai> hangDienThoais;

    public HangDT_Adapter(ArrayList<HangDienThoai> hangDienThoais) {
        this.hangDienThoais = hangDienThoais;
    }

    @Override
    public int getCount() {
        return hangDienThoais.size();
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
        View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_hdt,viewGroup,false);
        TextView tenHang = view1.findViewById(R.id.txtRowTenHDT);
        HangDienThoai hangDienThoai = hangDienThoais.get(i);
        tenHang.setText(hangDienThoai.getTenHang());
        return view1;
    }
}
