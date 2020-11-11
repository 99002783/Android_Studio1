package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class AsyncActivity extends AppCompatActivity {
    private static final String TAG =AsyncActivity.class.getSimpleName() ;
    ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        progressbar=findViewById(R.id.progressBar);
    }

    public void handleClick(View view) {
        Log.i(TAG,"handleClick");
        DownloadTask downloadtask=new DownloadTask(progressbar);
        downloadtask.execute("https://urlForimagetobedownloaded");

    }

    public void serviceHandler(View view) {
        Intent serviceIntent=new Intent(AsyncActivity.this,MusicService.class);

        switch(view.getId())
        {
            case R.id.buttonStart:
                startService(serviceIntent);
                break;
            case R.id.buttonStop:
                stopService(serviceIntent);
                break;
        }
    }
}