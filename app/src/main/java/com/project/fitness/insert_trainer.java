package com.project.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class insert_trainer extends AppCompatActivity {

    TextInputEditText txtuser,txtname,txtmail,txtdes,txtpass;

    Button buttonadd,buttonclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_trainer);



        txtuser = findViewById(R.id.idusername);
        txtname = findViewById(R.id.idtfullname);
        txtmail = findViewById(R.id.idemail);
        txtdes = findViewById(R.id.iddes);
        txtpass = findViewById(R.id.idpassword);


        buttonadd = findViewById(R.id.buttonadd);
        buttonclear = findViewById(R.id.buttonclear2);


        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtuser.setText("");
                txtname.setText("");
                txtmail.setText("");
                txtpass.setText("");
                txtdes.setText("");

            }
        });

    }
}