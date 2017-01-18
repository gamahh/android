package com.example.faulonm.mypremiere;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by faulonm on 18/01/17.
 */
public class PhotoView extends View {
    Bitmap imageBitmap;
    int facteurScaleX,facteurscaleY;


    public PhotoView(Context context) {
        super(context);
    }

    public PhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhotoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int height = getMeasuredHeight();
        int widht = getMeasuredWidth();

        int px = widht/2;
        int py = height/2;


        Paint monPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Rect rec = new Rect(20,300,400,500);
        canvas.drawBitmap(imageBitmap,rec, rec, monPaint);
        //canvas.drawBitmap(imageBitmap, px-200*x1, py-200*y1, monPaint);

        //monPaint.setColor(255);
        super.onDraw(canvas);
    }

    public void setImageBitmap(Bitmap bitmap){
        imageBitmap = bitmap;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setFacteurScaleX(int facteurScaleX) {
        this.facteurScaleX = facteurScaleX;
    }

    /*public void initGestures(){
        GestureControleur gestureControleur = new GestureControleur(this);

        gestureDetector = new GestureDetector(getContext(),  gestureControleur);
        gestureDetector.setOnDoubleTapListener(gestureControleur);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean isBasicGesturesHandled = gestureDetector.onTouchEvent(event);

        return isBasicGesturesHandled;
    }*/
}
