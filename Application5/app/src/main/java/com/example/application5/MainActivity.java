package com.example.application5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ListView categoriesListView;
    private String[] categories = {"Базированные игры", "Ну чёта херня какая-то"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.toRecycler);
        Button button2 = findViewById(R.id.toScroll);
        Button button3 = findViewById(R.id.toSpinner);
        categoriesListView = findViewById(R.id.categoriesListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                categories);
        categoriesListView.setAdapter(adapter);
        categoriesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("category", categories[position]);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, RecyclerActivity.class);
            startActivity(intent1);
        });
        button2.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, ActivityScroll.class);
            startActivity(intent2);
        });
        button3.setOnClickListener(v -> {
            Intent intent3 = new Intent(this, SpinnerActivity.class);
            startActivity(intent3);
        });
    }
}