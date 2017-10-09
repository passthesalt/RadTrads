package com.example.austinlee.radtrads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Info extends AppCompatActivity {

    int charNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        charNum = getIntent().getIntExtra("num", -1);
        WebView web = (WebView)findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());

        if(charNum == 6){
            web.loadUrl("https://en.wikipedia.org/wiki/Long_(surname_%E9%BE%8D)");
        }
        if(charNum == 7){
            web.loadUrl("https://en.wiktionary.org/wiki/%E5%8F%91");
        }
        if(charNum == 8){
            web.loadUrl("https://en.wiktionary.org/wiki/%E6%B3%BD");
        }
        if(charNum == 9){
            web.loadUrl("https://en.wiktionary.org/wiki/%E6%97%A0");
        }

    }
}
