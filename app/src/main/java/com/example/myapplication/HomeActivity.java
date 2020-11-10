package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    String[] languages;

    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.w(TAG,"clickHandler");
        languages = new String[]{"english","hindi","urdu","kannada"};
        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        String data=extras.getString("mykey");
        TextView result=findViewById(R.id.textViewResult);
        result.setText(data);
        ListView countriesListView = findViewById(R.id.countriesListview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, //layout file of each row in the listview
                R.layout.row_listview, languages);
                // android.R.layout.simple_list_item_1, //layout file of each row in the listview

        countriesListView.setAdapter(adapter);


    }
}