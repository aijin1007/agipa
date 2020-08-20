package com.peygreatz.store;

import android.app.Activity;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



public class MiddleActivity extends Activity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_middle);



        Intent intent = new Intent(this, ArActivity.class);

        intent.putExtra("arguments", 50);

        startActivity(intent);

    }

}