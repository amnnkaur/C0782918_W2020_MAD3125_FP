package com.example.c0782918_w2020_mad3125_fp.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.c0782918_w2020_mad3125_fp.R;

public class GlideBindingAdapter {

        @BindingAdapter("imageURL")
        public static void setImageResource(ImageView view, int imageURL){

            Context context = view.getContext();

            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background);

            Glide.with(context)
                    .setDefaultRequestOptions(options)
                    .load(imageURL)
                    .into(view);

        }
    }

