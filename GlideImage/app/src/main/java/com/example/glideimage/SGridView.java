package com.example.glideimage;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.GridView;

public class SGridView extends GridView {
    public SGridView(Context context) {
        super(context);
    }

    public SGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, measureSpec);
    }
}
