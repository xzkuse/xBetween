package com.mainpage.xzkproject01.view.pathview;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.flawdemo.bridge.log.LogUtils;
import com.mainpage.xzkproject01.R;

/**
 * @author xzk
 * @data 2018/9/8
 * @remark 对pathmeasure的截取做一个处理
 */
public class PathMeasureView extends View {

    private Paint paint;
    private Paint paintCircle;
    private float[] pos;
    private float[] tan;

    private int progress;
    private Matrix matrix;

    public PathMeasureView(Context context) {
        this(context, null, 0);
    }

    public PathMeasureView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathMeasureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.colorRed02));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.FILL);
        paintCircle.setColor(getResources().getColor(R.color.color_black_dark4));
        matrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(100, 100);
        Path path = new Path();
        path.lineTo(0, 100);
        path.lineTo(100, 100);
        path.lineTo(100, 0);
        PathMeasure pathMeasure1 = new PathMeasure(path, false);
        //        pathMeasure1.getSegment(20,120,path,true);
        PathMeasure pathMeasure2 = new PathMeasure(path, true);
        canvas.drawPath(path, paint);

        //截取1/5到2/3处的距离来获得path
        Path pathDst = new Path();
        pathMeasure1.getSegment(pathMeasure1.getLength() / 5,
                                (pathMeasure1.getLength() / 3) * 2, pathDst, true);

        if(progress<20){
            LogUtils.d("pathMeasure1:" + pathMeasure1.getLength());//pathMeasure1:300.0
            LogUtils.d("pathMeasure2:" + pathMeasure2.getLength());//pathMeasure2:400.0
        }
        canvas.translate(200, 0);
        canvas.drawPath(pathDst, paint);

        canvas.translate(200,0);
        Path pathCircle=new Path();
        //方向
        pathCircle.addCircle(200, 200, 100, Path.Direction.CW);
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        canvas.drawPath(pathCircle,paint);
        PathMeasure pathMeasureCircle=new PathMeasure(pathCircle,true);
        pos = new float[2];//作为位置，记录当前 length下的 具体 xy 坐标
        tan = new float[2];//作为正切值，趋势
        pathMeasureCircle.getPosTan((pathMeasureCircle.getLength()/360)*progress, pos, tan);
//        1.通过 tan 得值计算出图片旋转的角度，tan 是 tangent 的缩写，即中学中常见的正切，
        // 其中tan0是邻边边长，tan1是对边边长，而Math中 atan2 方法是根据正切是数值计算出该角度的大小,
        // 得到的单位是弧度，所以上面又将弧度转为了角度。
//        2.通过 Matrix 来设置图片对旋转角度和位移，这里使用的方法与前面讲解过对 canvas操作 有些类似，
        // 对于 Matrix 会在后面专一进行讲解，敬请期待。
//        3.页面刷新，页面刷新此处是在 onDraw 里面调用了 invalidate 方法来保持界面不断刷新，
        // 但并不提倡这么做，正确对做法应该是使用 线程 或者 ValueAnimator 来控制界面的刷新，
        //计算切角值
        float degrees = (float) (Math.atan2(tan[1], tan[0]) * 180.0 / Math.PI);
        if(progress%30==0){
            Log.d("tags",pos[0] + "---" + pos[1] + "pathMeasureCircle:" + degrees);
        }
        canvas.drawCircle(pos[0],pos[1],10,paintCircle);
    }

    public void setProgress(int poi){
        progress=poi%360;
        invalidate();
    }

}
