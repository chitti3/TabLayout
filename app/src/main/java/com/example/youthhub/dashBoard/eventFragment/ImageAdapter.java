package com.example.youthhub.dashBoard.eventFragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.event.gallery.Gallery;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;

import java.util.List;
import java.util.Map;

public class ImageAdapter extends PagerAdapter{

    private List<Gallery> images;
    private LayoutInflater inflater;
    private Activity activity;
    private Map<String,String> imagePaths;

    ImageAdapter(Activity activity, List<Gallery> images, Map<String, String> imagePaths) {
        this.activity = activity;
        this.images=images;
        inflater = LayoutInflater.from(activity);
        this.imagePaths = imagePaths;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.image_slider, view, false);
        ImageView myImage = myImageLayout
                .findViewById(R.id.image);

        Glide.with(activity)
                .load(Constants.getLoadGlide(activity,imagePaths.get("path_medium")+images.get(position).getEgaImage()))
                .apply(AppUtils.getRequestOptionWithoutOverride())
                .into(myImage);

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

}