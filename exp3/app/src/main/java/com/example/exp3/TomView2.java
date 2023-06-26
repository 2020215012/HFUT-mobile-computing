package com.example.exp3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class TomView2 extends View {
    public float bitmapX;
    public float bitmapY;

    public TomView2(Context context) {
        super(context);
        bitmapX = 200;   //小兔子的默认的X坐标
        bitmapY = 200;    }
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        Paint paint = new Paint();    //创建并实例化paint的对象
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.img);   //根据图片生成位图图像
        canvas.drawBitmap(bitmap,bitmapX, bitmapY, paint);  //画小兔子
        if (bitmap.isRecycled()) {  //判断图片是否回收
            bitmap.recycle();
        }
    }
}

