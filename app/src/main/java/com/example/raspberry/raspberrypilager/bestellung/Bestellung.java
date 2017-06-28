package com.example.raspberry.raspberrypilager.bestellung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.bestaetigen.Bestaetigen;


public class Bestellung extends AppCompatActivity {


    public static String status;


    public void clickBestellen(View view) {

        RadioButton rot = (RadioButton) findViewById(R.id.rb1);
        RadioButton blau = (RadioButton) findViewById(R.id.rb2);
        RadioButton grün = (RadioButton) findViewById(R.id.rb3);
        RadioButton gelb = (RadioButton) findViewById(R.id.rb4);
        RadioButton orange = (RadioButton) findViewById(R.id.rb5);

        if (rot.isChecked()) {
            status = "rot";
        } else if (blau.isChecked()) {
            status = "blau";
        } else if (grün.isChecked()) {
            status = "grün";
        } else if (gelb.isChecked()) {
            status = "gelb";
        } else if (orange.isChecked()) {
            status = "orange";
        }
        else {
            status = "Bitte was auswählen!";
            Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
            return;
        }


        Intent i = new Intent(Bestellung.this, Bestaetigen.class);
        i.putExtra("status", status);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestellung);

        RadioButton rot = (RadioButton) findViewById(R.id.rb1);
        RadioButton blau = (RadioButton) findViewById(R.id.rb2);
        RadioButton grün = (RadioButton) findViewById(R.id.rb3);
        RadioButton gelb = (RadioButton) findViewById(R.id.rb4);
        RadioButton orange = (RadioButton) findViewById(R.id.rb5);

        Intent Menu = getIntent();
        String rottxt = Menu.getStringExtra("rot_txt");
        String blautxt = Menu.getStringExtra("blau_txt");
        String gruentxt = Menu.getStringExtra("gruen_txt");
        String gelbtxt = Menu.getStringExtra("gelb_txt");
        String orangetxt = Menu.getStringExtra("orange_txt");

       if(rottxt.equals("0")){
            rot.setEnabled(false);
        }
        if(blautxt.equals("0")){
            blau.setEnabled(false);
        }
        if(gruentxt.equals("0")){
            grün.setEnabled(false);
        }
        if(gelbtxt.equals("0")){
            gelb.setEnabled(false);
        }
        if(orangetxt.equals("0")){
            orange.setEnabled(false);
        }

        TextView tv1 = (TextView) findViewById(R.id.rot_txtvw);
        TextView tv2 = (TextView) findViewById(R.id.blau_txtvw);
        TextView tv3 = (TextView) findViewById(R.id.gruen_txtvw);
        TextView tv4 = (TextView) findViewById(R.id.gelb_txtvw);
        TextView tv5 = (TextView) findViewById(R.id.orange_txtvw);

        tv1.setText(rottxt);
        tv2.setText(blautxt);
        tv3.setText(gruentxt);
        tv4.setText(gelbtxt);
        tv5.setText(orangetxt);
    }
}
