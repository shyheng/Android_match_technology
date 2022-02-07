package com.example.network.assembly;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class SGrid extends GridView {
    public SGrid(Context context) {
        super(context);
    }

    public SGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, i);
    }
}
