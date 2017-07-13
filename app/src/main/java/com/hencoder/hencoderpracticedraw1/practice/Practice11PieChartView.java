package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    private Paint mPaint = new Paint();

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        mPaint.setAntiAlias(true);

        // 画6个扇形
        mPaint.setColor(Color.parseColor("#FFC107"));
        canvas.drawArc(200, 100, 700, 600, -60, 59, true, mPaint);
        mPaint.setColor(Color.parseColor("#9C27B0"));
        canvas.drawArc(200, 103, 700, 603, 0, 6, true, mPaint);
        mPaint.setColor(Color.parseColor("#9E9E9E"));
        canvas.drawArc(200, 106, 700, 606, 8, 6, true, mPaint);
        mPaint.setColor(Color.parseColor("#009688"));
        canvas.drawArc(200, 109, 700, 609, 16, 45, true, mPaint);
        mPaint.setColor(Color.parseColor("#2196F3"));
        canvas.drawArc(197, 109, 697, 609, 63, 117, true, mPaint);
        mPaint.setColor(Color.parseColor("#F44336"));
        canvas.drawArc(190, 95, 690, 595, -180, 120, true, mPaint);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(40);
        canvas.drawText("饼图", 400, 700, mPaint);

        // 画文字
        Path path1 = new Path();
        path1.moveTo(680, 250);
        path1.rLineTo(100, 0);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        canvas.drawPath(path1, mPaint);
        mPaint.reset();
        mPaint.setTextSize(25);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("Marshmallow", 800, 250, mPaint);

        Path path2 = new Path();
        path2.moveTo(650, 500);
        path2.rLineTo(100, 0);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        canvas.drawPath(path2, mPaint);
        mPaint.reset();
        mPaint.setTextSize(25);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("Jelly Bean", 800, 500, mPaint);

        mPaint.reset();
    }
}
