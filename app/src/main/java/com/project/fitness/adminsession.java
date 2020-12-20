package com.project.fitness;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class adminsession extends AppCompatActivity {

    Button addbutton;

    private static final String BASE_URL ="http://172.20.10.7/fitness/sessionlist.php";
    private List<Sessionlist> sessionlists;
    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsession);


        recyclerView = findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        sessionlists = new ArrayList<>();

        getsessions();

        addbutton = findViewById(R.id.buttonadd);


        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),insert_session.class);
                startActivity(intent);


            }
        });
    }


    private void getsessions()
    {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{

                            JSONArray array = new JSONArray(response);

                            for(int i = 0; i<array.length(); i++)
                            {
                                JSONObject object = array.getJSONObject(i);

                                String sname = object.getString("sname");
                                String trainer_user = object.getString("trainer_user");
                                String start_date = object.getString("start_date");
                                String end_date = object.getString("end_date");
                                String start_time = object.getString("start_time");
                                String end_time = object.getString("end_time");
                                String pic = object.getString("pic");


                                Sessionlist session = new Sessionlist(sname ,trainer_user,start_date,end_date,start_time,end_time,pic);

                                sessionlists.add(session);




                            }
                        }
                        catch (Exception e)
                        {



                        }

                        mAdapter = new MyAdapter(adminsession.this,sessionlists);
                        recyclerView.setAdapter(mAdapter);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(adminsession.this).add(stringRequest);
    }
}