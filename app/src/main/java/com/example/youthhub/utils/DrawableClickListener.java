package com.example.youthhub.utils;

/**
 * Created by Ragul Raj on 2/9/2019.
 */

public interface DrawableClickListener {

    public static enum DrawablePosition { TOP, BOTTOM, LEFT, RIGHT };
    public void onClick(DrawablePosition target);
}