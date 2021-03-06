package com.example.teeshirt.drinksapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;




public class
        MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ageConfirm();
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);


        Button cb = (Button)findViewById(R.id.cb);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Latest.class);
                startActivity(intent);
            }
        });

        Typeface font = Typeface.createFromAsset(getAssets(), "raleway.ttf");
        textView.setTypeface(font);
        cb.setTypeface(font);
    }


    public void ageConfirm(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you at least 18 years old?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You must be 18 and over to use this app", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Age Confirmation");
        alert.show();
    }

}
