package com.igor.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaInicial extends AppCompatActivity {

    Intent tela;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void click2(View view) { //2 Players Click
        tela = new Intent(getApplicationContext(), telaNomeJogadores.class);
        startActivity(tela);
    }

    public void click1(View view) { //1 Player Click
        tela = new Intent(getApplicationContext(), tela1Jogador.class);
        startActivity(tela);
    }
}
