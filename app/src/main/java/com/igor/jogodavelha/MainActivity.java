package com.igor.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtnm;
    Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09;
    int player = 1;
    String playernm = "";
    String nomePlayer1 = "1";
    String nomePlayer2 = "2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnm = findViewById(R.id.txtnm);
        Bundle par = getIntent().getExtras();
        nomePlayer1 = par.getString("nj1");
        nomePlayer2 = par.getString("nj2");
        playernm = nomePlayer1;
        txtnm.setText(playernm);
        registraBotoes();
    }

    public void clicou(View view) { //Click
        Button btn = getBotao(view);
        if(btn.getText().toString() != "X" && btn.getText().toString() != "O"){ //Verify if slot if empty
            printaXO(view);
            verificarGanhador();
            proximo();
            txtnm.setText(playernm);
        }else{
            toastar("" + getString(R.string.strSlotOcupado));
            return;
        }
    }

    public void proximo(){ //Change player
        if(player == 1){
            player = 2;
            playernm = nomePlayer2;
        }else{
            player = 1;
            playernm = nomePlayer1;
        }
    }

    public void resetarJogo(){ //reset game
        txtnm.setText(playernm);

        btn01.setText(R.string.Vazio);
        btn02.setText(R.string.Vazio);
        btn03.setText(R.string.Vazio);
        btn04.setText(R.string.Vazio);
        btn05.setText(R.string.Vazio);
        btn06.setText(R.string.Vazio);
        btn07.setText(R.string.Vazio);
        btn08.setText(R.string.Vazio);
        btn09.setText(R.string.Vazio);
    }

    public void toastar(String str){ //toast
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public void printaXO(View v){ //Print
        String letra = "";
        if(player == 1){ //Verify player
            letra = "X";
        }else{
            letra = "O";
        }
        Button btn = getBotao(v);
        btn.setText(letra);
    }

    public Button getBotao(View v){  //Function to get button according the view
        switch (v.getId()){
            case R.id.btn01:
                return btn01;
            case R.id.btn02:
                return btn02;
            case R.id.btn03:
                return btn03;
            case R.id.btn04:
                return btn04;
            case R.id.btn05:
                return btn05;
            case R.id.btn06:
                return btn06;
            case R.id.btn07:
                return btn07;
            case R.id.btn08:
                return btn08;
            case R.id.btn09:
                return btn09;
        }
        return null;
    }

    public void verificarGanhador(){ //Verify winner

        //Horizontal

        if(  (btn01.getText() == btn02.getText() && btn02.getText() == btn03.getText())
                &&  (btn01.getText() == "X" || btn01.getText() == "O")  ){
            printaGanhou();
            resetarJogo();
        }

        if(  (btn04.getText() == btn05.getText() && btn05.getText() == btn06.getText())
                &&  (btn04.getText() == "X" || btn04.getText() == "O")  ){
            printaGanhou();
            resetarJogo();
        }

        if(  (btn07.getText() == btn08.getText() && btn08.getText() == btn09.getText())
                &&  (btn07.getText() == "X" || btn07.getText() == "O")  ){
            printaGanhou();
            resetarJogo();
        }

        //Vertical

        if(  (btn01.getText() == btn04.getText() && btn04.getText() == btn07.getText())
                &&  (btn01.getText() == "X" || btn01.getText() == "O")  ){
            printaGanhou();
            resetarJogo();
        }

        if(  (btn02.getText() == btn05.getText() && btn05.getText() == btn08.getText())
                &&  (btn02.getText() == "X" || btn02.getText() == "O")  ){
            printaGanhou();
            resetarJogo();
        }

        if(  (btn03.getText() == btn06.getText() && btn06.getText() == btn09.getText())
                &&  (btn03.getText() == "X" || btn03.getText() == "O")  ){
            printaGanhou();
            resetarJogo();
        }

        //Diagonal

        if(  (btn01.getText() == btn05.getText() && btn05.getText() == btn09.getText())
                &&  (btn01.getText() == "X" || btn01.getText() == "O")  ){
            printaGanhou();
            resetarJogo();
        }

        if(  (btn03.getText() == btn05.getText() && btn05.getText() == btn07.getText())
                &&  (btn03.getText() == "X" || btn03.getText() == "O")  ){
            printaGanhou();
            resetarJogo();
        }

        //Tied

        if((btn01.getText() == "X" || btn01.getText() == "O") && (btn02.getText() == "X" || btn02.getText() == "O")
                && (btn03.getText() == "X" || btn03.getText() == "O") && (btn04.getText() == "X" || btn04.getText() == "O")
                && (btn05.getText() == "X" || btn05.getText() == "O") && (btn06.getText() == "X" || btn06.getText() == "O")
                && (btn07.getText() == "X" || btn07.getText() == "O") && (btn08.getText() == "X" || btn08.getText() == "O")
                && (btn09.getText() == "X" || btn09.getText() == "O")){
            resetarJogo();
            toastar("" + getString(R.string.strJogoEmpatado));
        }





    }

    public void printaGanhou(){
        toastar("" + getString(R.string.strOJogador) + playernm + " " + getString(R.string.strGanhou) + "!");
    }

    public void registraBotoes(){ //Register buttons
        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn03 = findViewById(R.id.btn03);
        btn04 = findViewById(R.id.btn04);
        btn05 = findViewById(R.id.btn05);
        btn06 = findViewById(R.id.btn06);
        btn07 = findViewById(R.id.btn07);
        btn08 = findViewById(R.id.btn08);
        btn09 = findViewById(R.id.btn09);
    }
}
