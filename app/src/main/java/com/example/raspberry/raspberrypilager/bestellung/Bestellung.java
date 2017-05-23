package com.example.raspberry.raspberrypilager.bestellung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.bestaetigen.Bestaetigen;

//import static com.example.raspberry.raspberrypilager.R.id.sa1;

public class Bestellung extends AppCompatActivity {


    public static String status;

    public void clickBestellen(View view) {

        RadioButton sla1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton sla2 = (RadioButton) findViewById(R.id.rb2);
        RadioButton sla3 = (RadioButton) findViewById(R.id.rb3);
        RadioButton s1a4 = (RadioButton) findViewById(R.id.rb4);


        if (sla1.isChecked()) {
            status = "sla1";
        } else if (sla2.isChecked()) {
            status = "sla2";
        } else if (sla3.isChecked()) {
            status = "sla3";
        } else if (s1a4.isChecked()) {
            status = "s1a4";
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
    }
}
