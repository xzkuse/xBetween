package com.mainpage.xzkproject01.view.pathview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mainpage.xzkproject01.R;

public class CircleView extends View {

    private Paint paint;
    private Bitmap bitmap;

    public CircleView(Context context) {
        this(context, null, 0);
    }
    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.color_black_dark));
        paint.setStrokeCap(Paint.Cap.ROUND);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(100,100,50,paint);

        canvas.translate(0,100);

        Path path=new Path();
        path.addCircle(100,100,50, Path.Direction.CCW);
        canvas.drawPath(path,paint);

        canvas.translate(200,0);

        int width=bitmap.getWidth();
        int height=bitmap.getHeight();
        int r = Math.min(width, height) / 2;
        canvas.drawCircle(r,r,r,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
