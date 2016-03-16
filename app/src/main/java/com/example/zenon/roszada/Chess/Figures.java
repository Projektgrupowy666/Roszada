package com.example.zenon.roszada.Chess;

import android.content.Context;
import android.view.View;

import com.example.zenon.roszada.R;

/**
 * Created by Zenon on 13.03.2016.
 * Klasa opisuje figury i ich atrybuty
 */
public class Figures {

    private Context context;
    public boolean playerColor; //true-white false-black
    public boolean player = true;//grasz true AI false
    public boolean exist = false;//is figure exist on plane
    public Pion pion;

    Figures(){

    }

    Figures(Context context,boolean color,boolean player){
        this.context = context;
        playerColor = color;
        this.player = player;
    }

    public void createPion(int id,int column,int verse,boolean color){
        pion = new Pion(id,column,verse,color);
    }

    public class Pion{
        public static final int imageWhite = R.drawable.ic_action_name;
        public static final int imageBlack = R.drawable.ic_action_name;
        public int idcurrentPos = 0; //0 nie istnieje pozycja = id imageview
        public int column = 0;
        public int verse = 0;
        public static final int moveAble = 1;//ilepol moze sie ruszyc
        public static final boolean moveFront = true;
        public static final boolean moveSides = false;
        public static final boolean moveBack = false;
        public static final boolean moveDiagonal = true;
        private boolean Color;//true bialy black czarny

      public boolean getColor() {
          return Color;
      }

      Pion(int id,int column,int verse,boolean color){

            idcurrentPos = id;
            this.column = column;
            this.verse = verse;
            Color=color;

        }
        public void changePos(int newId,int newColumn,int newVerse){
            idcurrentPos=newId;
            column=newColumn;
            verse=newVerse;

        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }

    public class Wierza {

        public static final int imageWhite = R.drawable.ic_action_name;
        public static final int imageBlack = R.drawable.ic_action_name;
        public int idcurrentPos = 0; //0 nie istnieje pozycja = id imageview
        public int column = 0;
        public int verse = 0;
        public static final int moveAble = 10;//ilepol moze sie ruszyc
        public static final boolean moveFront = true;
        public static final boolean moveSides = true;
        public static final boolean moveBack = true;
        public static final boolean moveDiagonal = false;
        private boolean Color;//true bialy black czarny

        public boolean getColor() {
            return Color;
        }

        Wierza(int id,int column,int verse,boolean color){

            idcurrentPos = id;
            this.column = column;
            this.verse = verse;
            Color=color;

        }
        public void changePos(int newId,int newColumn,int newVerse){
            idcurrentPos=newId;
            column=newColumn;
            verse=newVerse;

        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }

    }

    public class Skoczek{
        public static final int imageWhite = R.drawable.ic_action_name;
        public static final int imageBlack = R.drawable.ic_action_name;
        public int idcurrentPos = 0; //0 nie istnieje pozycja = id imageview
        public int column = 0;
        public int verse = 0;
        public static final int moveAble = -1;//ilepol moze sie ruszyc
        public static final boolean moveFront = false;
        public static final boolean moveSides = false;
        public static final boolean moveBack = false;
        public static final boolean moveDiagonal = false;
        private boolean Color;//true bialy black czarny

        public boolean getColor() {
            return Color;
        }

        Skoczek(int id,int column,int verse,boolean color){

            idcurrentPos = id;
            this.column = column;
            this.verse = verse;
            Color=color;

        }
        public void changePos(int newId,int newColumn,int newVerse){
            idcurrentPos=newId;
            column=newColumn;
            verse=newVerse;

        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }

    public class Goniec{
        public static final int imageWhite = R.drawable.ic_action_name;
        public static final int imageBlack = R.drawable.ic_action_name;
        public int idcurrentPos = 0; //0 nie istnieje pozycja = id imageview
        public int column = 0;
        public int verse = 0;
        public static final int moveAble = 10;//ilepol moze sie ruszyc
        public static final boolean moveFront = false;
        public static final boolean moveSides = false;
        public static final boolean moveBack = true;
        public static final boolean moveDiagonal = true;
        private boolean Color;//true bialy black czarny

        public boolean getColor() {
            return Color;
        }

        Goniec(int id,int column,int verse,boolean color){

            idcurrentPos = id;
            this.column = column;
            this.verse = verse;
            Color=color;

        }
        public void changePos(int newId,int newColumn,int newVerse){
            idcurrentPos=newId;
            column=newColumn;
            verse=newVerse;

        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }

    public class Hetman{
        public static final int imageWhite = R.drawable.ic_action_name;
        public static final int imageBlack = R.drawable.ic_action_name;
        public int idcurrentPos = 0; //0 nie istnieje pozycja = id imageview
        public int column = 0;
        public int verse = 0;
        public static final int moveAble = 10;//ilepol moze sie ruszyc
        public static final boolean moveFront = true;
        public static final boolean moveSides = true;
        public static final boolean moveBack = true;
        public static final boolean moveDiagonal = true;
        private boolean Color;//true bialy black czarny

        public boolean getColor() {
            return Color;
        }

        Hetman(int id,int column,int verse,boolean color){

            idcurrentPos = id;
            this.column = column;
            this.verse = verse;
            Color=color;

        }
        public void changePos(int newId,int newColumn,int newVerse){
            idcurrentPos=newId;
            column=newColumn;
            verse=newVerse;

        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }

    public class Krol{
        public static final int imageWhite = R.drawable.ic_action_name;
        public static final int imageBlack = R.drawable.ic_action_name;
        public int idcurrentPos = 0; //0 nie istnieje pozycja = id imageview
        public int column = 0;
        public int verse = 0;
        public static final int moveAble = 1;//ilepol moze sie ruszyc
        public static final boolean moveFront = true;
        public static final boolean moveSides = true;
        public static final boolean moveBack = true;
        public static final boolean moveDiagonal = true;
        private boolean Color;//true bialy black czarny

        public boolean getColor() {
            return Color;
        }

        Krol(int id,int column,int verse,boolean color){

            idcurrentPos = id;
            this.column = column;
            this.verse = verse;
            Color=color;

        }
        public void changePos(int newId,int newColumn,int newVerse){
            idcurrentPos=newId;
            column=newColumn;
            verse=newVerse;

        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }

}
