package com.example.valentine.myapplication.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.valentine.myapplication.R;
import com.example.valentine.myapplication.ui.threads.ThreadsExerciseActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputMessage;
    private Button showActivityBtn;
    private Button catsBtn;
    private Button sendEmailBtn;
    private Button layoutTestBtn;
    private Button threadsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMessage = findViewById(R.id.inputMessage);

        layoutTestBtn = findViewById(R.id.buttonLayout);
        layoutTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LayoutTestActivity.class);
                startActivity(intent);
            }
        });


        catsBtn = findViewById(R.id.buttonCats);
        catsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CatsActivity.class);
                startActivity(intent);
            }
        });

        showActivityBtn = findViewById(R.id.buttonActivity);
        showActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(getString(R.string.key_message), getMessage());
                startActivity(intent);
            }
        });

        sendEmailBtn = findViewById(R.id.buttonEmail);
        sendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, getMessage());
                intent.putExtra(Intent.EXTRA_SUBJECT, getMessage());
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"bring_it@list.ru"});
                startActivity(intent);
            }
        });

        threadsBtn = findViewById(R.id.buttonExerciseThreads);
        threadsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThreadsExerciseActivity.class);
                startActivity(intent);
            }
        });




    }



    @NonNull
    private String getMessage() {
        String message = inputMessage.getText().toString();
        if (message.isEmpty()) {
            message = getString(R.string.hello_text);
        }
        return message;
    }
}