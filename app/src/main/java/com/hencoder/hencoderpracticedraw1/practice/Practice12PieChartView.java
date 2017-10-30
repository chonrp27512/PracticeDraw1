package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice12PieChartView extends View {

    private Paint mPaint = new Paint();

    public Practice12PieChartView(Context context) {
        super(context);
    }

    public Practice12PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        使用shader画颜色
        Paint paint = new Paint();
        paint.setShader(new RadialGradient(100, 100, 800, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.MIRROR));
        paint.setTextSize(100);

        canvas.drawText("这是Shader", 0, 100, paint);

        canvas.drawCircle(300, 300, 200, paint);

        canvas.drawCircle(800, 300, 200, paint);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sample_pie_chart);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);

        paint.setShader(shader);
        canvas.drawCircle(300, 700, 200, paint);


    }
}
