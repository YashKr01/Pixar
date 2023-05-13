package com.techk.pixar.utils

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.techk.pixar.data.database.PhotoEntity
import com.techk.pixar.data.network.responses.UnsplashApiResponseItem
import java.util.UUID

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
        override fun onDebouncedClick(v: View) {
            onClick.invoke(v)
        }
    })
}

fun List<UnsplashApiResponseItem>.toPhotoEntityList(): List<PhotoEntity> {
    return this.map {
        PhotoEntity(
            id = it.id ?: UUID.randomUUID().toString(),
            likes = it.likes,
            urls = it.urls,
            user = it.user
        )
    }
}

@Suppress("DEPRECATION")
fun Context.provideHapticFeedback(
    milliseconds: Long
) {
    if (Build.VERSION.SDK_INT >= 26) {
        (getSystemService(VIBRATOR_SERVICE) as Vibrator).vibrate(
            VibrationEffect.createOneShot(milliseconds, VibrationEffect.DEFAULT_AMPLITUDE)
        )
    } else {
        (getSystemService(VIBRATOR_SERVICE) as Vibrator).vibrate(milliseconds)
    }
}