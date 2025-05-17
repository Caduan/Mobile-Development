package com.example.application5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        itemList.add(new Item("-1.0", "Лучший фильм 2023 года?", R.drawable.godzilla));
        itemList.add(new Item("MonsterVerse", "В Голливуде не шарят.", R.drawable.godzilla));
        itemList.add(new Item("Спинные пластины", "Вестник гибели.", R.drawable.godzilla));
        itemList.add(new Item("Netflix", "Неплохая трилогия.", R.drawable.godzilla));
        itemList.add(new Item("-2.0", "Когда-нибудь да выйдет.", R.drawable.godzilla));

        adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
}