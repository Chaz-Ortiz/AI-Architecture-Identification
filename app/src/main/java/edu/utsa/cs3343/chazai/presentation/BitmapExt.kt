package edu.utsa.cs3343.chazai.presentation

import android.graphics.Bitmap

fun Bitmap.centerCrop(desiredWidth: Int, desiredHeight: Int): Bitmap {
    val xstart = (width - desiredWidth) / 2
    val ystart = (height - desiredHeight) / 2

    if(xstart < 0 || ystart < 0 || desiredWidth > width || desiredHeight > height) {
        throw IllegalArgumentException("Invalid arguments for center cropping")
    }

    return Bitmap.createBitmap(this, xstart, ystart, desiredWidth, desiredHeight)
}