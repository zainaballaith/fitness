package com.project.fitness;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private  List<Sessionlist> objects = new ArrayList<>();

    public MyAdapter(Context context,List<Sessionlist> objects)
    {
        this.objects = objects;
        this.mContext = context;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tsn, ttu, tsd, ted,tst,tet;
        private ImageView mImageView;
        private LinearLayout mContainer;

        public  MyViewHolder(View view)
        {

            super(view);

            tsn = view.findViewById(R.id.session_name);
            ttu= view.findViewById(R.id.tuser);
            mImageView = view.findViewById(R.id.session_image);
            mContainer = view.findViewById(R.id.product_container);

        }





    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_rec_session,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Sessionlist object = objects.get(position);


        holder.tsn.setText(object.getSname());
        holder.ttu.setText("Trainer :"+object.getTrainer_user());
        Glide.with(mContext).load(object.getPic()).into(holder.mImageView);

        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,detail_session.class);

                intent.putExtra("sname",object.getSname());
                intent.putExtra("trainer_user",object.getTrainer_user());
                intent.putExtra("start_date",object.getStart_date());
                intent.putExtra("end_date",object.getEnd_date());
                intent.putExtra("start_time",object.getStart_time());
                intent.putExtra("end_time",object.getEnd_time());
                intent.putExtra("pic",object.getPic());

                mContext.startActivity(intent);
            }
        });

    }


}
