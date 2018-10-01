package edu.haverford.cs.squirrelfacts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SquirrelInfoActivity extends AppCompatActivity {
    private ImageView mSquirrelPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squirrel_info);
        Intent i = getIntent();
        TextView name = (TextView) findViewById(R.id.squirrelName);
        TextView location = (TextView) findViewById(R.id.squirrelLocation);
        // SOL
        mSquirrelPic = (ImageView)findViewById(R.id.squirrelPic);
        name.setText(i.getStringExtra("name"));
        location.setText(i.getStringExtra("location"));
        new SquirrelImageLoader().execute(i.getStringExtra("picture"));
        return;
    }

    private class SquirrelImageLoader extends AsyncTask<String, Void, Void> {
        Bitmap mBitmap;

        /**
         *
         * @param strings
         * @return
         */
        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }

        /**
         * TODO: Implement this
         */
        @Override
        protected void onProgressUpdate(Void... values) {
            return;
        }
    }
}
