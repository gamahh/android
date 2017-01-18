package com.example.faulonm.mypremiere;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by faulonm on 04/01/17.
 */
public class ModelAdapteur extends BaseAdapter {
    Context context;
    List<ModelLigne> list;

    public ModelAdapteur(List<ModelLigne> p_list) {
        this.list = p_list;
    }


    @Override
    public int getCount() {
      return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist,parent, false);


            viewHolder = new ViewHolder();

            viewHolder.textPrenom = (TextView) convertView.findViewById(R.id.textView4);
            viewHolder.textNom = (TextView) convertView.findViewById(R.id.textView5);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        ModelLigne ligne = (ModelLigne) getItem(position);
        viewHolder.textPrenom.setText(ligne.getTextPrenom());
        viewHolder.textNom.setText(ligne.getTextNom());
        InputStream streamImage = null;
        try {
            streamImage = convertView.getContext().getAssets().open(ligne.getImagePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(streamImage, null,options);
        options.inSampleSize = calculateInSampleSize(options,80,80);
        options.inJustDecodeBounds = false;
       /* int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;*/


        Bitmap bmp = BitmapFactory.decodeStream(streamImage, null, options);
        viewHolder.image.setImageBitmap(bmp);

        return convertView;
    }


    private class ViewHolder{
        public TextView textPrenom;
        public TextView textNom;
        public ImageView image;
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



