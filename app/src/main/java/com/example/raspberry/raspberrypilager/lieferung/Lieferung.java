package com.example.raspberry.raspberrypilager.lieferung;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.Splash;
import com.example.raspberry.raspberrypilager.bestellung.Bestellung;
import com.example.raspberry.raspberrypilager.menu.Menu;
import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class Lieferung extends AppCompatActivity {

    private GifImageView postLieferung;
    String status;
    Intent bestaetigen = getIntent();
    String satznr = bestaetigen.getStringExtra("satznr");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieferung);

        postLieferung = (GifImageView) findViewById(R.id.postLieferung);

        try {
            InputStream inputStream = getAssets().open("post.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            postLieferung.setBytes(bytes);
            postLieferung.startAnimation();
        } catch (IOException e) {
            e.printStackTrace();
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Lieferung.this.startActivity(new Intent(Lieferung.this, Menu.class));
                Lieferung.this.finish();
            }
        }, 6000);


    }
/*
    private class Abfrage(){

        for(int i = 0;i < 20 ; i++){
            String url = "https://dionysos.informatik.hs-augsburg.de/rest/api/status.php?snr=" + satznr;
            RequestQueue queue = Volley.newRequestQueue(this);
            JsonObjectRequest cycle = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    try {
                        status = response.getString("status");
                        if (status.equals("0")) {

                        } else if (status.equals("-1")) {
                            Toast.makeText(getApplicationContext(), "Error! Fehler bei der Lieferung! Vorgang abgebrochen!", Toast.LENGTH_LONG).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Lieferung.this.startActivity(new Intent(Lieferung.this, Menu.class));
                                    Lieferung.this.finish();
                                }
                            }, 4000);

                        } else if (status.equals("1")) {
                            Toast.makeText(getApplicationContext(), "Bestellung erfolgreich! Viel Spaß!", Toast.LENGTH_LONG).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Lieferung.this.startActivity(new Intent(Lieferung.this, Menu.class));
                                    Lieferung.this.finish();
                                }
                            }, 4000);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                }
            });

            queue.add(cycle);

        }
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e1) {
            e1.printStackTrace();
        }
    }
    */
}



