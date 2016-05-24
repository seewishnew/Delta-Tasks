package com.example.vishnu.firsttask;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String COUNT = "count";
    public static final String INDEX = "Index";
    public int count = 0;
    public int index = 0;


    private SharedPreferences preferences;

    private final String colors[] = {"red","blue","black","white","yellow","green"};

    Random rand = new Random();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferences = getPreferences(MODE_PRIVATE);

        count = preferences.getInt(COUNT, 0);
        index = preferences.getInt(INDEX,0);

        TextView textView = (TextView) findViewById(R.id.count);

        textView.setText("" + count + " times");

        setColor();

//       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(COUNT, count);
        editor.putInt(INDEX, index);

        editor.commit();

        Log.d("Main Activity", "Saved preferences");
    }

    //    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        outState.putInt(COUNT, count);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickListener(View view) {

        count++;

        TextView textView = (TextView) findViewById(R.id.count);


        if(count == 1)
            textView.setText("1 time");

        else
            textView.setText("" + count + " times");



        index = rand.nextInt(6);

        setColor();



    }


    public void setColor(){

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        TextView textView = (TextView)findViewById(R.id.count);
        TextView textView1 = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        Button button1 = (Button) findViewById(R.id.reset);

        relativeLayout.setBackgroundColor(Color.parseColor(colors[index]));

        textView.setTextColor(Color.parseColor(colors[5 - index]));
        textView1.setTextColor(Color.parseColor(colors[5 - index]));

        button.setTextColor(Color.parseColor(colors[index]));
        button.setBackgroundColor(Color.parseColor(colors[5 - index]));

        button1.setTextColor(Color.parseColor(colors[index]));
        button1.setBackgroundColor(Color.parseColor(colors[5 - index]));

    }

    public void reset(View view){
        count = 0;
        TextView textView = (TextView) findViewById(R.id.count);

        textView.setText("" + count + " times");
    }

}
