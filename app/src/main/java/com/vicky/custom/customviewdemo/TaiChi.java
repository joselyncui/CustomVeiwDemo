package com.vicky.custom.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * create by yao.cui at 2016/11/8
 */
public class TaiChi extends View {

    private int mWidth;
    private int mHeight;
    private int mRadius;

    private int mDegress;

    private Paint mPaintWhite;
    private Paint mPaintBlack;
    private RectF mBigArc;

    public TaiChi(Context context) {
        super(context);
        initPaint();
    }

    public TaiChi(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public TaiChi(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint(){
        mPaintWhite = new Paint();
        mPaintWhite.setColor(Color.WHITE);
        mPaintWhite.setAntiAlias(true);

        mPaintBlack = new Paint();
        mPaintBlack.setColor(Color.BLACK);
        mPaintBlack.setAntiAlias(true);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mWidth = getWidth();
        mHeight = getHeight();
        mRadius = (Math.min(mWidth,mHeight)-100)/2;
        mBigArc = new RectF(-mRadius,-mRadius,mRadius,mRadius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth/2,mHeight/2);
        canvas.rotate(mDegress);

        canvas.drawColor(Color.LTGRAY);

        //绘制大半圆
        canvas.drawArc(mBigArc,90,180,true,mPaintBlack);
        canvas.drawArc(mBigArc,-90,180,true,mPaintWhite);

        //绘制小圆
        int smallRadius = mRadius/2;
        canvas.drawCircle(0,-smallRadius,smallRadius,mPaintBlack);
        canvas.drawCircle(0,smallRadius,smallRadius,mPaintWhite);

        //绘制鱼眼
        int eyeRadius = smallRadius/4;
        canvas.drawCircle(0,-smallRadius,eyeRadius,mPaintWhite);
        canvas.drawCircle(0,smallRadius,eyeRadius,mPaintBlack);
        mDegress+=5;
        invalidate();

    }
}
