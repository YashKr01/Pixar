package com.techk.pixar.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun View.hide() {
    isVisible = false
}

fun View.show() {
    isVisible = true
}

fun ImageView.loadImage(
    url: String? = null,
    drawable: Drawable? = null,
    placeHolder: Drawable? = null,
    errorPlaceHolder: Drawable? = null,
    crossFadeDuration: Int = 0,
) {
    Glide.with(this)
        .load(url ?: drawable)
        .placeholder(placeHolder)
        .transition(DrawableTransitionOptions.withCrossFade(crossFadeDuration))
        .error(errorPlaceHolder)
        .into(this)
}

inline fun View.debouncedOnClick(
    debounceTill: Long = 1000,
    crossinline onClick: (v: View) -> Unit,
) {
    setOnClickListener(object : DebouncedOnClickListener(debounceTill) {
        override fun onDebouncedClick(v: View) { onClick.invoke(v) }
    })
}