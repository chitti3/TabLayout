package com.example.youthhub.utils;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

public class ImageTopRadius {

    public static void setRoundRadius(ImageView imageView, final float curveRadius){

        imageView.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0,0,view.getWidth(), (int) (view.getHeight()+curveRadius),curveRadius);
            }
        });

        imageView.setClipToOutline(true);

    }

}
