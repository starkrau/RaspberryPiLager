package com.example.raspberry.raspberrypilager.lieferung;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.menu.Menu;
import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class Lieferung extends AppCompatActivity {

    private GifImageView postLieferung;
    String satz;
    DoBackgroundTask abfrage = new DoBackgroundTask();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieferung);
        Intent Bestaetigen = getIntent();
        satz = Bestaetigen.getStringExtra("satz");

        abfrage.execute();

    }


    private class DoBackgroundTask extends AsyncTask<Void, Void, String> {

        String status;



        @Override
        protected void onPreExecute(){
            postLieferung = (GifImageView) findViewById(R.id.postLieferung);

            try {
                InputStream inputStream = getAssets().open("post.gif");
                byte[] bytes = IOUtils.toByteArray(inputStream);
                postLieferung.setBytes(bytes);
                postLieferung.startAnimation();
                Log.d("Satznr", satz);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... params) {

            String url = "https://dionysos.informatik.hs-augsburg.de/rest/api/status.php?snr=" + satz;
            JSONObject json = getJSONFromUrl(url);
            try {
                status = json.getString("status");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.d("Report:" , status);
            return status;
        }


        @Override
        protected void onPostExecute(String result){
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    try{
                            if (status.equals("0")) {
                                int i = 0;
                                i++;
                                if ( i < 20){
                                    DoBackgroundTask request = new DoBackgroundTask();
                                    request.execute();
                                    Toast.makeText(getApplicationContext(), "Bestellung wird verarbeitet!", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Error! Fehler bei der Lieferung! Vorgang abgebrochen!", Toast.LENGTH_LONG).show();
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Lieferung.this.startActivity(new Intent(Lieferung.this, Menu.class));
                                            Lieferung.this.finish();
                                        }
                                    }, 4000);
                                }



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

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }, 8000);
        }

    }

    public JSONObject getJSONFromUrl(String url) {


         InputStream is = null;
         String json = "";
        JSONObject jObj = null;
        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line ;
            while ((line = reader.readLine()) != null) {
                // sb.append(line + "n");
                sb.append(line);
            }
            is.close();
            json = sb.toString();

        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String
        return jObj;

    }



}









        /*    private class Abfrage(){

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

       JsonObjectRequest cycle = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            status = response.getString("status");
                            Toast.makeText(getApplicationContext(), status,Toast.LENGTH_SHORT).show();
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

            return status;
    */




