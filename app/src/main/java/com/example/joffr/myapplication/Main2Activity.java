package com.example.joffr.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private static final String NOME_PREFERENCIA = "AULALOGIN";
    private static final String LOGN = "LOGIN";
    private static final String SENHA = "SENHA";

    Context c = this;
    TextView saudacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        String nome = b.getString("nome");
        saudacao = (TextView)findViewById(R.id.saud);
        saudacao.setText("Olá "+nome);
    }

    public void logout(View v){

        SharedPreferences preferencias = getSharedPreferences(NOME_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString(LOGN, "");
        editor.putString(SENHA, "");

        editor.commit();
        finish();
    }

}
