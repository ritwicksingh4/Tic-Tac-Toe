package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive=true;
    //player representations
    //1-O
    //0-X
    int activeplayer = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    //state meanings
    //1-O
    //0-X
    //2-NULL
    int[][] winpositions={{0,1,2},{3,4,5},{6,7,8},
                          {0,3,6},{1,4,7},{2,5,8},
                          {0,4,8},{2,4,6}};
    public void playerTap(View view)
    {
    ImageView img=(ImageView) view;
    int tappedimage = Integer.parseInt(img.getTag().toString());
    if(!gameactive)
    {
        gamereset(view);
        return;
    }
    if(gamestate[tappedimage]==2 && gameactive) {
        gamestate[tappedimage] = activeplayer;
        img.setTranslationY(-1000f);
        if (activeplayer == 0) {
            img.setImageResource(R.drawable.x);
            activeplayer = 1;
            TextView status = findViewById(R.id.status);
            status.setText("O's Turn - tap to play");
        }
        else
            {
            img.setImageResource(R.drawable.o);
            activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - tap to play");
        }
        img.animate().translationYBy(1000f).setDuration(300);
    }
    for(int[] winposition: winpositions)
    {
        if(gamestate[winposition[0]]==gamestate[winposition[1]] &&
                gamestate[winposition[1]]==gamestate[winposition[2]] &&
                gamestate[winposition[0]]!=2)
        {
            String winnerstr;
            gameactive=false;
            if(gamestate[winposition[0]]==0)
            {
                winnerstr = "X has won";
            }
            else
            {
                winnerstr = "O has won";
            }
            TextView status = findViewById(R.id.status);
            status.setText(winnerstr);
        }
    }
    }

    public void gamereset(View view)
    {
        gameactive=true;
        activeplayer=0;
        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - tap to play");
        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}