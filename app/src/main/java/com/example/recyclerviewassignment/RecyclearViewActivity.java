package com.example.recyclerviewassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerviewassignment.Model.userclass;

import java.util.ArrayList;
import java.util.List;

public class RecyclearViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
//    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclear_view);


        recyclerView=findViewById(R.id.rvusers);

//       users.add(new User("momo","male","19-8-2016","nepal","5656","sd@g.c","yjy"));

        Intent intent = getIntent();

        final List<userclass> users = (List<userclass>)intent.getSerializableExtra("userlist");


        MyRvAdapter adapter = new MyRvAdapter(users,this);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
