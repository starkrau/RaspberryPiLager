package com.example.raspberry.raspberrypilager.bestaetigen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.Splash;
import com.example.raspberry.raspberrypilager.lieferung.Lieferung;
import com.example.raspberry.raspberrypilager.menu.Menu;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.raspberry.raspberrypilager.bestellung.Bestellung.status;

public class Bestaetigen extends AppCompatActivity {

    int anh;
    String report;
    String satznr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestaetigen);

        Intent bestellung = getIntent();
        String status = bestellung.getStringExtra("status");
//        Toast.makeText(getApplicationContext(),status,Toast.LENGTH_LONG).show();


        ImageView bild = (ImageView) findViewById(R.id.Bilder);
        if (status.equals("rot")) {
            bild.setImageResource(R.drawable.rotb);
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 1", Toast.LENGTH_SHORT).show();
            anh = 100;
        } else if (status.equals("blau")) {
            bild.setImageResource(R.drawable.blaub);
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 2", Toast.LENGTH_SHORT).show();
            anh = 200;
        } else if (status.equals("grün")) {
            bild.setImageResource(R.drawable.grunb);
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 3", Toast.LENGTH_SHORT).show();
            anh = 300;
        } else if (status.equals("gelb")){
            bild.setImageResource(R.drawable.gelb);
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 4", Toast.LENGTH_SHORT).show();
            anh = 400;
        }  else if (status.equals("orange")) {
            bild.setImageResource(R.drawable.orangeb);
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 5", Toast.LENGTH_SHORT).show();
            anh = 500;
        }
        RelativeLayout.LayoutParams grosse = new RelativeLayout.LayoutParams(600, 600);
        grosse.addRule(RelativeLayout.CENTER_IN_PARENT);
        bild.setLayoutParams(grosse);
    }

    public void onClickImg(View view) {
        if (status.equals("rot")) {
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 1", Toast.LENGTH_SHORT).show();
        } else if (status.equals("blau")) {
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 2", Toast.LENGTH_SHORT).show();
        } else if (status.equals("grün")) {
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 3", Toast.LENGTH_SHORT).show();
        } else if (status.equals("gelb")) {
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 4", Toast.LENGTH_SHORT).show();
        } else if (status.equals("orange")) {
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 5", Toast.LENGTH_SHORT).show();
        }

    }

    public void clickLieferung(View view) {

        String url = "https://dionysos.informatik.hs-augsburg.de/rest/api/order.php?anh=" + anh;
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest order = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    report = response.getString("status");
                    satznr = response.getString("satznr");
                    if(report.equals("OK")){
                        Intent i = new Intent(Bestaetigen.this, Lieferung.class);
                        i.putExtra("satznr", satznr);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(),"Verbindung nicht möglich! Versuchen Sie es in einem Moment erneut!",Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Bestaetigen.this.startActivity(new Intent(Bestaetigen.this,Menu.class));
                                Bestaetigen.this.finish();
                            }
                        },2500);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_LONG).show();
                Log.d("Report: ", error.toString());
            }
        });

        queue.add(order);


    }
}