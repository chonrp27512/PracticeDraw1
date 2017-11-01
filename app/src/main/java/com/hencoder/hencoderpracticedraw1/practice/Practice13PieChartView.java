package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice13PieChartView extends View {

    private Paint mPaint = new Paint();

    public Practice13PieChartView(Context context) {
        this(context, null);
    }

    public Practice13PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    Bitmap b1, b2;
    Paint paint;

    public Practice13PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//Canvas和Paint有部分方法不支持硬件加速，如果不关闭，会显示不正常。如组合模式ComposeShader

        paint = new Paint();

        b1 = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(b1);
        paint.setColor(Color.RED);
        canvas.drawCircle(100, 100, 100, paint);

        b2 = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(b2);
        paint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, 100, 100, paint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.GREEN);
        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

        int saveLayer = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(b2, 0, 0, paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(b1, 0, 0, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saveLayer);

    }
}
