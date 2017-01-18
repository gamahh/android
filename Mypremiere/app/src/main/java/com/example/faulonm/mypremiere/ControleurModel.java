package com.example.faulonm.mypremiere;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faulonm on 11/01/17.
 */
public class ControleurModel {
    Context context;

    public ControleurModel(Context p_context) {
        context = p_context;
    }

    public List<ModelLigne> recupererListeLigne(String prenom, String nom) throws IOException {
        List<ModelLigne> list = new ArrayList<ModelLigne>();

        int taille;
        taille = context.getAssets().list("image").length;
        String path[] = context.getAssets().list("image");

        for(int i =0; i< taille; i++){
            list.add(i,new ModelLigne(prenom,"image/" + path[i], nom));
        }

        return  list;
    }
}
