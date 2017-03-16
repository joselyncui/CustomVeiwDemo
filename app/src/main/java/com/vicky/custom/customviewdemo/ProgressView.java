package com.vicky.custom.customviewdemo;/**
 * Created by lenovo on 2016/11/8.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * create by yao.cui at 2016/11/8
 */
public class ProgressView extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private RectF mBgRectF;
    private int mPadding = 8;
    private int mProgress;
    private int mRadius;
    private int mRotate;


    public ProgressView(Context context) {
        super(context);

        initPaint();
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#FFF68F"));

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mWidth = getWidth();
        mHeight = getHeight();
        mBgRectF = new RectF(0,0,mWidth,mHeight);
        mRadius= mHeight/2;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRoundRect(mBgRectF,mHeight/2,mHeight/2,mPaint);


        canvas.drawBitmap(getProgressBmp(),0,0,mPaint);
        mProgress+=5;
        if (mProgress>= mWidth-mPadding){
            mProgress = 0;
        }

        Paint circlePaint = new Paint();
        circlePaint.setStrokeWidth(8);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setColor(Color.WHITE);
        circlePaint.setAntiAlias(true);
        canvas.drawCircle(mWidth-mHeight/2,mHeight/2,mHeight/2-4,circlePaint);

        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(Color.RED);
        canvas.drawCircle(mWidth-mHeight/2,mHeight/2,mHeight/2-8,circlePaint);

        canvas.save();

        Bitmap rotateBmp = BitmapFactory.decodeResource(getResources(),R.drawable.fengshan);
        rotateBmp = Bitmap.createScaledBitmap(rotateBmp,getHeight()-16,getHeight()-16,true);
        canvas.translate(mWidth-mHeight/2,mHeight/2);
        canvas.rotate(mRotate);
        canvas.drawBitmap(rotateBmp,0-rotateBmp.getWidth()/2,0-rotateBmp.getHeight()/2,mPaint);
        canvas.restore();

        mRotate+=10;

        invalidate();
    }

    private Bitmap getProgressBmp(){
        Bitmap output = Bitmap.createBitmap(mWidth,mHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#FFF68F"));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(mPadding,mPadding,mWidth-mPadding,mHeight-mPadding);
        canvas.drawRoundRect(rectF,mHeight/2-mPadding,mHeight/2-mPadding,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint.setColor(Color.RED);

        canvas.drawRect(mPadding,mPadding,mProgress,mHeight-mPadding,paint);
        return output;

    }


}
