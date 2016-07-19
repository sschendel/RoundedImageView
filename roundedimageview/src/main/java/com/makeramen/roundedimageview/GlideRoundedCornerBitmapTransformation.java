package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.util.Arrays;

/**
 * Created by seanschendel on 7/19/16.
 */
public class GlideRoundedCornerBitmapTransformation extends BitmapTransformation {
    private ImageView.ScaleType scaleType;
    private float[] cornerRadii = new float[] { 0, 0, 0, 0 };
    private float borderWidth = 0;
    private ColorStateList borderColor;
    private boolean isOval;

    public GlideRoundedCornerBitmapTransformation(Context context, ImageView.ScaleType scaleType, float[] cornerRadii, float borderWidth, ColorStateList borderColor, boolean isOval) {
        super(context);
        this.scaleType = scaleType;
        this.cornerRadii = cornerRadii;
        this.borderWidth = borderWidth;
        this.borderColor = borderColor;
        this.isOval = isOval;
    }


//    return new BitmapTransformation {
//      @Override public Bitmap transform(Bitmap source) {
//        Bitmap transformed = RoundedDrawable.fromBitmap(source)
//            .setScaleType(mScaleType)
//            .setCornerRadius(mCornerRadii[0], mCornerRadii[1], mCornerRadii[2], mCornerRadii[3])
//            .setBorderWidth(mBorderWidth)
//            .setBorderColor(mBorderColor)
//            .setOval(mOval)
//            .toBitmap();
//        if (!source.equals(transformed)) {
//          source.recycle();
//        }
//        return transformed;
//      }
//
//      @Override public String key() {
//        return "r:" + Arrays.toString(mCornerRadii)
//            + "b:" + mBorderWidth
//            + "c:" + mBorderColor
//            + "o:" + mOval;
//      }
//    };


    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap transformed = RoundedDrawable.fromBitmap(toTransform)
            .setScaleType(scaleType)
            .setCornerRadius(cornerRadii[0], cornerRadii[1], cornerRadii[2], cornerRadii[3])
            .setBorderWidth(borderWidth)
            .setBorderColor(borderColor)
            .setOval(isOval)
            .toBitmap();
//        if (!toTransform.equals(transformed)) {
//          toTransform.recycle();
//        }
        return transformed;
    }

    @Override
    public String getId() {
        return "r:" + Arrays.toString(cornerRadii)
            + "b:" + borderWidth
            + "c:" + borderColor
            + "o:" + isOval;
    }
}
