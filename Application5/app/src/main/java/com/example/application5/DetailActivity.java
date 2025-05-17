package com.example.application5;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private ListView itemsListView;
    private EditText newItemEditText;
    private Button addButton, deleteButton;
    private ArrayList<String> items = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        category = getIntent().getStringExtra("category");
        TextView categoryTitle = findViewById(R.id.categoryName);
        categoryTitle.setText(category);
        itemsListView = findViewById(R.id.itemsListView);
        newItemEditText = findViewById(R.id.newItemEditText);
        addButton = findViewById(R.id.addButton);
        deleteButton = findViewById(R.id.deleteButton);
        switch (category) {
            case "Базированные игры":
                items.add("Русы против Ящеров");
                items.add("Змейка");
                items.add("Titan Quest");
                break;
            case "Ну чёта херня какая-то":
                items.add("Forspoken");
                items.add("Assassin's Creed Shadows");
                items.add("Bug Dools");
                break;
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        itemsListView.setAdapter(adapter);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = newItemEditText.getText().toString();
                if (!newItem.isEmpty()) {
                    items.add(newItem);
                    adapter.notifyDataSetChanged();
                    newItemEditText.setText("");
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sPosition = itemsListView.getCheckedItemPosition();
                if (sPosition != ListView.INVALID_POSITION) {
                    items.remove(sPosition);
                    adapter.notifyDataSetChanged();
                    itemsListView.clearChoices();
                }
            }
        });
    }
}