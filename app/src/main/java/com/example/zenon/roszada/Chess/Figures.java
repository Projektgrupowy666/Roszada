package com.example.zenon.roszada.Chess;

import android.content.Context;

import com.example.zenon.roszada.R;

/**
 * Created by Zenon on 13.03.2016.
 * Klasa opisuje figury i ich atrybuty
 */
public class Figures {

    private Context context;
    public boolean playerColor; //true-white false-black

    Figures(Context context,boolean color){
        this.context = context;
        playerColor = color;
    }

    class White{

        int pionimg = R.drawable.ic_action_name;

        final public int getPionimg() {
            return pionimg;
        }
    }

    class Black{

    }

    class Pion{
        int imageWhite = R.drawable.ic_action_name;
        int imageBlack = R.drawable.ic_action_name;
        int currentPos[][] = new int[0][0]; //0 nie istnieje pozycja = id imageview
        int moveAble = 1;//ilepol moze sie ruszyc
        boolean moveFront = true;
        boolean moveSides = false;
        boolean moveBack = false;
        boolean moveDiagonal = true;

        void initialize(int x, int y){

        }

    }
}
