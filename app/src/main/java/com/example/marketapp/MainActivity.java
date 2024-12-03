package com.example.marketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketapp.adapter.MyAdapter;
import com.example.marketapp.listener.ItemClickListener;
import com.example.marketapp.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    // 1 - AdapterView
    RecyclerView recyclerView;
    // 2 - Data Source
    List<Item> itemList;
    // 3 - Adapter
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            recyclerView = findViewById(R.id.recyclerView);

            itemList = new ArrayList<>();
            Item item1 = new Item(R.drawable.fruit, "Fruits", "Fresh Fruits from the Garden");
            itemList.add(item1);
            itemList.add(new Item(R.drawable.vegitables, "Vegetables", "Delicious Vegetables"));
            itemList.add(new Item(R.drawable.bread, "Bakery", "Bread, Wheat and Beans"));
            itemList.add(new Item(R.drawable.beverage, "Beverage", "Juice, Tea, Coffee and Soda"));
            itemList.add(new Item(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt"));
            itemList.add(new Item(R.drawable.popcorn, "Snacks", "Pop Corn, Donut and Drinks"));

            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);

            myAdapter = new MyAdapter(itemList);
            recyclerView.setAdapter(myAdapter);

            myAdapter.setClickListener(this);
            return insets;
        });
    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You Choose: "
                + itemList.get(pos).getItemName(), Toast.LENGTH_SHORT).show();
    }
}