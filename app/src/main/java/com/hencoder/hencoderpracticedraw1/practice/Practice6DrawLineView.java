package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice6DrawLineView extends View {

    private Paint mPaint = new Paint();

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
        mPaint.setAntiAlias(true);

        mPaint.setStrokeWidth(10);
        canvas.drawLine(50, 50, 200, 200, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawLine(100, 50, 250, 200, mPaint);

        mPaint.setColor(Color.GREEN);
        float[] points = {300, 50, 450, 200, 600, 200, 500, 300};
//        canvas.drawLines(points, mPaint);
        canvas.drawLines(points, 2, 4, mPaint);

        mPaint.reset();
    }
}
