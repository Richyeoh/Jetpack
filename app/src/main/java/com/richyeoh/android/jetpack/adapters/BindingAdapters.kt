package com.richyeoh.android.jetpack.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(imageView: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }
}

@BindingAdapter("dateToString")
fun bindDateToString(textView: TextView, date: Date) {
    val sdf = SimpleDateFormat.getInstance()
    val format = sdf.format(date)
    textView.text = format
}
