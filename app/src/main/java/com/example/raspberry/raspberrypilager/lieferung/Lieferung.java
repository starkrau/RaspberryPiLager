package com.example.raspberry.raspberrypilager.lieferung;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.Splash;
import com.example.raspberry.raspberrypilager.menu.Menu;
import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import static com.example.raspberry.raspberrypilager.R.id.gifImageView;

public class Lieferung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieferung);

        gifImageView2 = (GifImageView) findViewById(R.id.gifImageView2);

        try {
            InputStream inputStream = getAssets().open("post.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        } catch (IOException e) {
            e.printStackTrace();
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Lieferung.this.startActivity(new Intent(Lieferung.this,Menu.class));
                Lieferung.this.finish();
            }
        },6000);
    }
}
