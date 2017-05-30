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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.bestellung.Bestellung;
import com.example.raspberry.raspberrypilager.uberuns.Uberuns;

import org.json.JSONObject;

public class Menu extends AppCompatActivity {

    String anh = "anh=300";

    public void clickBestellung(View view) {
        startActivity(new Intent(Menu.this, Bestellung.class));

        String url = "https://dionysos.informatik.hs-augsburg.de/test/check.php?" + anh;
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest check = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(getApplicationContext(), "Response is: "+ response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            //    Toast.makeText(getApplicationContext(), "Response is: "+ error.toString(),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        queue.add(check);
    }






 /*       // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://dionysos.informatik.hs-augsburg.de/test/check.php?" + anh;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Toast.makeText(getApplicationContext(), "Response is: "+ response,Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
*/


    public void clickUber(View view) {

        startActivity(new Intent(Menu.this, Uberuns.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}
