package com.training.threadandasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress);
    }

    /*public void btn1(View view) {

        try {
            Thread.sleep(3000);
            new Thread(new Runnable() {
                @Override
                public void run() {
                   handler.post(new Runnable() {
                       @Override
                       public void run() {
                           Toast.makeText(MainActivity.this,"thread toastr",Toast.LENGTH_SHORT).show();
                       }
                   });
                }
            }).start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }*/

    public void progressBar(View view) {
        new ProgressTask().execute();

    }

    private class ProgressTask extends AsyncTask<Void,Integer,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            for (int i=0;i<=100;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(MainActivity.this,"process finish",Toast.LENGTH_SHORT).show();
        }
    }
}
