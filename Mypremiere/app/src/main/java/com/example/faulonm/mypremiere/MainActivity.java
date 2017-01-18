package com.example.faulonm.mypremiere;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button valider = (Button) findViewById(R.id.button);
        valider.setOnClickListener(new View.OnClickListener() {         //Creation du listener OnClick
            public void onClick(View v) {       //Creation de OnClick
                // Perform action on click
                Log.d("Main activity", "valider");
                String nom = ((EditText)findViewById(R.id.editText)).getText().toString();
                String prenom = ((EditText)findViewById(R.id.editText2)).getText().toString();

               // Context context = getApplicationContext();  //Déclaration des variables pour les toasts
                int duration = Toast.LENGTH_SHORT;          //


                if(!nom.isEmpty() && !prenom.isEmpty()){    //Condition pour l'apparition de la fenetre ou des toasts
                    Log.d("Main activity", nom);
                    Intent second = new Intent(MainActivity.this,secondActivity.class);
                    second.putExtra("nom",nom);
                    second.putExtra("prenom",prenom);
                    startActivity(second);
                }
                else if(nom.isEmpty()){    // le nom n'est pas renseigné
                    Toast toast = Toast.makeText(MainActivity.this, "Saisir votre nom", duration);
                    toast.show();
                    ((TextView)findViewById(R.id.affichageErreur)).setText("nom n'est pas renseigné");
                }
                else if(prenom.isEmpty()){  //le prenom n'est pas renseigné
                    Toast toast = Toast.makeText(MainActivity.this, "Saisir votre prenom", duration);
                    toast.show();
                    ((TextView)findViewById(R.id.affichageErreur)).setText("prenom n'est pas renseigné");
                }

            }
        });


        Log.d("Main activity", "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main activity", "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Main activity", "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main activity", "onResum()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main activity", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Main activity", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main activity", "onDestroy()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
