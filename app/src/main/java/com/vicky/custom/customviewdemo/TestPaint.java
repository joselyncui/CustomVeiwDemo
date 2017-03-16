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
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * create by yao.cui at 2016/11/8
 */
public class TestPaint extends View {
    public TestPaint(Context context) {
        super(context);
    }

    public TestPaint(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestPaint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        Bitmap output = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
//        Canvas newCanvas = new Canvas(output);
//
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        newCanvas.drawCircle(200,200,100,paint);
//
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        paint.setColor(Color.BLUE);
//        newCanvas.drawRect(200,200,500,500,paint);

        Bitmap output = getProgressBmp();

        canvas.drawBitmap(output,0,0,new Paint());
    }

    private Bitmap getCircleBmp(){
        Bitmap output = Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);

        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.jing),0,0,paint);

        return output;
    }

    private Bitmap getProgressBmp(){
        Bitmap output = Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        RectF rectF = new RectF(0,0,getWidth(),getHeight());
        canvas.drawRoundRect(rectF,getHeight()/2,getHeight()/2,paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        paint.setColor(Color.BLUE);
        canvas.drawRect(0,0,100,getHeight(),paint);

        return output;

    }
}
