package com.example.orama.util;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.example.orama.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class ExpandableUtil {

    public static void configExpandableLayout(Activity activity, ImageView imageView, ExpandableLayout expandableLayout) {
        Drawable expandLessDrawable = ContextCompat.getDrawable(activity, R.drawable.ic_baseline_expand_less_24);
        Drawable expandMoreDrawable = ContextCompat.getDrawable(activity, R.drawable.ic_baseline_expand_more_24);

        imageView.setOnClickListener(v -> {
            boolean layoutIsExpanded = expandableLayout.isExpanded();
            expandableLayout.setExpanded(!layoutIsExpanded);

            if(layoutIsExpanded) {
                imageView.setImageDrawable(expandMoreDrawable);
            } else {
                imageView.setImageDrawable(expandLessDrawable);
            }

        });
    }

}
