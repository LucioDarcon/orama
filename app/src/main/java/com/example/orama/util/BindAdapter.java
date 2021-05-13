package com.example.orama.util;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class BindAdapter {

    @BindingAdapter("visibleOrGone")
    public static void visibleOrGone(View view, Boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

}
