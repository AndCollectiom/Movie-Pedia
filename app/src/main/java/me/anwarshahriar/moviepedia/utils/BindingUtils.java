package me.anwarshahriar.moviepedia.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import me.anwarshahriar.moviepedia.R;

/**
 * Created by U on 6/5/2015.
 */
public class BindingUtils {
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).error(R.mipmap.ic_launcher).into(view);
    }
}