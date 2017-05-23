package com.example.raspberry.raspberrypilager.bestaetigen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.lieferung.Lieferung;

import static com.example.raspberry.raspberrypilager.bestellung.Bestellung.status;

public class Bestaetigen extends AppCompatActivity {

    public void clickLieferung(View view) {
        startActivity(new Intent(Bestaetigen.this, Lieferung.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestaetigen);

        Intent bestellung = getIntent();
        String status = bestellung.getStringExtra("status");
//        Toast.makeText(getApplicationContext(),status,Toast.LENGTH_LONG).show();


        ImageView bild = (ImageView) findViewById(R.id.Bilder);
        if (status.equals("sla1")) {
            bild.setImageResource(R.mipmap.rot1);
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 1", Toast.LENGTH_SHORT).show();
        } else if (status.equals("sla2")) {
            bild.setImageResource(R.mipmap.blau1);
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 2", Toast.LENGTH_SHORT).show();
        } else if (status.equals("sla3")) {
            bild.setImageResource(R.mipmap.grun1);
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 3", Toast.LENGTH_SHORT).show();
        } else if (status.equals("sla4")){
            bild.setImageResource(R.mipmap.gelb1);
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 4", Toast.LENGTH_SHORT).show();
        }
        RelativeLayout.LayoutParams grosse = new RelativeLayout.LayoutParams(600, 600);
        grosse.addRule(RelativeLayout.CENTER_IN_PARENT);
        bild.setLayoutParams(grosse);
    }

    public void onClickImg(View view) {
        if (status.equals("sla1")) {
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 1", Toast.LENGTH_SHORT).show();
        } else if (status.equals("sla2")) {
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 2", Toast.LENGTH_SHORT).show();
        } else if (status.equals("sla3")) {
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 3", Toast.LENGTH_SHORT).show();
        } else if (status.equals("sla4")) {
            Toast.makeText(getApplicationContext(), "Schlüsselanhänger 4", Toast.LENGTH_SHORT).show();
        }

    }
}