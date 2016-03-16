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

import javax.security.auth.login.LoginException;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Game extends AppCompatActivity {
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
    private Fragment plansza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        mVisible = true;
        FragmentManager fragmentManager = getFragmentManager();
        plansza = new Plansza();
        fragmentManager.beginTransaction().replace(R.id.frame_holder,plansza,"plansza").commit();
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
        Plansza plansza = (Plansza) getFragmentManager().findFragmentByTag("plansza");
        figures = new Figures();
        Figures player[] =  new Figures[16];
        Figures Ai[] = new Figures[16];
        //Creating handlers for figures and preparing figures
        takeIdForFrames(player, Ai,plansza);

       /* for (int i = 0; i < 16; i++) {
            Log.i(TAG, "startGame: player "+i+" "+player[i].pion.idcurrentPos+" verse "+player[i].pion.verse+" column "+player[i].pion.column);
        }*/
        plansza.startGame(player,Ai);

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
                    Ai[it].TAG = Ai[it].pion.TAG;
                    Log.i(TAG, "takeIdForFrames: "+Ai[it].TAG);
                }else {
                    if(i == 1 || i == 8){
                        //wierza
                        Ai[it].createWierza(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                        Ai[it].TAG = Ai[it].wierza.TAG;
                        Log.i(TAG, "takeIdForFrames: " + Ai[it].TAG);
                    }else if( i == 2 || i== 7){
                        //skoczek
                        Ai[it].createSkoczek(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                        Ai[it].TAG = Ai[it].skoczek.TAG;
                        Log.i(TAG, "takeIdForFrames: " + Ai[it].TAG);
                    }else if( i == 3 || i == 6){
                        //goniec
                        Ai[it].createGoniec(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                        Ai[it].TAG = Ai[it].goniec.TAG;
                        Log.i(TAG, "takeIdForFrames: " + Ai[it].TAG);
                    }else if( i == 4 && Ai[it].playerColor ){//white true
                        //dama
                        Ai[it].createHetman(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                        Ai[it].TAG = Ai[it].hetman.TAG;
                        Log.i(TAG, "takeIdForFrames: " + Ai[it].TAG);
                        Ai[it+1].createKrol(plansza.getFigureId(i + 1, j + 1), i + 1, j + 1, Ai[it + 1].playerColor);
                        Ai[it+1].TAG = Ai[it+1].krol.TAG;
                        Log.i(TAG, "takeIdForFrames: " + Ai[it+1].TAG);
                    }else if ( i == 4 && !Ai[it].playerColor){
                        //krol
                        Ai[it].createKrol(plansza.getFigureId(i,j),i,j,Ai[it].playerColor);
                        Ai[it].TAG = Ai[it].krol.TAG;
                        Log.i(TAG, "takeIdForFrames: " + Ai[it].TAG);
                        Ai[it+1].createHetman(plansza.getFigureId(i + 1, j + 1), i + 1, j + 1, Ai[it + 1].playerColor);
                        Ai[it+1].TAG = Ai[it+1].hetman.TAG;
                        Log.i(TAG, "takeIdForFrames: " + Ai[it+1].TAG);
                    }

                }

                it++;
            }

            for (int k = 7; k < 9  ; k++) {//verse iterator

                    if(k == 8){
                        player[itt].createPion(plansza.getFigureId(i,k),i,k,player[itt].playerColor);
                        player[itt].TAG = player[itt].pion.TAG;
                        Log.i(TAG, "takeIdForFrames: " + Ai[itt].TAG);
                    }else {
                        if(i == 1 || i == 8){
                            //wierza
                            player[itt].createWierza(plansza.getFigureId(i,k),i,k,player[itt].playerColor);
                            player[itt].TAG = player[itt].wierza.TAG;
                            Log.i(TAG, "takeIdForFrames: " + Ai[itt].TAG);
                        }else if( i == 2 || i== 7){
                            //skoczek
                            player[itt].createSkoczek(plansza.getFigureId(i,k),i,k,player[itt].playerColor);
                            player[itt].TAG = player[itt].skoczek.TAG;
                            Log.i(TAG, "takeIdForFrames: " + Ai[itt].TAG);
                        }else if( i == 3 || i == 6){
                            //goniec
                            player[itt].createGoniec(plansza.getFigureId(i,k),i,k,player[itt].playerColor);
                            player[itt].TAG = player[itt].goniec.TAG;
                            Log.i(TAG, "takeIdForFrames: " + Ai[itt].TAG);
                        }else if( i == 4 && player[itt].playerColor ){//white true
                            //dama
                            player[itt].createHetman(plansza.getFigureId(i,k),i,k,player[itt].playerColor);
                            player[itt].TAG = player[itt].hetman.TAG;
                            Log.i(TAG, "takeIdForFrames: " + Ai[itt].TAG);
                            player[itt+1].createKrol(plansza.getFigureId(i + 1, k + 1), i + 1, k + 1, player[itt + 1].playerColor);
                            player[itt+1].TAG = player[itt+1].krol.TAG;
                            Log.i(TAG, "takeIdForFrames: " + Ai[itt+1].TAG);
                        }else if ( i == 4 && !player[itt].playerColor){
                            //krol
                            player[itt].createKrol(plansza.getFigureId(i,k),i,k,player[itt].playerColor);
                            player[itt].TAG = player[itt].krol.TAG;
                            Log.i(TAG, "takeIdForFrames: " + Ai[itt].TAG);
                            player[itt+1].createHetman(plansza.getFigureId(i + 1, k + 1), i + 1, k + 1, player[itt + 1].playerColor);
                            player[itt+1].TAG = player[itt+1].hetman.TAG;
                            Log.i(TAG, "takeIdForFrames: " + Ai[itt+1].TAG);
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
}
