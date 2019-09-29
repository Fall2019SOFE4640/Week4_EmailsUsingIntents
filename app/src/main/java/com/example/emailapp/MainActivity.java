/*
Author: Anwar Abdalbari
Date:Sept. 26, 2019
Purpose: Create an pp to send emails
 */
package com.example.emailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextTo = findViewById(R.id.edit_text_to);
        mEditTextSubject = findViewById(R.id.edit_text_subject);
        mEditTextMessage = findViewById(R.id.edit_text_message);

        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call sendMail method
                sendMail();
            }
        });
    }

    private void sendMail() {

        //create a recipient List
        String recipientList = mEditTextTo.getText().toString();
        //remove , from the recipientList
        String recipient[] =recipientList.split(",");

        //read the subject
        String subject  = mEditTextSubject.getText().toString();

        //read the message
        String message = mEditTextMessage.getText().toString();

        //create the intent
        Intent intent = new Intent(Intent.ACTION_SEND);

        //load the mail info into the intent
        intent.putExtra(Intent.EXTRA_EMAIL,recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");

        //start the activity
        startActivity(Intent.createChooser(intent,"How do you want to send this message?"));

    }
}
