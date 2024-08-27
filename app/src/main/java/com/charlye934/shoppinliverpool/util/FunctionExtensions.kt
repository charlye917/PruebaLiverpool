package com.charlye934.shoppinliverpool.util

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StrikethroughSpan
import android.text.style.UnderlineSpan
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.charlye934.shoppinliverpool.R
import java.text.DecimalFormat

fun ImageView.loadImage(url: String) {
    Glide
        .with(context)
        .load(url)
        .override(200, 256)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .centerCrop()
        .into(this)
}

fun Double.formatRealPrice(): SpannableString {
    val formatter = DecimalFormat("$#,###.00")
    val formattedAmount = formatter.format(this)
    val spannableString = SpannableString(formattedAmount)
    val decimalIndex = formattedAmount.indexOf('.')
    val strikethroughSpan = StrikethroughSpan()

    spannableString.setSpan(strikethroughSpan, 1, decimalIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    val grayColor = 0xFF888888.toInt()
    val foregroundColorSpan = ForegroundColorSpan(grayColor)
    spannableString.setSpan(foregroundColorSpan, 0, formattedAmount.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    return spannableString
}

fun Double.formatDiscountPrice(): SpannableString {
    val formatter = DecimalFormat("$#,###.00")
    val formattedAmount = formatter.format(this)

    val spannableString = SpannableString(formattedAmount)
    val redColor = Color.RED
    val foregroundColorSpan = ForegroundColorSpan(redColor)
    spannableString.setSpan(foregroundColorSpan, 0, formattedAmount.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    return spannableString
}