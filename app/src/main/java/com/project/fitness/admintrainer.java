package com.project.fitness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class admintrainer extends AppCompatActivity {

    Intent intent;

CardView c1,c2,c3,c4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admintrainer);


        c1 = findViewById(R.id.trainerone);
        c2 = findViewById(R.id.trainertwo);
        c3 = findViewById(R.id.trainerthree);
        c4 = findViewById(R.id.trainerfour);



        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(admintrainer.this,trainerone.class);
                startActivity(intent);

            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(admintrainer.this,trainertwo.class);
                startActivity(intent);

            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(admintrainer.this,trainerthree.class);
                startActivity(intent);

            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(admintrainer.this,trainerfour.class);
                startActivity(intent);

            }
        });
    }


    }
