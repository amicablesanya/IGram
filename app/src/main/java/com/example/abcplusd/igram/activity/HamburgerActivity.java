package com.example.abcplusd.igram.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;

import com.example.abcplusd.igram.R;

public class HamburgerActivity extends DrawerArrowDrawable {

    public HamburgerActivity(Context context){
        super(context);
        setColor(context.getResources().getColor(R.color.Black));
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);

        setBarLength(30.0f);
        setBarThickness(5.0f);
        setGapSize(5.0f);
    }
}

