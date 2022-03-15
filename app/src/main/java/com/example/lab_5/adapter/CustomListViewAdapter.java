package com.example.lab_5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab_5.R;
import com.example.lab_5.entity.Cake;

import java.util.List;

public class CustomListViewAdapter extends BaseAdapter{
    private Context context;
    private int idLayout;
    private List<Cake> listCake;
    private int positionSelect = -1;

    public CustomListViewAdapter(Context context, int idLayout, List<Cake> listCake) {
        this.context = context;
        this.idLayout = idLayout;
        this.listCake = listCake;
    }

    @Override
    public int getCount() {
        if (listCake.size() != 0 && !listCake.isEmpty()) {
            return listCake.size();
        }
        return 0;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvDescription = convertView.findViewById(R.id.tvDescription);
        TextView tvPrice = convertView.findViewById(R.id.tvPrice);
        ImageView imageThumnail = (ImageView) convertView.findViewById(R.id.imageThumnail);
        final Cake cake = listCake.get(position);

        if (listCake != null && !listCake.isEmpty()) {
            tvTitle.setText(cake.getName());
            tvDescription.setText(cake.getDescription());
            tvPrice.setText(cake.getPrice());
            imageThumnail.setImageResource(cake.getImage());
        }
        return convertView;
    }

}
