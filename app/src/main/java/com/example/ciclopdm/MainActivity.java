package com.example.ciclopdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ciclopdm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private final String CICLO_PDM_TAG = "CICLO_PDM_TAG";
    private ActivityMainBinding activityMainBinding;

    // constantes de dados de instância
    private final String TELEFONE = "Telefone";

    // Views dinamicas
    private TextView telefoneTv;
    private EditText telefoneEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // Views dinamicas
        telefoneTv = new TextView(this);
        telefoneTv.setText("Telefone");
        telefoneEt = new EditText(this);
        telefoneEt.setInputType(InputType.TYPE_CLASS_PHONE);

        activityMainBinding.linearLayout.addView(telefoneTv);
        activityMainBinding.linearLayout.addView(telefoneEt);

        /*if (savedInstanceState != null) {
            telefoneEt.setText(savedInstanceState.getString(TELEFONE, ""));
        }*/

        Log.v(CICLO_PDM_TAG, "onCreate: iniciando ciclo completo");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        telefoneEt.setText(savedInstanceState.getString(TELEFONE, ""));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(CICLO_PDM_TAG, "onStart: iniciando ciclo visivel");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(CICLO_PDM_TAG, "onResume: iniciando ciclo em primeiro plano");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(CICLO_PDM_TAG, "onPause: finalizando ciclo em primeiro plano");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(CICLO_PDM_TAG, "onStop: finalizando ciclo visivel");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(CICLO_PDM_TAG, "onDestroy: finalizando ciclo completo");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(CICLO_PDM_TAG, "onRestart: reiniciando ciclo visivel");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // salvando dados
        outState.putString(TELEFONE, telefoneEt.getText().toString());
    }
}