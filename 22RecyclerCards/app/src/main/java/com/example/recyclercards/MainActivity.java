package com.example.recyclercards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ExampleItem> exampleList;
    private Button buttonAdd, buttonDelete;
    private EditText editTextAdd, editTextDelete;



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    //adapter is a linking bridge between your data and your recyclerView.
    //recyclerView cannot talk directly to data so, adapter is like middle-man
    //which gets all the data and throws into the recyclerView

    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateFakeData();
        recyclerViewConfig();

        //find Buttons
        buttonAdd = findViewById(R.id.buttonadd);
        buttonDelete = findViewById(R.id.buttondelete);
        //find EditText
        editTextAdd = findViewById(R.id.edittextadd);
        editTextDelete = findViewById(R.id.edittextdelete);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextAdd.getText().toString());
                addCard(position);

            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextDelete.getText().toString());
                removeCard(position);
            }
        });

    }

    public void generateFakeData() {
        exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.node,"Clicked at studio"));
        exampleList.add(new ExampleItem(R.drawable.oner,"Clicked at Italy"));
        exampleList.add(new ExampleItem(R.drawable.twor,"Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.threer,"Clicked at Greece"));
        exampleList.add(new ExampleItem(R.drawable.fourr,"Clicked at studio"));
        exampleList.add(new ExampleItem(R.drawable.fiver,"Clicked at studio"));
        exampleList.add(new ExampleItem(R.drawable.sixr,"Clicked at studio"));

    }

    public void recyclerViewConfig() {
        //Config for RecyclerView.
        recyclerView = findViewById(R.id.recyclerView);

        // TODO: performance
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void addCard(int position) {
        exampleList.add(position, new ExampleItem(R.drawable.node, "New Card Added"));
        editTextAdd.setText(null);
//        adapter.notifyDataSetChanged();
          adapter.notifyItemInserted(position);
    }

    public void removeCard(int position) {
        exampleList.remove(position);
        editTextDelete.setText(null);
        adapter.notifyItemRemoved(position);

    }

}

