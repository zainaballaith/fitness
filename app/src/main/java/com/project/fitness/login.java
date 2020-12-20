package com.project.fitness;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;



public class login extends AppCompatActivity {


    Intent intent;

    TextInputEditText textInputEditTextusername,textInputEditTextpassword;

    Button buttonlogin;
    TextView textViewsignup;

    ProgressBar progressBar;

    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        textInputEditTextusername = findViewById(R.id.username_ti);
        textInputEditTextpassword = findViewById(R.id.password_ti);



        buttonlogin = findViewById(R.id.login_go);
        textViewsignup = findViewById(R.id.signup_tv);

        progressBar = findViewById(R.id.progress);




        sessionManager = new SessionManager(getApplicationContext());


        textViewsignup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(login.this,signup.class));
                finish();
            }
        });

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String usernametxt = String.valueOf(textInputEditTextusername.getText());
                final String passwordtxt = String.valueOf(textInputEditTextpassword.getText());

                if(!usernametxt.equals("") && !passwordtxt.equals("") ) {


                    progressBar.setVisibility(View.VISIBLE);

                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";



                            String[] data = new String[2];
                            data[0] = usernametxt ;
                            data[1] = passwordtxt;


                            PutData putData = new PutData("http://172.20.10.7/fitness/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {

                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();

                                    //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    if(result.equals("admin login Success")){

                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                        sessionManager.setLogin(true);
                                        sessionManager.setUsername(usernametxt);

                                       intent = new Intent(login.this,AdminMainActivity.class);
                                       startActivity(intent);
                                        finish();

                                    }
                                    else if (result.equals("trainer login success"))
                                    {

                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                        sessionManager.setLogin(true);
                                        sessionManager.setUsername(usernametxt);

                                        intent = new Intent(login.this,TrainerMainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else if (result.equals("trainee login success"))
                                    {

                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                        sessionManager.setLogin(true);
                                        sessionManager.setUsername(usernametxt);

                                        intent = new Intent(login.this,MainActivity.class);
                                        startActivity(intent);
                                        finish();

                                    }


                                }
                            }

                        }
                    });

                }else{

                    Toast.makeText(getApplicationContext(),"please write username and password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
