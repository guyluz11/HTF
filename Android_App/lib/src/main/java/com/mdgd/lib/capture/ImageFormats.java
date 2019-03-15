package com.mdgd.lib.capture;

import android.graphics.Bitmap;

/**
 * Created by Max
 * on 29/04/2018.
 */
public enum ImageFormats {
    JPEG    ("jpeg", Bitmap.CompressFormat.JPEG),
    PNG     ("png", Bitmap.CompressFormat.PNG),
    WEBP    ("webp", Bitmap.CompressFormat.WEBP);

    ImageFormats(String suffix, Bitmap.CompressFormat format) {
        this.suffix = suffix;
        this.format = format;
    }

    final String suffix;
    final Bitmap.CompressFormat format;
}
