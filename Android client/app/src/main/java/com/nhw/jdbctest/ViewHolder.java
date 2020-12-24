package com.nhw.jdbctest;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView img;
    public TextView text;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.horizon_icon);
        text = itemView.findViewById(R.id.horizon_description);
    }
}
