package com.peygreatz.store;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activityEdit extends AppCompatActivity {
Button update;
EditText name,mobile,email,address,dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        update =(Button) findViewById(R.id.update);
        name = (EditText)findViewById(R.id.name);
        mobile = (EditText)findViewById(R.id.mobile);
        email = (EditText)findViewById(R.id.email);
        address = (EditText)findViewById(R.id.address);
        dob  = (EditText)findViewById(R.id.dob);

    }

    // "Send text back" button click
    public void goToAnActivity(View view) {

String name1 =name.getText().toString();
        String mobile1 =mobile.getText().toString();
        String email1 =email.getText().toString();
        String address1 =address.getText().toString();
        String dob1 =dob.getText().toString();





        // put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("name", name1);
        intent.putExtra("mobile", mobile1);
        intent.putExtra("email", email1);
        intent.putExtra("address", address1);
        intent.putExtra("dob", dob1);
        setResult(RESULT_OK, intent);
        finish();
    }
}