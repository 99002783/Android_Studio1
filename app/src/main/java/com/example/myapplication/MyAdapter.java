package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.wordViewHolder> {

String[] languages;
LayoutInflater layoutinflater;
    public MyAdapter(Context context, String[] languagesData) {
        languages=languagesData;
        layoutinflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyAdapter.wordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = layoutinflater.inflate(R.layout.row_listview,parent,false);
        return new wordViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.wordViewHolder holder, int position) {
        holder.titleTextView.setText(languages[position]);

    }

    @Override
    public int getItemCount() {
        return languages.length;
    }

    public class wordViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public wordViewHolder(@NonNull View itemView) {
            super(itemView);
             titleTextView = itemView.findViewById(R.id.textviewRow);
        }
    }
}
