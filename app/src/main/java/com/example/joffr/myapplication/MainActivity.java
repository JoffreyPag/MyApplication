package com.example.joffr.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String NOME_PREFERENCIA = "AULALOGIN";
    private static final String LOGN = "LOGIN";
    private static final String SENHA = "SENHA";
    EditText et, et2;
    String login, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sets = getSharedPreferences(NOME_PREFERENCIA, MODE_PRIVATE);
        login = sets.getString(LOGN, "");
        senha = sets.getString(SENHA, "");
        if(login.equals("jojo") && senha.equals("jojo")){
            Intent i = new Intent(this, Main2Activity.class);
            Bundle b = new Bundle();
            b.putString("nome", "joffrey");
            i.putExtras(b);
            startActivity(i);
        }
    }

    public void login(View v){
        et = (EditText)findViewById(R.id.campLogin);
        et2 = (EditText)findViewById(R.id.campSenha);
        login = et.getText().toString();
        senha = et2.getText().toString();

        if(login.equals("jojo")){
            if(senha.equals("jojo")){
                Intent i = new Intent(this, Main2Activity.class);
                Bundle b = new Bundle();
                b.putString("nome", "Joffrey");
                i.putExtras(b);
                startActivity(i);


            }else{
                Toast.makeText(this, "Senha invalida", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "login invalido", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences preferencias = getSharedPreferences(NOME_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString(LOGN, login);
        editor.putString(SENHA, senha);

        editor.commit();
    }
}
