package com.example.faulonm.mypremiere;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

/**
 * Created by faulonm on 04/01/17.
 */
public class troisiemeActivity extends Activity {
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.troisieme_activity);

        Intent intent = getIntent();

        mListView = (ListView) findViewById(R.id.listView);

        Context applicationContext = this.getApplicationContext();
        ControleurModel ctr = new ControleurModel(applicationContext);
        ModelAdapteur adapter = null;
        try {
            adapter = new ModelAdapteur(ctr.recupererListeLigne(intent.getStringExtra("prenom"),intent.getStringExtra("nom")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mListView.setAdapter(adapter);

        final ModelAdapteur finalAdapter = adapter;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelLigne ligne = (ModelLigne) finalAdapter.getItem(position);

                Intent item = new Intent(troisiemeActivity.this,itemActivity.class);
                item.putExtra("nom",ligne.getTextNom());
                item.putExtra("prenom",ligne.getTextPrenom());
                item.putExtra("path",ligne.getImagePath());
                startActivity(item);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
