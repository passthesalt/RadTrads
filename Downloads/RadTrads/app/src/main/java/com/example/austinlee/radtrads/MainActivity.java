package com.example.austinlee.radtrads;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setStatusBarColor(Color.RED);

        Button enter = (Button)findViewById(R.id.enter);
        enter.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent next = new Intent(MainActivity.this, Chars.class);
                        startActivityForResult(next, 0);
                    }
                }
        );

    }
}
