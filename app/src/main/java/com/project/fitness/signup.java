package com.project.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {

    TextInputEditText textInputEditTextusername, textInputEditTextfullname, textInputEditTextemail,
            textInputEditTextage, textInputEditTextweight, textInputEditTextheight, textInputEditTextpass, textInputEditTextcpass;

    Button buttonsignup;
    TextView textViewlogin;

    ProgressBar progressBar;

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        textInputEditTextusername = findViewById(R.id.username_ti);
        textInputEditTextfullname =findViewById(R.id.name_ti);
        textInputEditTextemail = findViewById(R.id.email_ti);
        textInputEditTextage = findViewById(R.id.age_ti);
        textInputEditTextweight =findViewById(R.id.weight_ti);
        textInputEditTextheight = findViewById(R.id.height_ti);
        textInputEditTextpass = findViewById(R.id.pass_ti);
        textInputEditTextcpass = findViewById(R.id.cpass_ti);

        progressBar = findViewById(R.id.progress);

        buttonsignup =  findViewById(R.id.signup_go);
        textViewlogin =  findViewById(R.id.login_tv);

        textViewlogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
            }
        });

        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String username = String.valueOf(textInputEditTextusername.getText());
                final String fullname = String.valueOf(textInputEditTextfullname.getText());
                final String email = String.valueOf(textInputEditTextemail.getText());
                final String password = String.valueOf(textInputEditTextpass.getText());
                final String cpassword = String.valueOf(textInputEditTextcpass.getText());
                final String age = String.valueOf(textInputEditTextage.getText());
                final String weight = String.valueOf(textInputEditTextweight.getText());
                final String height = String.valueOf(textInputEditTextheight.getText());



                if(!username.equals("") && !fullname.equals("") && !email.equals("") && !password.equals("")
                        && !cpassword.equals("") && !age.equals("") && !weight.equals("") && !height.equals("")) {


                    progressBar.setVisibility(View.VISIBLE);

                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            String[] field = new String[8];
                            field[0] = "username";
                            field[1] = "fullname";
                            field[2] = "email";
                            field[3] = "password";
                            field[4] = "cpassword";
                            field[5] = "age";
                            field[6] = "weight";
                            field[7] = "height";


                            String[] data = new String[8];
                            data[0] = username ;
                            data[1] = fullname;
                            data[2] = email;
                            data[3] = password;
                            data[4] = cpassword;
                            data[5] = age;
                            data[6] = weight;
                            data[7] = height;

                            PutData putData = new PutData("http://172.20.10.7/fitness/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {

                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();

                                    if(result.equals("Sign Up Success")){

                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                         intent = new Intent(getApplicationContext(),login.class);
                                       startActivity(intent);
                                       finish();

                                    }else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                    }


                                }
                            }

                        }
                    });

                }else{

                    Toast.makeText(getApplicationContext(),"please fill out all fields",Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}


