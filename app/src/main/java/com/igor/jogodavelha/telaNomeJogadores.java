package com.igor.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class telaNomeJogadores extends AppCompatActivity {

    EditText jg1, jg2;
    Intent tela;

    String nj1 = "";
    String nj2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_nome_jogadores2);
        jg1 = findViewById(R.id.inputJogador1);
        jg2 = findViewById(R.id.inputJogador2);
    }

    public void iniciarClick(View view) { //Start Click
        boolean ok = true;

        if(jg1.getText().toString().trim().isEmpty()){ //Verify if EditText if empty
            ok = false;
            jg1.setError(getString(R.string.msgErro));
        }
        if(jg2.getText().toString().trim().isEmpty()){ //Verify if EditText if empty
            ok = false;
            jg2.setError(getString(R.string.msgErro));
        }
        if(ok != true) return;

        nj1 = jg1.getText().toString();
        nj2 = jg2.getText().toString();
        tela = new Intent(getApplicationContext(), MainActivity.class);

        Bundle par = new Bundle();
        par.putString("nj2", nj2); //Sending name player 1
        par.putString("nj1", nj1); //Sending name player 2

        tela.putExtras(par); // Sending data to another screen

        startActivity(tela);


    }
}
