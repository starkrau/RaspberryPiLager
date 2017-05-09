package com.example.raspberry.raspberrypilager.bestellung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.bestaetigen.Bestaetigen;

public class Bestellung extends AppCompatActivity {


    public static String status;

    public void clickBestellen(View view) {

        RadioButton sl1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton sl2 = (RadioButton) findViewById(R.id.rb2);
        RadioButton sl3 = (RadioButton) findViewById(R.id.rb3);

        if (sl1.isChecked()) {
            status = "sl1";
        } else if (sl2.isChecked()) {
            status = "sl2";
        } else if (sl3.isChecked()) {
            status = "sl3";
        } else {
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
    }
}
