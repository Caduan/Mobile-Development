package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView messageText = new TextView(this);
        messageText.setTextSize(26);
        messageText.setPadding(16, 16, 16, 16);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            String name = arguments.getString("name");
            String group = arguments.getString("group");
            int age = arguments.getInt("age");
            int mark = arguments.getInt("mark");
            messageText.setText("Name: " + name + "\nAge: " + age + "\nMark: " + mark + "\nGroup: " + group);
        }
        setContentView(messageText);
    }
}