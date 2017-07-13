package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private Paint mPaint = new Paint();

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        mPaint.setAntiAlias(true);

        // 画图表坐标轴
        Path path = new Path();
        path.moveTo(150, 80);
        path.lineTo(150, 500);
        path.lineTo(900, 500);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        canvas.drawPath(path, mPaint);

        // 画矩形
        Path path2 = new Path();
        path2.addRect(170, 490, 250, 500, Path.Direction.CW);
        path2.addRect(270, 430, 350, 500, Path.Direction.CW);
        path2.addRect(370, 430, 450, 500, Path.Direction.CW);
        path2.addRect(470, 380, 550, 500, Path.Direction.CW);
        path2.addRect(570, 350, 650, 500, Path.Direction.CW);
        path2.addRect(670, 300, 750, 500, Path.Direction.CW);
        path2.addRect(770, 400, 850, 500, Path.Direction.CW);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#72B916"));
        canvas.drawPath(path2, mPaint);

        // 画文字
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(25);
        canvas.drawText("Froyo", 170, 530, mPaint);
        canvas.drawText("GB", 290, 530, mPaint);
        canvas.drawText("ICS", 390, 530, mPaint);
        canvas.drawText("JB", 490, 530, mPaint);
        canvas.drawText("KitKat", 580, 530, mPaint);
        canvas.drawText("L", 700, 530, mPaint);
        canvas.drawText("M", 800, 530, mPaint);

        // 画图表文字
        mPaint.setTextSize(40);
        canvas.drawText("直方图", 450, 650, mPaint);

        mPaint.reset();
    }
}
