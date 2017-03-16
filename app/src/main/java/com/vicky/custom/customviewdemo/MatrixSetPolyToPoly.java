package com.vicky.custom.customviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

/**
 * create by yao.cui at 2016/11/10
 */
public class MatrixSetPolyToPoly extends View {
    private Bitmap mBitmap;
    private Matrix mPolyMatrix;

    public MatrixSetPolyToPoly(Context context) {
        super(context);
        initBitmapAndMatrix();
    }

    public MatrixSetPolyToPoly(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBitmapAndMatrix();
    }

    public MatrixSetPolyToPoly(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initBitmapAndMatrix();
    }

    private void initBitmapAndMatrix(){
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.jing);
        mPolyMatrix = new Matrix();
        float[] src = {0, 0,                                    // 左上
                mBitmap.getWidth(), 0,                          // 右上
                mBitmap.getWidth(), mBitmap.getHeight(),        // 右下
                0, mBitmap.getHeight()};                        // 左下

        float[] dst = {0, 0,                                    // 左上
                mBitmap.getWidth(), 200,                        // 右上
                mBitmap.getWidth(), mBitmap.getHeight() - 200,  // 右下
                0, mBitmap.getHeight()};                        // 左下

        // 核心要点
        mPolyMatrix.setPolyToPoly(src, 0, dst, 0, src.length >> 1); // src.length >> 1 为位移运算 相当于处以2


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap,mPolyMatrix,null);
    }
}
