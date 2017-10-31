package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice13PieChartView extends View {

    private Paint mPaint = new Paint();

    public Practice13PieChartView(Context context) {
        this(context,null);
    }

    public Practice13PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    Shader shader, shader1;
    Shader all;
    Paint paint;

    public Practice13PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setLayerType(View.LAYER_TYPE_SOFTWARE,null);//Canvas和Paint有部分方法不支持硬件加速，如果不关闭，会显示不正常。如组合模式ComposeShader


        paint = new Paint();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.goldrecord_su);
        shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        shader.setLocalMatrix(new Matrix());


        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.mantenghuawenmodianshiliangbeijing_3924704);
        shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        all = new ComposeShader(shader1, shader, PorterDuff.Mode.DST_ATOP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.RED);
        canvas.drawCircle(200,200,200,paint);

        paint.setColor(Color.BLUE);
        canvas.drawRect(200,200,500,500,paint);


    }
}
