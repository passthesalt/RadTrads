package com.example.austinlee.radtrads;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class SimpTrad extends AppCompatActivity {

    int charNum;
    boolean flag = true;

    ImageView simp;
    ImageView trad;

    public class DownloadTask extends AsyncTask<String, Void, Bitmap> //URL, method, output
    {

        @Override
        protected Bitmap doInBackground(String... params) {

            String htmlContent = "";
            URL url;
            Bitmap bitmap = null;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();

                InputStream in = urlConnection.getInputStream();

                bitmap = BitmapFactory.decodeStream(in);

                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();

            }
            return bitmap;
        }
    }//DownloadTask

    public  void downloadImage(String which, String url)  {
        DownloadTask task = new DownloadTask();
        try {
            Bitmap bitmap = task.execute(url).get();
            if(which.equals("simp"))
                simp.setImageBitmap(bitmap);
            else
                trad.setImageBitmap(bitmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }//downloadTask

    public void fadeaway(View v)
    {
        ImageView simp = (ImageView) findViewById(R.id.simp);
        ImageView trad = (ImageView) findViewById(R.id.trad);

        if (flag) {
            trad.animate().alpha(0f).setDuration(1500);
            simp.animate().alpha(1f).setDuration(1500);
        } else {
            simp.animate().alpha(0f).setDuration(1500);
            trad.animate().alpha(1f).setDuration(1500);
        }
        flag = !flag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simp_trad);

        Button vid = (Button)findViewById(R.id.tradVid);
        simp = (ImageView) findViewById(R.id.simp);
        trad = (ImageView) findViewById(R.id.trad);

        charNum = getIntent().getIntExtra("num", 0);

        Toast.makeText(this, "Tap the photo to see the alternate form", Toast.LENGTH_SHORT).show();

        if(charNum == 0){
            downloadImage("simp", "https://upload.wikimedia.org/wikipedia/commons/4/4f/%E4%B8%80-red.png");
            downloadImage("trad", "http://www.cidianwang.com/file/shufa/kaishu/zhaomengfu/2016110142157678.gif");
            vid.setOnClickListener(
                    new View.OnClickListener(){
                        public void onClick(View v){
                            Intent next = new Intent(SimpTrad.this, Vid.class);
                            next.putExtra("num", 1);
                            startActivityForResult(next, 0);
                        }
                    }
            );
        }//1
        if(charNum == 1){
            downloadImage("simp", "https://upload.wikimedia.org/wikipedia/commons/8/8e/%E4%BA%8C-order.gif");
            downloadImage("trad", "http://163.20.160.14/~word/uploads/photos/6095.gif");
            vid.setOnClickListener(
                    new View.OnClickListener(){
                        public void onClick(View v){
                            Intent next = new Intent(SimpTrad.this, Vid.class);
                            next.putExtra("num", 2);
                            startActivityForResult(next, 0);
                        }
                    }
            );
        }//2
        if(charNum == 2){
            downloadImage("simp", "https://upload.wikimedia.org/wikipedia/commons/9/9f/%E4%B8%89-red.png");
            downloadImage("trad", "https://www.moedict.tw/%E5%8F%83.png");
            vid.setOnClickListener(
                    new View.OnClickListener(){
                        public void onClick(View v){
                            Intent next = new Intent(SimpTrad.this, Vid.class);
                            next.putExtra("num", 3);
                            startActivityForResult(next, 0);
                        }
                    }
            );
        }//3
        if(charNum == 3){
            downloadImage("simp", "https://upload.wikimedia.org/wikipedia/commons/9/9a/%E5%9B%9B-red.png");
            downloadImage("trad", "http://www.koreanwikiproject.com/wiki/images/2/22/%E8%82%86.png");
            vid.setOnClickListener(
                    new View.OnClickListener(){
                        public void onClick(View v){
                            Intent next = new Intent(SimpTrad.this, Vid.class);
                            next.putExtra("num", 4);
                            startActivityForResult(next, 0);
                        }
                    }
            );
        }//4
        if(charNum == 4){
            downloadImage("simp", "https://upload.wikimedia.org/wikipedia/commons/1/19/%E4%BA%94-red.png");
            downloadImage("trad", "http://www.koreanwikiproject.com/wiki/images/b/bd/%E4%BC%8D.png");
            vid.setOnClickListener(
                    new View.OnClickListener(){
                        public void onClick(View v){
                            Intent next = new Intent(SimpTrad.this, Vid.class);
                            next.putExtra("num", 5);
                            startActivityForResult(next, 0);
                        }
                    }
            );
        }//5
        if(charNum == 5){
            downloadImage("simp", "http://www.cidianwang.com/file/shufa/xingshu/2014120915383390.jpg");
            downloadImage("trad", "https://upload.wikimedia.org/wikipedia/commons/b/b4/%E9%BE%8D-order.gif");
            vid.setText("Info");
            vid.setOnClickListener(
                    new View.OnClickListener(){
                        public void onClick(View v){
                            Intent next = new Intent(SimpTrad.this, Info.class);
                            next.putExtra("num", 6);
                            startActivityForResult(next, 0);
                        }
                    }
            );
        }//Dragon
        if(charNum == 6){
            downloadImage("simp", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/%E5%8F%91-order.gif/100px-%E5%8F%91-order.gif");
            downloadImage("trad", "http://img.supfree.net/shufa/k/106334.gif");
            vid.setText("Info");
            vid.setOnClickListener(
                    new View.OnClickListener(){
                        public void onClick(View v){
                            Intent next = new Intent(SimpTrad.this, Info.class);
                            next.putExtra("num", 7);
                            startActivityForResult(next, 0);
                        }
                    }
            );
        }//Transmit
        if(charNum == 7){
            downloadImage("simp", "https://upload.wikimedia.org/wikipedia/commons/5/5d/%E6%B3%BD-order.gif");
            downloadImage("trad", "http://zidian.wenku1.com/TextImg/%E6%BE%A4.png");
            vid.setText("Info");
            vid.setOnClickListener(
                    new View.OnClickListener(){
                        public void onClick(View v){
                            Intent next = new Intent(SimpTrad.this, Info.class);
                            next.putExtra("num", 8);
                            startActivityForResult(next, 0);
                        }
                    }
            );
        }//Lake
        if(charNum == 8){
            downloadImage("simp", "http://www.mandarinbanana.com/assets/stroke-order-imgs/%E6%97%A0-order-cf5030d74a09fa353490878e2148e661016884c0f28d8a47587fd9ce0e2ec5aa.gif");
            downloadImage("trad", "https://upload.wikimedia.org/wikipedia/commons/8/8d/%E7%84%A1-ired.png");
            vid.setText("Info");
            vid.setOnClickListener(
                    new View.OnClickListener(){
                        public void onClick(View v){
                            Intent next = new Intent(SimpTrad.this, Info.class);
                            next.putExtra("num", 9);
                            startActivityForResult(next, 0);
                        }
                    }
            );
        }//Nothing


    }
}
