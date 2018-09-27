package com.example.abcplusd.igram.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abcplusd.igram.R;
import com.example.abcplusd.igram.activity.TakePhotoActivity;

import butterknife.ButterKnife;

public class PhotoFilterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
      private Context context;
      private int itemsCount = 12;


    public PhotoFilterAdapter(Context context) {
        this.context = context;
    }
//    public PhotoFilterAdapter(TakePhotoActivity takePhotoActivity) {
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_photo_filter, parent, false);
        return new PhotoFilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class PhotoFilterViewHolder extends RecyclerView.ViewHolder {

        public PhotoFilterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
