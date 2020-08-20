package com.peygreatz.store;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import com.braintreepayments.cardform.view.CardForm;
import androidx.appcompat.app.AlertDialog;
import android.widget.Toast;

public class activity_payment  extends AppCompatActivity {


        CardForm cardForm;
        Button buy;
        AlertDialog.Builder alertBuilder;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_payment);

            cardForm = findViewById(R.id.card_form);
            buy = findViewById(R.id.btnBuy);
            cardForm.cardRequired(true)
                    .expirationRequired(true)
                    .cvvRequired(true)
                    .postalCodeRequired(true)
                    .mobileNumberRequired(true)
                    .mobileNumberExplanation("SMS is required on this number")
                    .setup(activity_payment.this);
            cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardForm.isValid()) {
                        alertBuilder = new AlertDialog.Builder(activity_payment.this);
                        alertBuilder.setTitle("Confirm before purchase");
                        alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                                "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                                "Card CVV: " + cardForm.getCvv() + "\n" +
                                "Postal code: " + cardForm.getPostalCode() + "\n" +
                                "Phone number: " + cardForm.getMobileNumber());
                        alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Toast.makeText(activity_payment.this, "Thank you for purchase! please fill up the next form for the completion of your order.", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(activity_payment.this, ActivityCheckout.class);
                                startActivity(intent);
                            }
                        });
                        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog alertDialog = alertBuilder.create();
                        alertDialog.show();

                    } else {
                        Toast.makeText(activity_payment.this, "Please complete the form", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

