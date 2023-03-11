package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBackActivity extends AppCompatActivity {

    private EditText nameEditText, feedbackEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        nameEditText = findViewById(R.id.nameTextId);
        feedbackEditText = findViewById(R.id.feedbackTextId);
        submitButton = findViewById(R.id.submitButtonId);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String name = nameEditText.getText().toString();
                    String feedback = feedbackEditText.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/email");

                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"anikk210@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback From Users ");
                    intent.putExtra(Intent.EXTRA_TEXT, "Name : "+name + "\nFeedback : "+feedback);

                    startActivity(Intent.createChooser(intent, "Give Feedback "));
                }catch(Exception e){
                    Toast.makeText(FeedBackActivity.this, "Exception : " + e, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}