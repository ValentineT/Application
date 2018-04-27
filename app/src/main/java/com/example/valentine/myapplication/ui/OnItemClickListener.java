package com.example.valentine.myapplication.ui;

import android.support.annotation.NonNull;

import com.example.valentine.myapplication.model.Cat;

public interface OnItemClickListener {
    void onItemClick(@NonNull Cat cat, int position);
}
