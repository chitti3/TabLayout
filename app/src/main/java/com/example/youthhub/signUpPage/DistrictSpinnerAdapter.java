package com.example.youthhub.signUpPage;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.register.CityList;
import com.example.youthhub.resModel.register.GenderList;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

public class DistrictSpinnerAdapter extends BaseAdapter{

    Activity activity;
    LayoutInflater layoutInflater;
    List<CityList> lists = new ArrayList<>();

    public DistrictSpinnerAdapter(Activity activity, List<CityList> lists) {
        this.activity = activity;
        this.layoutInflater = LayoutInflater.from(activity);
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size()+1;
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
            textView.setText("Select Your City");
            textView.setTextColor(ContextCompat.getColor(activity,R.color.grey));
        }else {
            CityList list = lists.get(position-1);
            view.setTag(list);
            textView.setText(list.getCiName());
        }
        return view;
    }

}
