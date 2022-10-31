package com.example.mynumberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private RadioButton radio2, radio3, radio4;
    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);

        buttonStart = findViewById(R.id.buttonStart);

       buttonStart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, GameActivity.class);

               if (!radio2.isChecked() && !radio3.isChecked() && !radio4.isChecked()) {
                   Snackbar.make(view, "Please select a number of digits", Snackbar.LENGTH_LONG).show();
               } else {
                   if (radio2.isChecked()) {
                       intent.putExtra("two", 2);
                   } else if (radio3.isChecked()) {
                       intent.putExtra("three", 3);
                   } else if (radio4.isChecked()) {
                       intent.putExtra("four", 4);
                   }
                   startActivity(intent);
               }
           }
       });

    }
}