package com.vadivelansr.android.tourguide.config;

import android.content.Context;
import android.content.res.TypedArray;

import com.vadivelansr.android.tourguide.R;

import java.util.Random;

/**
 * Created by vadivelansr on 6/12/2016.
 */
public class Utility {
    public static int getColor(Context context) {
        Random random = new Random();
        TypedArray colorArray = context.getResources().obtainTypedArray(R.array.colors);
        return colorArray.getResourceId(random.nextInt(4), -1);
    }
}
