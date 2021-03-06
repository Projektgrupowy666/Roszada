package com.example.zenon.roszada.Chess;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import com.example.zenon.roszada.Contents.Plansza;
import com.example.zenon.roszada.R;
import com.example.zenon.roszada.Utility.MT;

import org.json.JSONObject;

import javax.security.auth.login.LoginException;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Game extends AppCompatActivity implements Plansza.PlaneWosCliced{
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private static final String TAG = "GAME";
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
           // mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };
    private Figures figures;
    private Fragment fragmentplansza;
    private Figures player[];
    private Figures Ai[];
    private Plansza plansza;
    private boolean firstClick = false;
    private int idForFirstClick=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        mVisible = true;
        FragmentManager fragmentManager = getFragmentManager();
        fragmentplansza = new Plansza();
        fragmentManager.beginTransaction().replace(R.id.frame_holder,fragmentplansza,"plansza").commit();
       // mControlsView = findViewById(R.id.plansza);
        mContentView = findViewById(R.id.content_plansza);

         //Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
      //  findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);

    }

    private void startGame() {
        plansza = (Plansza) getFragmentManager().findFragmentByTag("plansza");
        figures = new Figures();
        plansza.setOnPlaneClick(this);
        player =  new Figures[16];
        Ai = new Figures[16];
        //Creating handlers for figures and preparing figures
        takeIdForFrames(player, Ai, plansza);

       /* for (int i = 0; i < 16; i++) {
            Log.i(TAG, "startGame: player "+i+" "+player[i].pion.idcurrentPos+" verse "+player[i].pion.verse+" column "+player[i].pion.column);
        }*/
        plansza.startGame(player, Ai);

    }

    private void takeIdForFrames(Figures[] player, Figures[] Ai,Plansza plansza) {

        for (int i = 0; i < 16; i++) {
            player[i] = new Figures(this,true,true);
            Ai[i] = new Figures(this,false,false);
        }
        //setting images and other stuffs from class Plansza to handlers
        int it = 0, itt=0;
        for (int i = 1; i < 9 ; i++) {//columns iterator

            for (int j = 1 ; j < 3 ; j++) {//verse iterator
                if(j == 2){
                    Ai[it].createPion(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                    Ai[it].TAG = Figures.Pion.TAG;
                    Log.i(TAG, "takeIdForFrames: pion "+"i: "+i+"j:"+j+Ai[it].TAG+" id: "+Ai[it].planeId);
                }else {
                    if(i == 1 || i == 8){
                        //wierza
                        Ai[it].createWierza(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                        Ai[it].TAG = Figures.Wierza.TAG;
                        Log.i(TAG, "takeIdForFrames: wierza "+"i: "+i+"j:"+j + Ai[it].TAG+" id: "+Ai[it].planeId);
                    }else if( i == 2 || i== 7){
                        //skoczek
                        Ai[it].createSkoczek(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                        Ai[it].TAG = Figures.Skoczek.TAG;
                        Log.i(TAG, "takeIdForFrames: skoczek "+"i: "+i+"j:"+j + Ai[it].TAG+" id: "+Ai[it].planeId);
                    }else if( i == 3 || i == 6){
                        //goniec
                        Ai[it].createGoniec(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                        Ai[it].TAG = Figures.Goniec.TAG;
                        Log.i(TAG, "takeIdForFrames: goniec "+"i: "+i+"j:"+j + Ai[it].TAG+" id: "+Ai[it].planeId);
                    }else if( i == 4 ){//white true
                        //dama
                        if(Ai[it].playerColor){
                            Ai[it].createKrol(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                            Ai[it].TAG = Figures.Krol.TAG;
                            Log.i(TAG, "takeIdForFrames: krol " + "i: " + i + "j:" + j + Ai[it].TAG + " id: " + Ai[it].planeId);
                        }else {
                            Ai[it].createHetman(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                            Ai[it].TAG = Figures.Hetman.TAG;
                            Log.i(TAG, "takeIdForFrames: hetman " + "i: " + i + "j:" + j + Ai[it].TAG + " id: " + Ai[it].planeId);
                        }

                    }else if ( i == 5){
                        //krol
                        if(Ai[it].playerColor){
                            Ai[it].createHetman(plansza.getFigureId(i, j), i, j, Ai[it].playerColor);
                            Ai[it].TAG = Figures.Hetman.TAG;
                            Log.i(TAG, "takeIdForFrames: hetman " + "i: " + i + 1 + "j:" + j + Ai[it].TAG + " id: " + Ai[it].planeId);
                        }else {
                            Ai[it].createKrol(plansza.getFigureId(i, j), i, j, Ai[it].playerColor);
                            Ai[it].TAG = Figures.Krol.TAG;
                            Log.i(TAG, "takeIdForFrames: krol " + "i: " + i + 1 + "j:" + j + Ai[it].TAG + " id: " + Ai[it].planeId);
                        }

                    }

                }

                it++;
            }

            for (int k = 7; k < 9  ; k++) {//verse iterator

                    if(k == 7){
                        player[itt].createPion(plansza.getFigureId(i,k),i,k,player[itt].playerColor);
                        player[itt].TAG = Figures.Pion.TAG;
                        Log.i(TAG, "takeIdForFrames: " + Ai[itt].TAG);
                    }else {
                        if (i == 1 || i == 8) {
                            //wierza
                            player[itt].createWierza(plansza.getFigureId(i, k), i, k, player[itt].playerColor);
                            player[itt].TAG = Figures.Wierza.TAG;
                            Log.i(TAG, "takeIdForFrames: " + Ai[itt].TAG);
                        } else if (i == 2 || i == 7) {
                            //skoczek
                            player[itt].createSkoczek(plansza.getFigureId(i, k), i, k, player[itt].playerColor);
                            player[itt].TAG = Figures.Skoczek.TAG;
                            Log.i(TAG, "takeIdForFrames: " + Ai[itt].TAG);
                        } else if (i == 3 || i == 6) {
                            //goniec
                            player[itt].createGoniec(plansza.getFigureId(i, k), i, k, player[itt].playerColor);
                            player[itt].TAG = Figures.Goniec.TAG;
                            Log.i(TAG, "takeIdForFrames: " + Ai[itt].TAG);
                        } else if (i == 4) {//white true
                            //dama
                            if (player[itt].playerColor) {
                                player[itt].createHetman(plansza.getFigureId(i, k), i, k, player[itt].playerColor);
                                player[itt].TAG = Figures.Hetman.TAG;
                                Log.i(TAG, "takeIdForFrames: hetman " + "i: " + i + "j:" + k + player[itt].TAG + " id: " + player[itt].planeId);
                            } else {
                                player[itt].createKrol(plansza.getFigureId(i, k), i, k, player[itt].playerColor);
                                player[itt].TAG = Figures.Krol.TAG;
                                Log.i(TAG, "takeIdForFrames: krol " + "i: " + i + "j:" + k + player[itt].TAG + " id: " + player[itt].planeId);
                            }

                        } else if (i == 5) {
                            //krol
                            if (player[itt].playerColor) {
                                player[itt].createKrol(plansza.getFigureId(i, k), i, k, player[itt].playerColor);
                                player[itt].TAG = Figures.Krol.TAG;
                                Log.i(TAG, "takeIdForFrames: krol " + "i: " + i + 1 + "j:" + k + player[itt].TAG + " id: " + player[itt].planeId);
                            } else {
                                player[itt].createHetman(plansza.getFigureId(i, k), i, k, player[itt].playerColor);
                                player[itt].TAG = Figures.Hetman.TAG;
                                Log.i(TAG, "takeIdForFrames: hetman " + "i: " + i + 1 + "j:" + k + player[itt].TAG + " id: " + player[itt].planeId);
                            }

                        }
                    }

                itt++;
            }
        }

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
        startGame();
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
       // mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    @Override
    public void onPlaneClick(int plandeId) {
       // MT.show(this, String.valueOf(plandeId));
        //TODO:// create a method that find the correct plane in players handler from id passing from Plansza class.
        // player,Ai,id ==> 0 false 1 true , number od id
        int request[] = findFigureById(plandeId);
        if(request[0] == 1 /*&& request[2] > 0*/){

            if(player[request[2]].click){
                player[request[2]].click = false;
                firstClick = false;
            }else {
                player[request[2]].click = true;
                firstClick = true;
                idForFirstClick = plandeId;
            }
            MT.show(this, String.valueOf(plandeId)+" "+player[request[2]].TAG+" "+player[request[2]].playerColor);
        }else if(request[1] == 1 /*&& request[2] >0*/){
            if(Ai[request[2]].click){
                Ai[request[2]].click = false;
                firstClick = false;
            }else {
                Ai[request[2]].click = true;
                firstClick = true;
                idForFirstClick = plandeId;
            }
            MT.show(this, String.valueOf(plandeId)+" "+Ai[request[2]].TAG+" "+Ai[request[2]].playerColor);
        }else {
            MT.show(this, String.valueOf(plandeId)+" empty plane wos clicked ");
            if(firstClick){
                makeMove(idForFirstClick,plandeId);
            }
        }
    }

    private void makeMove(int idForFirstClick, int plandeId) {
        //check is that move is correct first then make this:
        plansza.replacePlaces(idForFirstClick, plandeId);
    }

    private int[] findFigureById(int plandeId) {
        int ret[] = new int[3];
        ret[0] = 0;
        ret[1] = 0;
        ret[2] = -1;
        for (int i = 0; i < 16; i++) {
            if(player[i].planeId == plandeId){
                ret[0] = 1;
                ret[1] = 0;
                ret[2] = i;
                Log.i(TAG, "findFigureById: player"+plandeId);
                break;
            }else if(Ai[i].planeId == plandeId){
                ret[0] = 0;
                ret[1] = 1;
                ret[2] = i;
                Log.i(TAG, "findFigureById: Ai"+plandeId);
                break;
            }
        }
            return ret ;
    }


}
