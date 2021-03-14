package com.example.youthhub.signUpPage;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.register.CityList;

public class RoleAdapter extends BaseAdapter {

    Activity activity;
    LayoutInflater layoutInflater;
    String[] data;

    public RoleAdapter(Activity activity,String[] data) {
        this.activity = activity;
        this.layoutInflater = LayoutInflater.from(activity);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length+1;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = View.inflate(activity, R.layout.spinner_items, null);
        TextView textView = view.findViewById(R.id.list_name);
        if(position==0){
            textView.setText("Select Your Role");
            textView.setTextColor(ContextCompat.getColor(activity,R.color.grey));
        }else {
            String data1 = data[position-1];
            view.setTag(data1);
            textView.setText(data1);
        }
        return view;
    }
}
