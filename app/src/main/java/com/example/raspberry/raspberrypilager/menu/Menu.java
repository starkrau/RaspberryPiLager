package com.example.raspberry.raspberrypilager.menu;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.bestellung.Bestellung;
import com.example.raspberry.raspberrypilager.uberuns.Uberuns;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Menu extends AppCompatActivity {


    String rot_txt;
    String blau_txt;
    String gruen_txt;
    String gelb_text;
    String orange_text;


    public void clickBestellung(View view) {


        String url = "https://dionysos.informatik.hs-augsburg.de/rest/api/checkall.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest check = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                     rot_txt = response.getString("ROT");
                     blau_txt = response.getString("BLAU");
                     gruen_txt = response.getString("GRUEN");
                     gelb_text = response.getString("GELB");
                     orange_text = response.getString("ORANGE");
                    Intent i = new Intent(Menu.this, Bestellung.class);
                    i.putExtra("rot_txt",rot_txt);
                    i.putExtra("blau_txt",blau_txt);
                    i.putExtra("gruen_txt",gruen_txt);
                    i.putExtra("gelb_txt",gelb_text);
                    i.putExtra("orange_txt",orange_text);
                    startActivity(i);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_LONG).show();
            }
        });


        queue.add(check);



    }


    public void clickUber(View view) {

        startActivity(new Intent(Menu.this, Uberuns.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}
