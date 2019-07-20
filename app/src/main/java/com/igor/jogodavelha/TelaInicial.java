package com.igor.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class TelaInicial extends AppCompatActivity {

    Intent tela;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
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

    public void click2(View view) { //2 Players Click
        tela = new Intent(getApplicationContext(), telaNomeJogadores.class);
        startActivity(tela);
    }

    public void click1(View view) { //1 Player Click
        tela = new Intent(getApplicationContext(), tela1Jogador.class);
        startActivity(tela);
    }
}
