package com.example.austinlee.radtrads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Chars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chars);

        ListView listView = (ListView)findViewById(R.id.charList);

        ArrayList<String> chars = new ArrayList<String>();
        chars.add("One");
        chars.add("Two");
        chars.add("Three");
        chars.add("Four");
        chars.add("Five");
        chars.add("Dragon");
        chars.add("Transmit");
        chars.add("Lake");
        chars.add("Nothing");
        //chars.add("Station");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chars);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(itemClickListener);
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(getApplicationContext(), ""+position, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext(), SimpTrad.class);
            intent.putExtra("num", position);
            startActivity(intent);
        }
    };
}
