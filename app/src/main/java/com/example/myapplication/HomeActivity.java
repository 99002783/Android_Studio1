package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.w(TAG,"clickHandler");
        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        String data=extras.getString("mykey");
        TextView result=findViewById(R.id.textViewResult);
        result.setText(data);


    }
}