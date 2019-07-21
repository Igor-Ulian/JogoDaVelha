package com.igor.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class tela1Jogador extends AppCompatActivity {

    TextView txt;
    Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09;
    int player = 1;
    String playernm = "";
    String nomePlayer1 = " ";
    String nomePlayer2 = "BOT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1_jogador);
        txt = findViewById(R.id.txt);
        nomePlayer1 = getString(R.string.strVoce);
        playernm = nomePlayer1;
        txt.setText(getString(R.string.strSuaVez));
        registraBotoes();
    }

    public void clicou(View view) { //Click
        if(player == 1){ //Verify if is player time
            Button btn = getBotao(view);
            if(btn.getText().toString() != "X" && btn.getText().toString() != "O"){ //Verify if Button is empty
                printaXO(view);
                verificarGanhador();
                proximo();
            }else{
                toastar(getString(R.string.strSlotOcupado));
            }
        }else{
            toastar(getString(R.string.strVezDoBotAguarde));
        }
    }

    public void proximo(){ //Next
        if(player == 1){
            player = 2;
            playernm = nomePlayer2;
            txt.setText(getString(R.string.strVezDoBot));
            jogadaDoBot();
        }else{
            player = 1;
            playernm = nomePlayer1;
            txt.setText(getString(R.string.strSuaVez));
        }
    }
    public void jogadaDoBot(){ //BOT play
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() { //Delay
                printaBOT();
                verificarGanhador();
                proximo();
            }
        }, 2000);
    }

    public void resetarJogo(int n1, int n2, int n3){ //Function to Reset Game
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() { //Delay
                int n = 1;
                for(int x = 1; x<= 9 ; x++){
                    Button btn = getBotaoNumero(n);
                    btn.setText(R.string.Vazio);  // For from set all Button names to " "
                    n++;
                }
            }
        }, 2000);
    }

    public void toastar(String str){ // Function to send toast
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public void printaXO(View v){ // Player print
        Button btn = getBotao(v);
        btn.setText("X");

    }

    public void printaBOT(){ // BOT print
        int n = 1;

        for(int x = 1; x <= 9; x++){ //Search for a good play
            Button btn = getBotaoNumero(n);

                if(btn.getText().toString() != "X" && btn.getText().toString() != "O"){

                    //MIDDLE
                    for(int bt = 1; bt <= 4; bt++){ //Middle
                        if(getBotaoNumero(n - bt) != null && getBotaoNumero(n + bt) != null){
                            if(getBotaoNumero(n - bt).getText().toString().equals("O")
                                    && getBotaoNumero(n + bt).getText().toString().equals("O")){
                                btn.setText("O");
                                return;
                            }
                        }
                    }

                    //MEDIUM
                    int bt = 1;
                    for(int c = 1; c <= 2; c++){ //Horizontal e Vertical
                        if(getBotaoNumero(n - bt) != null && getBotaoNumero(n - bt*2) != null){
                            if(getBotaoNumero(n - bt).getText().toString().equals("O")
                                    && getBotaoNumero(n - bt*2).getText().toString().equals("O")){
                                btn.setText("O");
                                return;
                            }
                        }
                        bt = 3;
                    }

                    bt = 1;
                    for(int c = 1; c <= 2; c++){ //Horizontal e Vertical
                        if(getBotaoNumero(n + bt) != null && getBotaoNumero(n + bt*2) != null){
                            if(getBotaoNumero(n + bt).getText().toString().equals("O")
                                    && getBotaoNumero(n + bt*2).getText().toString().equals("O")){
                                btn.setText("O");
                                return;
                            }
                        }
                        bt = 3;
                    }

                    for(int c = 1; c <= 4; c++){ // i'm lost, help-me
                        if(getBotaoNumero(n - c) != null && getBotaoNumero(n - c*2) != null){
                            if(getBotaoNumero(n - c).getText().toString().equals("X")
                                    && getBotaoNumero(n - c*2).getText().toString().equals("X")){
                                btn.setText("O");
                                return;
                            }
                        }
                    }

                    int c = 1;
                    for(int d = 1; d<= 2; d++){
                        if(getBotaoNumero(n + c) != null && getBotaoNumero(n + c*2) != null){
                            if(getBotaoNumero(n + c).getText().toString().equals("X")
                                    && getBotaoNumero(n + c*2).getText().toString().equals("X")){
                                btn.setText("O");
                                return;
                            }
                        }
                        c = 3;
                    }

                }
            n++;
        }

        n = (int) Math.floor(Math.random() * (9 - 1 + 1)) + 1;
        for(int x = 1; x <= 100; x++){  // If the BOT don't find a good play he play in some empty slot
            Button btn = getBotaoNumero(n);
            if(btn.getText().toString() != "X" && btn.getText().toString() != "O"){
                btn.setText("O");
                return;
            }
            n = (int) Math.floor(Math.random() * (9 - 1 + 1)) + 1;
        }
    }

    public Button getBotao(View v){  //Function to get the button according the view
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

    public Button getBotaoNumero(int n){ //Function to get the button according to the number
        switch (n){
            case 1:
                return btn01;
            case 2:
                return btn02;
            case 3:
                return btn03;
            case 4:
                return btn04;
            case 5:
                return btn05;
            case 6:
                return btn06;
            case 7:
                return btn07;
            case 8:
                return btn08;
            case 9:
                return btn09;
        }
        return null;
    }

    public void verificarGanhador(){  //Verify Winner

        //Horizontal

        if(  (btn01.getText() == btn02.getText() && btn02.getText() == btn03.getText())
                &&  (btn01.getText() == "X" || btn01.getText() == "O")  ){
            toastar(playernm +" " + getString(R.string.strGanhou));
            resetarJogo(1,2,3);
        }

        if(  (btn04.getText() == btn05.getText() && btn05.getText() == btn06.getText())
                &&  (btn04.getText() == "X" || btn04.getText() == "O")  ){
            toastar(playernm +" " + getString(R.string.strGanhou) );
            resetarJogo(4,5,6);
        }

        if(  (btn07.getText() == btn08.getText() && btn08.getText() == btn09.getText())
                &&  (btn07.getText() == "X" || btn07.getText() == "O")  ){
            toastar(playernm +" " + getString(R.string.strGanhou));
            resetarJogo(7,8,9);
        }

        //Vertical

        if(  (btn01.getText() == btn04.getText() && btn04.getText() == btn07.getText())
                &&  (btn01.getText() == "X" || btn01.getText() == "O")  ){
            toastar(playernm +" " + getString(R.string.strGanhou));
            resetarJogo(1,4,7);
        }

        if(  (btn02.getText() == btn05.getText() && btn05.getText() == btn08.getText())
                &&  (btn02.getText() == "X" || btn02.getText() == "O")  ){
            toastar(playernm +" " + getString(R.string.strGanhou));
            resetarJogo(2,5,8);
        }

        if(  (btn03.getText() == btn06.getText() && btn06.getText() == btn09.getText())
                &&  (btn03.getText() == "X" || btn03.getText() == "O")  ){
            toastar(playernm +" " + getString(R.string.strGanhou));
            resetarJogo(3,6,9);
        }

        //Diagonal

        if(  (btn01.getText() == btn05.getText() && btn05.getText() == btn09.getText())
                &&  (btn01.getText() == "X" || btn01.getText() == "O")  ){
            toastar(playernm +" " + getString(R.string.strGanhou));
            resetarJogo(1,5,9);
        }

        if(  (btn03.getText() == btn05.getText() && btn05.getText() == btn07.getText())
                &&  (btn03.getText() == "X" || btn03.getText() == "O")  ){
            toastar(playernm +" " + getString(R.string.strGanhou));
            resetarJogo(3,5,7);
        }

        //Tied

        if((btn01.getText() == "X" || btn01.getText() == "O") && (btn02.getText() == "X" || btn02.getText() == "O")
                && (btn03.getText() == "X" || btn03.getText() == "O") && (btn04.getText() == "X" || btn04.getText() == "O")
                && (btn05.getText() == "X" || btn05.getText() == "O") && (btn06.getText() == "X" || btn06.getText() == "O")
                && (btn07.getText() == "X" || btn07.getText() == "O") && (btn08.getText() == "X" || btn08.getText() == "O")
                && (btn09.getText() == "X" || btn09.getText() == "O")){
            resetarJogo(0,0,0);
            toastar(getString(R.string.strJogoEmpatado));
        }





    }

    public void registraBotoes(){ //Register Buttons
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
