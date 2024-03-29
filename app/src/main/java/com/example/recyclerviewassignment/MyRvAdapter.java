package com.example.recyclerviewassignment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewassignment.DisplayActivity;
import com.example.recyclerviewassignment.Model.userclass;

import java.util.ArrayList;
import java.util.List;

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder> {

    List<userclass> userlist = new ArrayList<>();
    Context context;

    public MyRvAdapter(List<userclass> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userimage,parent,false);
        MyHolder myholder = new MyHolder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final  userclass user = userlist.get(position);



        String uri = "@drawable/" + user.getImage();
        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        Drawable image = ContextCompat.getDrawable(context, imageResource);

        holder.imageview.setImageDrawable(image);
        holder.tvusername.setText(user.getName());


        holder.tvusername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(context, DisplayActivity.class);
                intent1.putExtra("name",user.getName());
                intent1.putExtra("gender",user.getGender());
                intent1.putExtra("dob",user.getDob());
                intent1.putExtra("country",user.getCountry());
                intent1.putExtra("phone",user.getPhone());
                intent1.putExtra("email",user.getEmail());
                intent1.putExtra("image",user.getImage());

                context.startActivity(intent1);
                //   Toast.makeText(context,user.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return userlist.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageview;
        TextView tvusername;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.userimage);
            tvusername = itemView.findViewById(R.id.username);
        }
    }
}
