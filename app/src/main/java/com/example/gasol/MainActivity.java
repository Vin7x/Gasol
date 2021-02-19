package com.example.gasol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editDistInial;
    private EditText editDistFinal;
    private EditText editLitros;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDistFinal = findViewById(R.id.edit_Dist_Final);
        editDistInial = findViewById(R.id.edit_Dist_Inicial);
        editLitros = findViewById(R.id.editText_liters);
        btnCalc = findViewById(R.id.btn_calc);


        btnCalc.setOnClickListener(view -> {
            if (!validate()) {
                Toast.makeText(MainActivity.this, "Preencha os campos corretamente!", Toast.LENGTH_LONG).show();
                return;
            }
            String sDistanciaInicial = editDistInial.getText().toString();
            String sDistanciaFinal = editDistFinal.getText().toString();
            String sLitros = editLitros.getText().toString();


            int distanciaI = Integer.parseInt(sDistanciaInicial);
            int distanciaF = Integer.parseInt(sDistanciaFinal);
            int litros = Integer.parseInt(sLitros);

            int distanciaPercorrida = calcDistancia(distanciaF, distanciaI);

            double result = calculateAverage(distanciaPercorrida, litros);

            DecimalFormat resultFormat = new DecimalFormat("0.00");
            String resultFinal = resultFormat.format(result);

            Log.d("TESTE", "RESULTADO -->>" + resultFinal);

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("result", resultFinal);
            intent.putExtra("resultDistancia", distanciaPercorrida);
            startActivity(intent);


            /*AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.alert_calc)
                    .setMessage(resultFinal)
                    .setNegativeButton(android.R.string.ok, (dialogInterface, which) -> dialogInterface.dismiss())

                    .create();
            alertDialog.show();*/

            //txtKmPercorrido.setText("Você percorreu " + distanciaPercorrida + " Km e fez " + resultFinal + "Km por litro");
        });


    }

    private boolean validate() {
        return (!editLitros.getText().toString().startsWith("0")
                && !editDistInial.getText().toString().startsWith("0")
                && !editDistFinal.getText().toString().startsWith("0")
                && !editDistInial.getText().toString().isEmpty()
                && !editDistFinal.getText().toString().isEmpty()
                && !editLitros.getText().toString().isEmpty()
        );
    }

    private int calcDistancia(int df, int di){
        return (df-di);
    }

    private double calculateAverage(int dist, int liters) {
        return ((double)dist / (double)liters);
    }
}