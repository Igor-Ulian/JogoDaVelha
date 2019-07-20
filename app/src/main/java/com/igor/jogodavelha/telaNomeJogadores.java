package com.igor.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Locale;

public class telaNomeJogadores extends AppCompatActivity {

    EditText jg1, jg2;
    Intent tela;

    ImageView img;

    String nj1 = "";
    String nj2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_nome_jogadores2);
        jg1 = findViewById(R.id.inputJogador1);
        jg2 = findViewById(R.id.inputJogador2);

        Locale loc = Locale.getDefault();
        String lg = loc.getLanguage();

        if(lg.contains("pt")){  //Verify language from set image logo
            img = findViewById(R.id.imgLogo);
            img.setImageResource(R.drawable.strlogopt);
        } else if(lg.contains("es")){ //Verify language from set image logo
            img = findViewById(R.id.imgLogo);
            img.setImageResource(R.drawable.strlogoes);
        }
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
        if(!ok) return;

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
