package com.example.zenon.roszada;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.zenon.roszada.Chess.Game;
import com.example.zenon.roszada.Utility.Setting;

//  TRZYMAMY POZADEK!!!!
// AI - sztuczna inteligencja
// Chess - wszystko co jest zwiazane z szachami ruchy itp idt
//Contents - wszystkie View
//Utility - wszystkie uzyteczne i pomocne klasy :)
public class MainActivity extends AppCompatActivity {

    private Button newgame,loadgame;
    private Context context;
    private Snackbar snackbar;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 snackbar =  Snackbar.make(view, "Projekt grupowy made by Karina Koprowska, Łukasz Rumiński, " +
                            "Kamil Ślęczkowski.", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Action", null);
                    snackbar.show();
                }
            });
        }
        findStuff();
        setStuff();
    }

    private void setStuff() {
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Game.class);
                startActivity(intent);
            }
        });
        loadgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(snackbar.isShown()){
                    snackbar.dismiss();
                }
            }
        });
    }

    private void findStuff() {
        newgame = (Button) findViewById(R.id.bt_new_game);
        loadgame = (Button) findViewById(R.id.bt_load_game);
        view = findViewById(R.id.main_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            Intent intent = new Intent(context, Setting.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
