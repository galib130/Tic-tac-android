package com.example.connectdots;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

int k=1,flag=0,l,m=0;
    int[] mem={2,2,2,2,2,2,2,2,2};
    int [][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gamestate=true;
    public void dropin(View view) {
        ImageView counter = (ImageView) view;
        int tag1 = Integer.parseInt(counter.getTag().toString());


        if (mem[tag1] == 2) {

            if (k % 2 == 0 && gamestate) {
                mem[tag1] = 3;
                counter.setTranslationY(-2000f);
                counter.setImageResource(R.drawable.red2);
                counter.animate().translationYBy(2000f).setDuration(300);
                counter.animate().setDuration(300);

                k++;
            } else if (k % 2 != 0 && gamestate) {
                mem[tag1] = 4;
                counter.setTranslationY(-2000f);
                counter.setImageResource(R.drawable.yellowchip);
                counter.animate().translationYBy(2000f).setDuration(300);
                counter.animate().setDuration(300);

                k++;
            }
            for (int[] winner : win) {
                if (mem[winner[0]] == mem[winner[1]] && mem[winner[1]] == mem[winner[2]] && mem[winner[0]] != 2) {
                    gamestate = false;
                    System.out.println("won!");


                    LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
                    layout.setVisibility(View.VISIBLE);
                    TextView edi = (TextView) findViewById(R.id.textview);
                    if (mem[winner[0]] == 3) {
                        edi.setText("            RED Wins!");
                    } else if (mem[winner[0]] == 4) {
                        edi.setText("          YELLOW Wins!");
                    }
                    flag = 1;

                }
            }
            if (flag != 1) {
                for (l = 0; l < 9; l++) {
                    if (mem[l] != 2) {
                        m++;
                    }
                }
                if (m == 9) {
                    gamestate=false;
                    LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
                    layout.setVisibility(View.VISIBLE);
                    TextView edi2 = (TextView) findViewById(R.id.textview);
                    edi2.setText("              DRAW");
                    m = 0;

                } else {
                    m = 0;
                }

            }
        }
    }
    public void again(View view)
    {
        LinearLayout layout=(LinearLayout)findViewById(R.id.linearLayout);

        layout.setVisibility(View.INVISIBLE);
        flag=0;
        m=0;


      ImageView im=(ImageView)findViewById(R.id.imageView1);
      im.setImageResource(0);
        ImageView im1=(ImageView)findViewById(R.id.imageView2);
        im1.setImageResource(0);
        ImageView im2=(ImageView)findViewById(R.id.imageView3);
        im2.setImageResource(0);
        ImageView im3=(ImageView)findViewById(R.id.imageView4);
        im3.setImageResource(0);
        ImageView im4=(ImageView)findViewById(R.id.imageView5);
        im4.setImageResource(0);
        ImageView im5=(ImageView)findViewById(R.id.imageView6);
        im5.setImageResource(0);
        ImageView im6=(ImageView)findViewById(R.id.imageView7);
        im6.setImageResource(0);
        ImageView im7=(ImageView)findViewById(R.id.imageView8);
        im7.setImageResource(0);
        ImageView im8=(ImageView)findViewById(R.id.imageView9);
        im8.setImageResource(0);


        System.out.println("hi1");

        k=1;
        System.out.println("hi2");
        for( int i=0;i<9;i++)
        {

            mem[i]=2;


        }
        gamestate=true;






    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
