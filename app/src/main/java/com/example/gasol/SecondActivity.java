package com.example.gasol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.txtView);
        int kmPercorrido = 0;

        kmPercorrido = getIntent().getExtras().getInt("resultDistancia", 0);
        String resultFinal = getIntent().getExtras().getString("result", "");

        textView.setText("Você percorreu " + kmPercorrido + "Km e fez " + resultFinal + "Km/l");
    }
}