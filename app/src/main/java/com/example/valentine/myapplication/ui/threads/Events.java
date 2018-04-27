package com.example.valentine.myapplication.ui.threads;

public interface Events {
    void onPreExecute();

    void onPostExecute();

    void onProgressUpdate(Integer integer);

    void onCancel();
}
