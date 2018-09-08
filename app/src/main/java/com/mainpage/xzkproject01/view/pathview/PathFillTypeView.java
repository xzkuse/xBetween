package com.mainpage.xzkproject01.view.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.mainpage.xzkproject01.R;

/**
 * @author xzk
 * @data 2018/9/7
 * @remark path填充模式示例
 */
public class PathFillTypeView extends View {

    private Paint paint;
    private int indexModel;

    public PathFillTypeView(Context context) {
        this(context, null, 0);
    }

    public PathFillTypeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathFillTypeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.colorRed01));
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        path.setFillType(modes[indexModel]);
        path.addCircle(200, 200, 100, Path.Direction.CCW);
        path.addCircle(250, 250, 250, Path.Direction.CCW);
        canvas.drawPath(path, paint);
    }

    public String changeModel() {
        indexModel++;
        if (indexModel >= modes.length) {
            indexModel = 0;
        }
        invalidate();
        return modes[indexModel].name();
    }

    //模式切换   path外定义为 两个path合并之后最大的上下左右距离  path内定义为两个path形状最终的相交面积
    private Path.FillType[] modes = {
        Path.FillType.WINDING, //path内全部相交区域进行渲染 path外全部不渲染
        Path.FillType.EVEN_ODD,  //path内相交区域不渲染  path外全部不渲染
        Path.FillType.INVERSE_EVEN_ODD,  //path内相交区域渲染  path外全部渲染
        Path.FillType.INVERSE_WINDING   //path内全部不渲染 path外全部渲染
    };
}
