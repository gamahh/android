package com.example.faulonm.mypremiere;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by faulonm on 14/12/16.
 */
public class secondActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        final String nom = intent.getStringExtra("nom");
        final String prenom = intent.getStringExtra("prenom");
        ((TextView) findViewById(R.id.infoNom)).setText(nom);
        ((TextView) findViewById(R.id.infoPrenom)).setText(prenom);


        final Button buttonList = (Button) findViewById(R.id.button2);
        buttonList.setOnClickListener(new View.OnClickListener() {         //Creation du listener OnClick
            public void onClick(View v) {
                Intent troisieme = new Intent(secondActivity.this,troisiemeActivity.class);
                troisieme.putExtra("nom",nom);
                troisieme.putExtra("prenom",prenom);
                startActivity(troisieme);
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
