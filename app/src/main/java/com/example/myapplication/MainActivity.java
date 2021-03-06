package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.database.DbAccessObj;

public class MainActivity extends AppCompatActivity {

    public static final String MYPREFS = "myprefs";
    public static final String NAMEKEY = "namekey";
    public static final String PWDKEY = "pwdkey";
    private String TAG=MainActivity.class.getSimpleName();
    DbAccessObj dbAccessObj;
    EditText nameEditText,pwdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");
         nameEditText = findViewById(R.id.editTextName);
         pwdEditText = findViewById(R.id.editTextPwd);

        dbAccessObj = new DbAccessObj(this);
        dbAccessObj.openDb();

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
        savedata();

    }

    private void savedata() {
            Log.i(TAG,"saveData");

            //get the data from the edittext
            String name = nameEditText.getText().toString();
            String pwd = pwdEditText.getText().toString();
            //create a file names myprefs
            SharedPreferences preferences = getSharedPreferences(MYPREFS,MODE_PRIVATE);
            //open the file
            SharedPreferences.Editor editor = preferences.edit();
            //write to the file
            editor.putString(NAMEKEY,name);
            editor.putString(PWDKEY,pwd);
            //save the file
            editor.apply();

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onresume");
        restoredata();

    }

    private void restoredata() {

        Log.i(TAG,"restoreData");

        //open the file
        SharedPreferences preferences = getSharedPreferences(MYPREFS,MODE_PRIVATE);
        //read the file
        String name = preferences.getString(NAMEKEY,"");
        String pwd = preferences.getString(PWDKEY,"");
        //set the data in edittexts
        nameEditText.setText(name);
        pwdEditText.setText(pwd);
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
            case R.id.buttonlogin :
                startHome();
                break;
            case R.id.buttoncancel:
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


    public void handleDb(View view) {
        switch (view.getId()){
            case R.id.buttonput:
                String title = nameEditText.getText().toString();
                String subtitle = pwdEditText.getText().toString();

                dbAccessObj.createRow(title,subtitle);
                break;
            case R.id.buttonget:
                String data =  dbAccessObj.readRow();
                //set the data onto textview
                TextView dbTextView = findViewById(R.id.textViewdb);
                dbTextView.setText(data);
                break;
        }
    }
}