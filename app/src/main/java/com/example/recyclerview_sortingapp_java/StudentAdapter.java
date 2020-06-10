package com.example.recyclerview_sortingapp_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    List studentDataList;
    public StudentAdapter(List studentDataList) {
        this.studentDataList=studentDataList;
    }

    @NonNull
    @Override
    //It is used to create a view holder and it returns a view.
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_list_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    // It going to bind with created view holder.
    public void onBindViewHolder(MyViewHolder holder, int i) {
        studentData data= (studentData) studentDataList.get(i);
        holder.name.setText(data.name);
        holder.age.setText(String.valueOf(data.age));
    }
    @Override
    //It contains size of list.
    public int getItemCount() {
        return studentDataList.size();
    }
    //It is view holder inner class which is extended by RecyclerView.ViewHolder
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,age;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            age=itemView.findViewById(R.id.age);
        }
    }
}