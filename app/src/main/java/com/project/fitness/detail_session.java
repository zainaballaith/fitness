package com.project.fitness;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

public class detail_session extends AppCompatActivity {


    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private ImageView mImage;
    private TextView sesname,tuser,sdate,edate,stime,etime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_session);

        mToolbar = findViewById(R.id.toolbar);
        mImage = findViewById(R.id.image_view);
        sesname = findViewById(R.id.sesname);
        tuser = findViewById(R.id.trainerusername);
        sdate = findViewById(R.id.start_date);
        edate = findViewById(R.id.end_date);
        stime = findViewById(R.id.start_time);
        etime = findViewById(R.id.end_time);



        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);




        Intent intent = getIntent();

        String sname = intent.getStringExtra("sname");
        String tusername = intent.getStringExtra("trainer_user");
        String startdate = intent.getStringExtra("start_date");
        String enddtae = intent.getStringExtra("end_date");
        String starttime =intent.getStringExtra("start_time");
        String endtime = intent.getStringExtra("end_time");
        String image = intent.getStringExtra("pic");

        if (intent !=null){

            mActionBar.setTitle(sname);
            sesname.setText(sname);
            tuser.setText(tusername);
            sdate.setText(startdate);
            edate.setText(enddtae);
            stime.setText(starttime);
            etime.setText(endtime);

            Glide.with(detail_session.this).load(image).into(mImage);

        }

    }


}