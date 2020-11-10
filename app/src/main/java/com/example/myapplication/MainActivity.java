package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onpause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onresume");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onstop");

    }

    public void clickHandler(View view) {
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        switch (view.getId())
        {
            case R.id.buttonLogin :
                startHome();
                break;
            case R.id.buttonCancel:
                Intent dialIntent =new Intent(Intent.ACTION_VIEW,  Uri.parse("tel:12345678" ));
                startActivity(dialIntent);
                break;
        }


    }

    private void startHome() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra("mykey", "charitha");
        //int c = add(10, 20);
        startActivity(intent);
    }


}