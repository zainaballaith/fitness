package com.project.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class trainerslist extends AppCompatActivity {

    Intent intent;

    CardView c1,c2,c3,c4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainerslist);



        c1 = findViewById(R.id.trainerone);
        c2 = findViewById(R.id.trainertwo);
        c3 = findViewById(R.id.trainerthree);
        c4 = findViewById(R.id.trainerfour);



        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(trainerslist.this,trone.class);
                startActivity(intent);

            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(trainerslist.this,trtwo.class);
                startActivity(intent);

            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(trainerslist.this,trthree.class);
                startActivity(intent);

            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(trainerslist.this,trfour.class);
                startActivity(intent);

            }
        });
    }
}