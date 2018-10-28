package com.mainpage.xzkproject01.view.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mainpage.xzkproject01.R;

/**
 * 水波纹view
 */
public class WaveView extends View{

    private Paint paintA;

    public WaveView(Context context) {
        this(context, null, 0);
    }
    public WaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public WaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        {
            Path path=new Path();
            RectF rectF=new RectF(0,0,300,300);
            path.addArc(rectF,0,360);
            canvas.drawPath(path,paintA);
        }
        canvas.translate(300,0);
        {
            Path path=new Path();
            RectF rectF=new RectF(0,0,300,300);
            path.addRect(rectF, Path.Direction.CW);
            canvas.drawPath(path,paintA);
        }
        canvas.translate(-300,300);
        {
            Path path=new Path();
            RectF rectF=new RectF(0,0,300,200);
            path.addArc(rectF,0,360);
            canvas.drawPath(path,paintA);
        }
        canvas.translate(0,250);
        {
            paintA.reset();
            paintA.setColor(getResources().getColor(R.color.color_black_dark6));
            paintA.setStyle(Paint.Style.STROKE);
            paintA.setStrokeCap(Paint.Cap.ROUND);
            paintA.setStrokeWidth(20);
            paintA.setAntiAlias(true);
            Path path=new Path();
            path.moveTo(30,20);
            path.rQuadTo(0,50,50,50);
            path.rQuadTo(50,0,50,-50);
            path.rQuadTo(0,-50,50,-50);
            path.rQuadTo(50,0,50,50);
            path.rQuadTo(0,50,50,50);
            path.rQuadTo(50,0,50,-50);
            path.rQuadTo(0,-50,50,-50);
            path.rQuadTo(50,0,50,50);

            canvas.drawPath(path,paintA);
        }
        canvas.translate(0,60);
        {
            paintA.reset();
            paintA.setColor(getResources().getColor(R.color.color_blue));
            paintA.setStyle(Paint.Style.STROKE);
            paintA.setStrokeCap(Paint.Cap.BUTT);
            paintA.setStrokeWidth(10);
            paintA.setAntiAlias(true);
            Path path=new Path();
            path.moveTo(30,50);
            path.rCubicTo(20,60,100,60,120,0);
            path.rCubicTo(20,-60,100,-60,120,0);
            path.rCubicTo(10,60,110,60,120,0);
            path.rCubicTo(10,-60,110,-60,120,0);

            canvas.drawPath(path,paintA);
        }
        canvas.translate(0,60);
        {
            Path path=new Path();
            path.setFillType(Path.FillType);
        }
    }

    private void initView(){
        paintA = new Paint();
        paintA.setColor(getResources().getColor(R.color.color_brawn2));
        paintA.setStyle(Paint.Style.FILL);
        paintA.setAntiAlias(true);
    }
}
