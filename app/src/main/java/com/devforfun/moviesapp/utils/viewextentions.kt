package com.devforfun.moviesapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.devforfun.moviesapp.R
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(layoutRes : Int) : View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun ImageView.loadUrl(url : String?) {

    if(url != null) {
        Picasso.get().load(url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(this);
    } else {
        Picasso.get().load(context.getString(R.string.default_image)).into(this);
    }
}