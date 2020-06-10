package com.example.recyclerview_sortingapp_java;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List studentDataList =new ArrayList<>();
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        studentAdapter=new StudentAdapter(studentDataList);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(studentAdapter);
        StudentDataPrepare();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void StudentDataPrepare() {
        studentData data=new studentData("sai",25);
        studentDataList.add(data);
        data=new studentData("sai",25);
        studentDataList.add(data);
        data=new studentData("raghu",20);
        studentDataList.add(data);
        data=new studentData("raj",28);
        studentDataList.add(data);
        data=new studentData("amar",15);
        studentDataList.add(data);
        data=new studentData("bapu",19);
        studentDataList.add(data);
        data=new studentData("chandra",52);
        studentDataList.add(data);
        data=new studentData("deraj",30);
        studentDataList.add(data);
        data=new studentData("eshanth",28);
        studentDataList.add(data);
        Collections.sort(studentDataList, new Comparator<studentData>() {
            @Override
            public int compare(studentData o1, studentData o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }
}