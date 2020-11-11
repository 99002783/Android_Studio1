package com.example.myapplication;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class DownloadTask extends AsyncTask<String,Integer,Void> {
    private static final String TAG = DownloadTask.class.getSimpleName();

ProgressBar mprogressbar;
    public DownloadTask(ProgressBar progressbar) {
        mprogressbar=progressbar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mprogressbar.setVisibility(View.VISIBLE);
    }

    /**
     * method will run on a seperate thread
     * @param strings
     * @return
     */

    @Override
    protected Void doInBackground(String... strings) {
       Log.i(TAG,strings[0]);

           try {
               for(int i=0;i<=20;i++) {
                   publishProgress(i * 5);
                   Thread.sleep(200);
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mprogressbar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mprogressbar.setVisibility(View.INVISIBLE);
    }
}

