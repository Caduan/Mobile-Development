package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Nikonov.N.G";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                onNextActivity(view);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "error in onStart");
        Log.w(TAG, "warning in onStart");
        Log.i("IKBO-68-23", "info in OnStart");
        Log.d("IKBO-68-23", "debug in OnStart");
        Log.v("IKBO-68-23", "verbose in OnStart");
    }

    public void onNextActivity(View view) {
        EditText nameText = findViewById(R.id.name);
        EditText ageText = findViewById(R.id.age);
        EditText markText = findViewById(R.id.mark);
        EditText groupText = findViewById(R.id.group1);

        String name = nameText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());
        int mark = Integer.parseInt(markText.getText().toString());
        String group = groupText.getText().toString();

        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("group", group);
        intent.putExtra("age", age);
        intent.putExtra("mark", mark);
        startActivity(intent);
    }
}