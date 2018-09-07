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
        path.addCircle(250, 250, 100, Path.Direction.CCW);
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

    //模式切换
    private Path.FillType[] modes = {Path.FillType.WINDING, Path.FillType.EVEN_ODD, Path.FillType.INVERSE_EVEN_ODD,
                                     Path.FillType.INVERSE_WINDING};
}
