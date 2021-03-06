package com.risnawan.imagevideoslider.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by risnawan on 13 March 2019
 */

public class CustomViewPager extends ViewPager {

    private boolean mustWrapContent=true;

    public CustomViewPager(Context context, boolean mustWrapContent) {
        super(context);
        this.mustWrapContent = mustWrapContent;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mustWrapContent) {
            int height = 0;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                int h = child.getMeasuredHeight();
                if (h > height) height = h;
            }

            if (height != 0) {
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
            }

        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
