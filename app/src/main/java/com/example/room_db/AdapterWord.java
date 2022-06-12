package com.example.room_db;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterWord extends RecyclerView.Adapter<AdapterWord.itemName> {
    List<Model> modelArrayList;
    Context mContext;
/*
    public AdapterWord(List<Model> modelArrayList, Context mContext) {
        this.modelArrayList = modelArrayList;
        this.mContext = mContext;
    }*/

    @NonNull
    @Override
    public itemName onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        itemName itemName = new itemName(view);
        return itemName;
    }

    @Override
    public void onBindViewHolder(@NonNull itemName holder, int position) {
        Model  model= modelArrayList.get(position);
        holder.name.setText(model.getWordName());
    }

    public void setWord(List<Model> models)
    {
        modelArrayList=models ;
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    class itemName extends RecyclerView.ViewHolder {

        TextView name;

        public itemName(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
        }
    }
}
