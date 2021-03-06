package com.example.valentine.myapplication.ui;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.valentine.myapplication.R;
import com.example.valentine.myapplication.model.Cat;
import com.example.valentine.myapplication.service.CatService;

public class CatsActivity extends AppCompatActivity {
    @Nullable
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cats);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(
                getResources().getBoolean(R.bool.isLandscape) ?
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) :
                new LinearLayoutManager(this)
        );

        recyclerView.setAdapter(new CatsAdapter(CatService.getCats(), new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Cat cat, int position) {
                if (null != mediaPlayer) {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(CatsActivity.this, R.raw.cat);
                mediaPlayer.start();
            }
        }));
    }

    @Override
    protected void onDestroy() {
        if (null != mediaPlayer) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
