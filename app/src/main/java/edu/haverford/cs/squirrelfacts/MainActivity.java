package edu.haverford.cs.squirrelfacts;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.widget.ListView;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Downloads JSON, parses each squirrel, and adds it to the collection via a task.
 */
class GetNewSquirrelsTask extends AsyncTask<String, Void, Void> {

    /**
     * TODO: Implement this method to download a list of squirrels and parse it
     * @param strings
     * @return
     */
    @Override
    protected Void doInBackground(String... strings) {
        return null;
    }



}

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.squirrel_list);
        Squirrel s = new Squirrel("Black Squirrel",
                "Haverford, PA",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Black_Squirrel.jpg/220px-Black_Squirrel.jpg");
        SquirrelList sl = (new SquirrelList());
        for (int i = 0; i < 100; i++) {
            sl.addToFront(s);
        }
        ArrayList<Squirrel> al = sl.toArrayList();
        SquirrelArrayAdapter adapter = new SquirrelArrayAdapter(this, al);
        /**
         * TODO: Uncomment this and make sure you can use your adapter
         */
        //SquirrelListAdapter adapter = new SquirrelListAdapter(this, sl);
        listView.setAdapter(adapter);
    }
}
