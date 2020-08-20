package com.peygreatz.store;


import android.app.Activity;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_option extends Activity {
    private ImageButton cash,card,paypal;
    Button back;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        back= (Button) findViewById(R.id.button4);


      
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(activity_option.this, ActivityShoppingCart.class);
                startActivity(i);
            }

        });

        card= (ImageButton) findViewById(R.id.card);

        card.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(activity_option.this, activity_payment.class);
                startActivity(i);
            }

        });


    }
}