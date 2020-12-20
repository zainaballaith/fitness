package com.project.fitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class AdminMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    SessionManager sessionManager ;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Intent intent;

    CardView cardViewexercises, cardViewtrainers, cardViewsessions, cardViewtrainees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);


        cardViewexercises = findViewById(R.id.exercises);
        cardViewtrainers = findViewById(R.id.trainers);
        cardViewsessions = findViewById(R.id.sessions);
        cardViewtrainees = findViewById(R.id.trainees);

        sessionManager = new SessionManager(getApplicationContext());
        String username = sessionManager.getUsername();


        cardViewexercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(AdminMainActivity.this,adminexersices.class);
                startActivity(intent);
            }
        });

        cardViewtrainers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(AdminMainActivity.this,admintrainer.class);
                startActivity(intent);
            }
        });

        cardViewsessions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(AdminMainActivity.this,adminsession.class);
                startActivity(intent);
            }
        });

        cardViewtrainees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(AdminMainActivity.this,admintrainees.class);
                startActivity(intent);
            }
        });



        /* ---------------------------  ----------------------------------------------------  ---------------------------------- */
        setSupportActionBar(toolbar);


        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_water).setVisible(false);



        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

    }



    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{

            super.onBackPressed();
        }

    }


    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.nav_home:
                break;

            case R.id.nav_profile:
                intent = new Intent(AdminMainActivity.this,profile.class);
                startActivity(intent);
                break;
            case R.id.nav_chat:
                intent = new Intent(AdminMainActivity.this,chat.class);
                startActivity(intent);
                break;

            case R.id.nav_logout:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Log out");

                builder.setMessage("Are you sure to logout ?");

                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sessionManager.setLogin(false);
                        sessionManager.setUsername("");

                        Intent intent = new Intent(getApplicationContext(),login.class);
                        startActivity(intent);
                        finish();
                    }
                });

                builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}