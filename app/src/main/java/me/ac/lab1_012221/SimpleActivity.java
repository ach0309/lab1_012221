package me.ac.lab1_012221;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SimpleActivity extends AppCompatActivity {

    private final String C_TAG = "ON_CREATE";
    private final String R_TAG = "ON_RESUME";
    private final String S_TAG = "ON_START";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(C_TAG, "Non-existent to Stopped");

        setContentView(R.layout.activity_simple);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button t_button=findViewById(R.id.t_button); //grabbed by reference from content_simple.xml
        t_button.setOnClickListener(new View.OnClickListener() { //create onClickListener
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SimpleActivity.this, AltActivity.class); //intent- way to view another activity
                startActivity(intent); //start
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(S_TAG, "Stopped to Paused");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.i(R_TAG,"Paused to Resumed");
    }

}