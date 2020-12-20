package com.project.fitness;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class insert_session extends AppCompatActivity {

    TextInputEditText txtname,txttname,txtstart,txtend,txtfrom,txtto;

    DatePickerDialog.OnDateSetListener setListener;
    DatePickerDialog.OnDateSetListener setListener2;


    int hour1,hour2,min1,min2;

    Button buttoninsert,buttonclear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_session);


        txtname =findViewById(R.id.idname);
        txttname  = findViewById(R.id.idtname);
        txtfrom = findViewById(R.id.idfrom);
        txtto = findViewById(R.id.idto);
        txtstart = findViewById(R.id.idstart);
        txtend = findViewById(R.id.idend);

        buttoninsert = findViewById(R.id.buttoninsert);
        buttonclear = findViewById(R.id.buttonclear);







        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);





        txtstart.setFocusable(false);
        txtstart.setKeyListener(null);

        txtend.setFocusable(false);
        txtend.setKeyListener(null);

        txtfrom.setFocusable(false);
        txtfrom.setKeyListener(null);

        txtto.setFocusable(false);
        txtto.setKeyListener(null);


        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtname.setText("");
                txttname.setText("");
                txtstart.setText("");
                txtend.setText("");
                txtfrom.setText("");
                txtto.setText("");
            }
        });

        txtstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(
                        insert_session.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month+1;
                String date = year+"-"+month+"-"+dayOfMonth;
                txtstart.setText(date);
            }
        };


        txtend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(
                        insert_session.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener2,year,month,day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = 1 + month;
                String date = year+"-"+month+"-"+dayOfMonth;
                txtend.setText(date);
            }
        };





        txtfrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        insert_session.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                hour1 = hourOfDay;
                                min1 = minute;

                                String time = hour1 + ":" + min1 ;

                                SimpleDateFormat f24Hours = new SimpleDateFormat("HH:mm");

                                try {
                                    Date date = f24Hours.parse(time);

                                    SimpleDateFormat f12hours = new SimpleDateFormat("HH:mm");

                                    txtfrom.setText(f12hours.format(date));

                                } catch (ParseException e){

                                    e.printStackTrace();
                                }
                            }
                        },12, 0,false




                );


                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                timePickerDialog.updateTime(hour1,min1);

                timePickerDialog.show();


            }
        });

        txtto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        insert_session.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                hour2 = hourOfDay;
                                min2 = minute;

                                String time = hour2 + ":" + min2 ;

                                SimpleDateFormat f24Hours = new SimpleDateFormat("HH:mm");

                                try {
                                    Date date = f24Hours.parse(time);

                                    SimpleDateFormat f12hours = new SimpleDateFormat("HH:mm");

                                    txtto.setText(f12hours.format(date));

                                } catch (ParseException e){

                                    e.printStackTrace();
                                }
                            }
                        },12, 0,false




                );


                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                timePickerDialog.updateTime(hour2,min2);

                timePickerDialog.show();


            }
        });

        buttoninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String aname = String.valueOf(txtname.getText());
                final String atname = String.valueOf(txttname.getText());
                final String afrom = String.valueOf(txtfrom.getText());
                final String atoo = String.valueOf(txtto.getText());
                final String astart = String.valueOf(txtstart.getText());
                final String aend = String.valueOf(txtend.getText());




                if(!aname.equals("") && !atname.equals("")  && !astart.equals("") && !aend.equals("") && !afrom.equals("") && !atoo.equals(""))
                {

                    if(DatesValidator(astart,aend))
                    {

                        if(Timevalidator(afrom,atoo))
                        {
                            StringRequest request = new StringRequest(Request.Method.POST, "http://172.20.10.7/fitness/insertsession.php", new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {


                                    if(response.equalsIgnoreCase("the session inserted"))
                                    {
                                        Toast.makeText(getApplicationContext(),"Session inserted",Toast.LENGTH_SHORT).show();

                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();

                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                    Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();

                                }
                            }

                            ){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {

                                    Map<String,String> params = new HashMap<String, String>();

                                    params.put("param1",aname);
                                    params.put("param2",atname);
                                    params.put("param3",astart);
                                    params.put("param4",aend);
                                    params.put("param5",afrom);
                                    params.put("param6",atoo);


                                    //return super.getParams();
                                    return params;
                                }
                            };


                            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                            requestQueue.add(request);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"End time must be after start time",Toast.LENGTH_SHORT).show();
                        }



                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"End date must be after or equal start date",Toast.LENGTH_SHORT).show();

                    }



                }
                else{

                    Toast.makeText(getApplicationContext(),"please fill out all fields",Toast.LENGTH_SHORT).show();

                }

            }

            private boolean DatesValidator(String startDate, String endDate) {

                SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");

                boolean b = false;

                try {
                    if (dfDate.parse(startDate).before(dfDate.parse(endDate))) {
                        b = true;
                    } else if (dfDate.parse(startDate).equals(dfDate.parse(endDate))) {
                        b = true;
                    } else {
                        b = false;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return b;
            }

            private boolean Timevalidator(String time1, String time2) {

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                boolean b = false;
                try {
                    java.util.Date StartTime = sdf.parse(time1);
                    java.util.Date EndTime = sdf.parse(time2);


                    b = EndTime.after(StartTime);
                } catch (ParseException e) {

                    e.printStackTrace();
                }

                return b;
            }
        });



    }



}