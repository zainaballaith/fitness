package com.project.fitness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class beginners extends AppCompatActivity {

    Intent intent;
    ListView listView;
    String mTitle[] = {"Yoga","step up","squat","dumbbell"};
    String mDescription [] = {"arms, back, legs, and core","quadriceps, glutes, and calves","quadriceps, hamstring, and abdominal","biceps and arms"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginners);

        listView = findViewById(R.id.listView);

        eAdapter adapter= new eAdapter(this,mTitle,mDescription);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){

                    Toast.makeText(getApplicationContext(),"exercise one",Toast.LENGTH_SHORT).show();

                    intent = new Intent(beginners.this,exone.class);
                    startActivity(intent);

                }

                if (position == 1){

                    Toast.makeText(getApplicationContext(),"exercise two",Toast.LENGTH_SHORT).show();
                    intent = new Intent(beginners.this,extwo.class);
                    startActivity(intent);

                }

                if (position == 2){

                    Toast.makeText(getApplicationContext(),"exercise three",Toast.LENGTH_SHORT).show();
                    intent = new Intent(beginners.this,exthree.class);
                    startActivity(intent);

                }

                if (position == 3){

                    Toast.makeText(getApplicationContext(),"exercise four",Toast.LENGTH_SHORT).show();
                    intent = new Intent(beginners.this,exfour.class);
                    startActivity(intent);

                }
            }
        });

    }

    class eAdapter extends ArrayAdapter<String>{

        Context context;
        String rTitle[];
        String rDescription[];

        eAdapter(Context c , String title[], String description[]){
            super(c,R.layout.rows,R.id.text1,title);

            this.context = c;
            this.rTitle = title;
            this.rDescription = description;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rows = layoutInflater.inflate(R.layout.rows, parent,false);

            TextView mytitle = rows.findViewById(R.id.text1);
            TextView myDescription = rows.findViewById(R.id.text2);

            mytitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return rows;
        }
    }
}