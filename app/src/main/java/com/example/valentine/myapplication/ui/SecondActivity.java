package com.example.valentine.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.valentine.myapplication.R;

public class SecondActivity extends AppCompatActivity {

    private TextView messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = this.getIntent();
        messageText = findViewById(R.id.messageText);
        messageText.setText(intent.getStringExtra(getString(R.string.key_message)));
    }
}
