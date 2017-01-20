package com.homework4.eparslow18.yahtzee;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import android.util.ArrayMap;

import java.util.Random;

/**
 * Class to create Dice object
 * Displays frame and creates button to stop dice roll
 * Displays count of dice on button click
 */
public class Dice extends AppCompatActivity implements  View.OnClickListener {

    //array of images to set image view to in loop
    private int[] diceids = {R.drawable.onedice, R.drawable.twodice, R.drawable.threedice, R.drawable.fourdice, R.drawable.fivedice,
        R.drawable.sixdice};

    // array of imageviews
    private int[] images = {R.id.TopLeft, R.id.TopRight, R.id.MiddleLeft, R.id.BottomLeft, R.id.BottomRight};

    //bool for button click
    public boolean buttonClicked = false;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        ImageView iv = (ImageView) findViewById(images[1]);



    try {
        if (buttonClicked == false) {
            for (int i = 0; i < 5; i++) {
                iv = (ImageView) findViewById(images[i]);
                iv.setImageResource(diceids[0]);
                  }
        }
    }
    catch (Exception e){;}


        //create button listener
        Button stopDice = (Button) this.findViewById(R.id.button);
        stopDice.setOnClickListener(this);
    }

            //when the button is clicked, stop the dice roll
            public void onClick(View v){

                //
                ImageView iv = (ImageView) findViewById(images[1]);
                Random rand = new Random();
                int j;

                //assigning images randomly when the dice roll button is clicked
                try {
                        for (int i = 0; i < 5; i++) {
                            j = rand.nextInt(6);
                            iv = (ImageView) findViewById(images[i]);
                            iv.setImageResource(diceids[j]);
                            try {
                                //Thread.sleep(1000);
                            }
                            catch (Exception e){;}
                        }

                }
                catch (Exception e){;}

            }

}
