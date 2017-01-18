package com.example.faulonm.mypremiere;

import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by faulonm on 18/01/17.
 */
public class GestureControleur extends GestureDetector.SimpleOnGestureListener {
    private PhotoView photoView;

    public GestureControleur(PhotoView photoView) {
        this.photoView = photoView;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        /*Bitmap original = photoView.getImageBitmap();
        Bitmap myBitmap = Bitmap.createScaledBitmap(original, 200, 200, true); // Nouveau Bitmap de taille différente
        photoView.setImageBitmap(myBitmap);*/
        photoView.setFacteurScaleX(20);


        return true;
    }


}
