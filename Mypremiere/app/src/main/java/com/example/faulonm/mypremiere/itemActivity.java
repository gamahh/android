package com.example.faulonm.mypremiere;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by faulonm on 18/01/17.
 */
public class itemActivity extends Activity{

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_activity);

        Intent intent = getIntent();
        Context applicationContext = this.getApplicationContext();
        ModelLigne ligne = new ModelLigne(intent.getStringExtra("nom"),intent.getStringExtra("path"),intent.getStringExtra("prenom"));


        PhotoView image = (PhotoView) this.findViewById(R.id.imageView2);

        InputStream streamImage = null;
        try {
            streamImage = applicationContext.getAssets().open(ligne.getImagePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(streamImage, null,options);
        options.inSampleSize = calculateInSampleSize(options,200,200);
        options.inJustDecodeBounds = false;

        Bitmap bmp = BitmapFactory.decodeStream(streamImage, null, options);
        //image.setImageBitmap(bmp);

        image.setImageBitmap(bmp);

        gestureDetector = new GestureDetector(getApplicationContext(), new GestureControleur(image));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
