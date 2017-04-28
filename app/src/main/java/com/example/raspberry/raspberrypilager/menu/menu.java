package com.example.raspberry.raspberrypilager.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.raspberry.raspberrypilager.R;
import com.example.raspberry.raspberrypilager.bestellung.bestellung;
import com.example.raspberry.raspberrypilager.uberuns.uberuns;

public class menu extends AppCompatActivity {

    public void clickBestellung(View view){
        startActivity(new Intent(menu.this,bestellung.class));
    }

    public void clickUber(View view){
        startActivity(new Intent(menu.this,uberuns.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        System.out.println("Bla-bla!");
    }
}
