package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] units;
    private Spinner spinner;
    private EditText editText;
    private TextView textView;
    private Button button;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        units = getResources().getStringArray(R.array.UnitsConversion);
        spinner = findViewById(R.id.unitSpinnerId);
        editText = findViewById(R.id.editTextId);
        textView = findViewById(R.id.resultTextId);
        button = findViewById(R.id.calculateButton);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.sample_view, R.id.sampleTextView, units);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItems = spinner.getSelectedItem().toString();
                switch (selectedItems){
                    case "cm to inches":
                        result= String.valueOf(0.393*getValue());
                        textView.setText("Your Result : " + result);
                        break;
                    case "inches to cm":
                        result= String.valueOf(2.54*getValue());
                        textView.setText("Your Result : " + result);
                        break;
                    case "kg to lbs":
                        result= String.valueOf(2.20462*getValue());
                        textView.setText("Your Result : " + result);
                        break;
                    case "lbs to kg":
                        result= String.valueOf(0.453592*getValue());
                        textView.setText("Your Result : " + result);
                        break;
                    case "Celsius to Fahrenheit":
                        result= String.valueOf((getValue()*1.8)+32);
                        textView.setText("Your Result : " + result);
                        break;
                    case "Fahrenheit to Celsius":
                        result= String.valueOf((getValue()-32)/1.8);
                        textView.setText("Your Result : " + result);
                        break;
                    case "meters to feet":
                        result= String.valueOf(3.28084*getValue());
                        textView.setText("Your Result : " + result);
                        break;
                    case "Feet to Meters":
                        result= String.valueOf(0.3048*getValue());
                        textView.setText("Your Result : " + result);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + selectedItems);
                }
            }
        });
    }

    public double getValue(){
        return Double.parseDouble(String.valueOf(editText.getText()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.about_us_Id){
            Toast.makeText(this, "Hello There... I'm Rahat.. Happy Coding...kichu paccina likhar mto", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.contact_us_Id){
            Intent intent = new Intent(getApplicationContext(), FeedBackActivity.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.share_Id){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject = "Unit Conversion App By Al Shafiullah";
            String text = "This may be very useful App for Unit Conversion\nThis is My First Android app\nHope you would like it:)";

            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, text);

            startActivity(Intent.createChooser(intent, "Share Via "));
        }
        return super.onOptionsItemSelected(item);
    }
}