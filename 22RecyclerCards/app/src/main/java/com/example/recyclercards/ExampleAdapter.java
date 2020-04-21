package com.example.recyclercards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;

    //1 Create a Class
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        //4 Grabs the images, etc using Id's

        public ImageView imageView;
        public TextView textView;

        //2 Generate Constructor
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            //4.1 find the id's
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    //6 it does know how many cards we are generating that's why
    // we are creating this constructor. in order to find it out
    // how many items we generate and what properties to set inside them
    // this is why we are creating this constructor.

    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {

        mExampleList = exampleList;

    }

    //3 Generate all these methods
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //5
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view);
        return exampleViewHolder;

    }
    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int position) {

        //7
        ExampleItem currentItem = mExampleList.get(position);
        exampleViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        exampleViewHolder.textView.setText(currentItem.getmText());



    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }



}
