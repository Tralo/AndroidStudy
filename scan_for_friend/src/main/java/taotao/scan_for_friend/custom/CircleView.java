package taotao.scan_for_friend.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import taotao.scan_for_friend.R;
import taotao.scan_for_friend.utils.DisplayUtils;

/**
 * Created by taotao on 16-5-23.
 */
public class CircleView extends View{

    private Paint mPaint;
    private Bitmap mBitmap;
    private float radius = DisplayUtils.dp2px(getContext(),0);
    private float disX;
    private float disY;
    private float angle;
    private float proportion;

    public float getProportion() {
        return proportion;
    }

    public void setProportion(float proportion) {
        this.proportion = proportion;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getDisY() {
        return disY;
    }

    public void setDisY(float disY) {
        this.disY = disY;
    }

    public float getDisX() {
        return disX;
    }

    public void setDisX(float disX) {
        this.disX = disX;
    }

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.bg_color_pink));
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureSize(widthMeasureSpec), measureSize(heightMeasureSpec));
    }

    private int measureSize(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        } else {
            result = DisplayUtils.dp2px(getContext(),18);
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(radius,radius,radius,mPaint);
        if(mBitmap != null){
            canvas.drawBitmap(mBitmap,null,new Rect(0,0,2 * (int) radius,2 * (int)radius),mPaint);
        }
    }

    public void setPaintColor(int resId){
        mPaint.setColor(resId);
        invalidate();
    }

    public void setPortraitIcon(int resId){
        mBitmap = BitmapFactory.decodeResource(getResources(),resId);
        invalidate();
    }
    public void clearPortaitIcon(){
        mBitmap = null;
        invalidate();
    }

}
