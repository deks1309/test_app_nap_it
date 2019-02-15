package com.test.test_app.widget;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;

public class ImageViewBindingAdapter {
  @BindingAdapter({"bind:src"})
  public static void configureImageView(ImageView imageView, String imageURL) {
    Picasso.get().load(imageURL)
        .transform(new RoundedCornerTransformation(5))
        .into(imageView);
  }
}
