package com.example.vishnu.firsttask;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    public ListView lv;
    public ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
    }

    public void listen(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "I'm listening!");

        startActivityForResult(intent, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK)
        {
            if(requestCode==REQUEST_CODE)
            {
//              String result = data.getStringExtra(RecognizerIntent.EXTRA_RESULTS);
//                if(result==null)
//                    Log.d("MainActivity", "Null returned");
//
//                else {
//                    adapter.add(result);
//
//                    lv.setAdapter(adapter);
//                }


                ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                String result = results.get(0);

                adapter.add(result);

                lv.setAdapter(adapter);
            }
        }
    }
}
