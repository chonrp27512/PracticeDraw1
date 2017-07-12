package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint mPaint = new Paint();

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        mPaint.setAntiAlias(true);

        Path path = new Path();
        path.addCircle(300, 300, 100, Path.Direction.CCW);
        path.addCircle(400, 300, 100, Path.Direction.CW);
//        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        canvas.drawPath(path, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        path.moveTo(0, 0);
        path.lineTo(100, 100);
        path.rLineTo(100, 0);
        canvas.drawPath(path, mPaint);

        path.quadTo(300, 100, 300, 180);
        canvas.drawPath(path, mPaint);

        path.moveTo(400, 0);
        path.lineTo(500, 100);
        // 强制移动到弧形起点(无痕迹)
//        path.arcTo(500, 100, 700, 300, -90, 90, true);
        // 直接连线到弧形起点(有痕迹)
        path.arcTo(500, 100, 700, 300, -90, 90, false);
        canvas.drawPath(path, mPaint);

        // 又是一个弧形的方法。一个叫 arcTo ，一个叫 addArc()，都是弧形，区别在哪里？
        // 其实很简单： addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo()
        path.moveTo(700, 0);
        path.lineTo(800, 100);
        path.addArc(800, 100, 1000, 300, -90, 90);
        canvas.drawPath(path, mPaint);

        path.moveTo(300, 100);
        path.lineTo(400, 100);
        path.lineTo(350, 150);
        path.close();   // 把当前的字图形封闭
//        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, mPaint);

        path.moveTo(600, 500);
        path.addCircle(600, 500, 100, Path.Direction.CW);
        path.addCircle(600, 500, 50, Path.Direction.CW);
        path.setFillType(Path.FillType.EVEN_ODD);
//        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, mPaint);

        mPaint.setTextSize(36);
        canvas.drawText("Hello HenCoder", 100, 25, mPaint);

        // 画心形
        Path path2 = new Path();
        path2.addArc(new RectF(600, 200, 800, 400), -225, 225);
        path2.arcTo(new RectF(800, 200, 1000, 400), -180, 225, false);
        path2.lineTo(800, 542);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path2, mPaint);

        mPaint.reset();
    }
}
