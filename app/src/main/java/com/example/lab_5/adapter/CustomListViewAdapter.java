package com.example.lab_5.adapter;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab_5.R;
import com.example.lab_5.entity.Cake;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewAdapter extends BaseAdapter{
    private Context context;
    private int idLayout;
    private List<Cake> listCake;
    private List<Cake> listCakeFilter;
    private int positionSelect = -1;

    public CustomListViewAdapter(Context context, int idLayout, List<Cake> listCake) {
        this.context = context;
        this.idLayout = idLayout;
        this.listCake = listCake;
        this.listCakeFilter = listCake;
    }

    @Override
    public int getCount() {
        if (listCakeFilter.size() != 0 && !listCakeFilter.isEmpty()) {
            return listCakeFilter.size();
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
        final Cake cake = listCakeFilter.get(position);

        if (listCakeFilter != null && !listCakeFilter.isEmpty()) {
            tvTitle.setText(cake.getName());
            tvDescription.setText(cake.getDescription());
            tvPrice.setText(cake.getPrice());
            imageThumnail.setImageResource(cake.getImage());
        }
        return convertView;
    }

    public void filterCake(String cakeName) {
        listCakeFilter = new ArrayList<>();
        for (Cake cake: listCake) {
            if(cake.getName().toLowerCase().indexOf(cakeName) != -1){
                listCakeFilter.add(cake);
            }
        }
        notifyDataSetChanged();
    }
    public void filterPinkDonut () {
        Log.i(TAG, "filterPink");
        filterCake("pink");
        notifyDataSetChanged();
    }

    public void filterFloating() {
        Log.i(TAG, "filterFoating");
        filterCake("floating");
        notifyDataSetChanged();
    }
    public void allDonut() {
        Log.i(TAG, "all");
        listCakeFilter = listCake;
        notifyDataSetChanged();
    }

    public void filterByText(String text) {
        listCakeFilter = new ArrayList<>();
        for (Cake cake: listCake) {
            if(cake.getName().toLowerCase().indexOf(text) != -1){
                listCakeFilter.add(cake);
            }
        }
        notifyDataSetChanged();
    }

}
