package com.example.raspberry.raspberrypilager.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.bestellung.Bestellung;
import com.example.raspberry.raspberrypilager.uberuns.Uberuns;

public class Menu extends AppCompatActivity {

    public void clickBestellung(View view) {
        startActivity(new Intent(Menu.this, Bestellung.class));
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
