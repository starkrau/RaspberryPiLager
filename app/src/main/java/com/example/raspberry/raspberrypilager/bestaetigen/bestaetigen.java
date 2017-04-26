package com.example.raspberry.raspberrypilager.bestaetigen;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.bestellung.bestellung;
import com.example.raspberry.raspberrypilager.lieferung.lieferung;

import static com.example.raspberry.raspberrypilager.bestellung.bestellung.status;

public class bestaetigen extends AppCompatActivity {

    public void clickLieferung(View view){
        startActivity(new Intent(bestaetigen.this,lieferung.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestaetigen);

        Intent bestellung = getIntent();
        String status = bestellung.getStringExtra("status");
//        Toast.makeText(getApplicationContext(),status,Toast.LENGTH_LONG).show();


        ImageView bild = (ImageView) findViewById(R.id.Bilder);
        if (status.equals("sl1")){
            bild.setImageResource(R.drawable.shh);
            Toast.makeText(getApplicationContext(),"Schlüsselanhänger 1",Toast.LENGTH_LONG).show();
        }else if (status.equals("sl2")){
            bild.setImageResource(R.drawable.qwe);
            Toast.makeText(getApplicationContext(),"Schlüsselanhänger 2",Toast.LENGTH_LONG).show();
        }else if (status.equals("sl3")){
            bild.setImageResource(R.drawable.yacht);
            Toast.makeText(getApplicationContext(),"Schlüsselanhänger 3",Toast.LENGTH_LONG).show();
        }
        RelativeLayout.LayoutParams grosse = new RelativeLayout.LayoutParams(600,600);
        grosse.addRule(RelativeLayout.CENTER_IN_PARENT);
        bild.setLayoutParams(grosse);
    }

    public void onClickImg(View view){
        if (status.equals("sl1")){
            Toast.makeText(getApplicationContext(),"Schlüsselanhänger 1",Toast.LENGTH_LONG).show();
        }else if (status.equals("sl2")){
            Toast.makeText(getApplicationContext(),"Schlüsselanhänger 2",Toast.LENGTH_LONG).show();
        }else if (status.equals("sl3")){
            Toast.makeText(getApplicationContext(),"Schlüsselanhänger 3",Toast.LENGTH_LONG).show();
        }
    }

}
