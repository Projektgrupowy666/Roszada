package com.example.zenon.roszada.Contents;


import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zenon.roszada.Chess.Figures;
import com.example.zenon.roszada.R;
import com.example.zenon.roszada.Utility.MT;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Plansza extends android.app.Fragment  {




    public Plansza() {
        // Required empty public constructor
    }

    private View content;
    private ImageView image;
    private Context context;
  /*  public ImageView
            A8,B8,C8,D8,E8,F8,G8,H8,
            A7,B7,C7,D7,E7,F7,G7,H7,
            A6,B6,C6,D6,E6,F6,G6,H6,
            A5,B5,C5,D5,E5,F5,G5,H5,
            A4,B4,C4,D4,E4,F4,G4,H4,
            A3,B3,C3,D3,E3,F3,G3,H3,
            A2,B2,C2,D2,E2,F2,G2,H2,
            A1,B1,C1,D1,E1,F1,G1,H1;*/
    public ImageView[][] squares = new ImageView[9][9];//indeksowana od 1
    private int[][] idviews = new int[9][9];//id pol na szachownicy
    public int firstclick=0;
    public int secondclick=0;
    private String TAG="pl";
    private PlaneWosCliced planeWosCliced;
    public interface PlaneWosCliced{
        void onPlaneClick(int plandeId);
    }

    public void setOnPlaneClick(PlaneWosCliced planeClick){
        planeWosCliced = planeClick;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            content = inflater.inflate(R.layout.fragment_plansza_lower_api,container,false);
        }else{
            content = inflater.inflate(R.layout.fragment_plansza,container,false);
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context = getContext();
        }else {
            context  = content.getContext();
        }
        findStuff();
        setClickView();

        return content;
    }

    private void setClickView() {

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                squares[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //send info to game class that that button wos cliked ;p
                        int id = v.getId();
                        //MT.show(context,String.valueOf(id)+" "+v);
                        planeWosCliced.onPlaneClick(id);

                    }
                });
            }
        }
    }


    private void findStuff() {
        image = (ImageView) content.findViewById(R.id.plansza);

        findViews();

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                squares[i][j] = (ImageView) content.findViewById(idviews[i][j]);
                squares[i][j].setAlpha(0.0f);
            }
        }

    }

    private void findViews() {
    //tutaj da sie jeszcze to zrefaktoryzowac ;p
        idviews[1][1] = R.id.A8;
        idviews[1][2] = R.id.B8;
        idviews[1][3] = R.id.C8;
        idviews[1][4] = R.id.D8;
        idviews[1][5] = R.id.E8;
        idviews[1][6] = R.id.F8;
        idviews[1][7] = R.id.G8;
        idviews[1][8] = R.id.H8;
        idviews[2][1] = R.id.A7;
        idviews[2][2] = R.id.B7;
        idviews[2][3] = R.id.C7;
        idviews[2][4] = R.id.D7;
        idviews[2][5] = R.id.E7;
        idviews[2][6] = R.id.F7;
        idviews[2][7] = R.id.G7;
        idviews[2][8] = R.id.H7;
        idviews[3][1] = R.id.A6;
        idviews[3][2] = R.id.B6;
        idviews[3][3] = R.id.C6;
        idviews[3][4] = R.id.D6;
        idviews[3][5] = R.id.E6;
        idviews[3][6] = R.id.F6;
        idviews[3][7] = R.id.G6;
        idviews[3][8] = R.id.H6;
        idviews[4][1] = R.id.A5;
        idviews[4][2] = R.id.B5;
        idviews[4][3] = R.id.C5;
        idviews[4][4] = R.id.D5;
        idviews[4][5] = R.id.E5;
        idviews[4][6] = R.id.F5;
        idviews[4][7] = R.id.G5;
        idviews[4][8] = R.id.H5;
        idviews[5][1] = R.id.A4;
        idviews[5][2] = R.id.B4;
        idviews[5][3] = R.id.C4;
        idviews[5][4] = R.id.D4;
        idviews[5][5] = R.id.E4;
        idviews[5][6] = R.id.F4;
        idviews[5][7] = R.id.G4;
        idviews[5][8] = R.id.H4;
        idviews[6][1] = R.id.A3;
        idviews[6][2] = R.id.B3;
        idviews[6][3] = R.id.C3;
        idviews[6][4] = R.id.D3;
        idviews[6][5] = R.id.E3;
        idviews[6][6] = R.id.F3;
        idviews[6][7] = R.id.G3;
        idviews[6][8] = R.id.H3;
        idviews[7][1] = R.id.A2;
        idviews[7][2] = R.id.B2;
        idviews[7][3] = R.id.C2;
        idviews[7][4] = R.id.D2;
        idviews[7][5] = R.id.E2;
        idviews[7][6] = R.id.F2;
        idviews[7][7] = R.id.G2;
        idviews[7][8] = R.id.H2;
        idviews[8][1] = R.id.A1;
        idviews[8][2] = R.id.B1;
        idviews[8][3] = R.id.C1;
        idviews[8][4] = R.id.D1;
        idviews[8][5] = R.id.E1;
        idviews[8][6] = R.id.F1;
        idviews[8][7] = R.id.G1;
        idviews[8][8] = R.id.H1;
    }

    public void startGame(Figures[] player,Figures[] Ai){

        /*int idA1 = A1.getId();
        content.findViewById(idA1).setBackgroundResource(R.drawable.ic_action_name);
        content.findViewById(idA1).setAlpha(1.0f);*/
        for (int i = 1; i <= 2 ; i++) {
            for (int j = 1; j < 9; j++) {
                squares[i][j].setAlpha(1.0f);
            }
        }

        for (int i = 7; i <= 8 ; i++) {
            for (int j = 1; j < 9; j++) {
                squares[i][j].setAlpha(1.0f);
            }
        }

    }

    public void showPlace(int id){

        content.findViewById(id).setAlpha(1.0f);

    }

    public void hidePlace(int id){

        content.findViewById(id).setAlpha(0.0f);

    }

    public void replacePlaces(int currentPos,int destinationPos){

        content.findViewById(destinationPos).setBackgroundResource(currentPos);

    }
    public int getFigureId(int column, int verse){
        return squares[verse][column].getId();
    }
}
