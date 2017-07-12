package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {

    private Paint mPaint = new Paint();

    public Practice3DrawRectView(Context context) {
        super(context);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRect() 方法画矩形
        mPaint.setAntiAlias(true);

        canvas.drawRect(100, 100, 300, 300, mPaint);

        mPaint.setColor(Color.RED);
        Rect rect = new Rect(400, 100, 600, 300);
        canvas.drawRect(rect, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        RectF rectF = new RectF(700, 100, 900, 300);
        canvas.drawRect(rectF, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GREEN);
        canvas.drawRoundRect(100, 400, 300, 600, 50, 50, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        RectF rectF2 = new RectF(400, 400, 600, 600);
        canvas.drawRoundRect(rectF2, 50, 80, mPaint);

        mPaint.reset();
    }
}
