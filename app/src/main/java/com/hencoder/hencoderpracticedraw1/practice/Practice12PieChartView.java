package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.ComposeShader;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice12PieChartView extends View {

    private Paint mPaint = new Paint();

    public Practice12PieChartView(Context context) {
        this(context, null);
    }

    public Practice12PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    Shader shader, shader1;
    Shader all;
    Paint paint;

    public Practice12PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//Canvas和Paint有部分方法不支持硬件加速，如果不关闭，会显示不正常。如组合模式ComposeShader


        paint = new Paint();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.goldrecord_su);
        shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        shader.setLocalMatrix(new Matrix());


        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.mantenghuawenmodianshiliangbeijing_3924704);
        shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        all = new ComposeShader(shader1, shader, PorterDuff.Mode.DST);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        使用shader画颜色

        paint.setShader(all);
        canvas.drawRect(0, 0, 800, 600, paint);

        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.goldrecord_shen), 700, 100, paint);


        paint.setShader(new RadialGradient(100, 100, 800, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.MIRROR));
        paint.setTextSize(100);

        canvas.drawText("这是Shader", 0, 100, paint);

        canvas.drawCircle(300, 700, 200, paint);

        paint.setColor(R.color.colorPrimary);
        paint.setColorFilter(new LightingColorFilter(0x00ffff, 0x000000));
        canvas.drawCircle(800, 700, 200, paint);
        paint.setColorFilter(null);
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{
                -0.36F, 1.691F, -0.32F, 0, 0,
                0.32F, 0.398F, 0.275F, 0, 0,
                0.79F, 0.796F, -0.76F, 0, 0,
                0, 0, 0, 1, 0

        }));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a12655479_101932891000_2);
        canvas.drawBitmap(bitmap, 700, 100, paint);


    }
}
