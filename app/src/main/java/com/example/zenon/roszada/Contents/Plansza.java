package com.example.zenon.roszada.Contents;


import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    public ImageView
            A8,B8,C8,D8,E8,F8,G8,H8,
            A7,B7,C7,D7,E7,F7,G7,H7,
            A6,B6,C6,D6,E6,F6,G6,H6,
            A5,B5,C5,D5,E5,F5,G5,H5,
            A4,B4,C4,D4,E4,F4,G4,H4,
            A3,B3,C3,D3,E3,F3,G3,H3,
            A2,B2,C2,D2,E2,F2,G2,H2,
            A1,B1,C1,D1,E1,F1,G1,H1;
    public ImageView[][] squares = new ImageView[8][8];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        content = inflater.inflate(R.layout.fragment_plansza,container,false);
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

        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"A1"); //TODO: napisac metode ktora osadzi odpowiedni jpg i sprawdzic co trzeba

            }
        });

        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"A2");
            }
        });

        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"A3");
            }
        });
        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"A4");
            }
        });
        A5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"A5");
            }
        });
        A6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"A6");
            }
        });
        A7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"A7");
            }
        });
        A8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"A8");
            }
        });
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"B1");
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"B2");
            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"B3");
            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"B4");
            }
        });
        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"B5");
            }
        });
        B6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"B6");
            }
        });
        B7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"B7");
            }
        });
        B8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"B8");
            }
        });
        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"C1");
            }
        });
        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"C2");
            }
        });
        C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"C3");
            }
        });
        C4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"C4");
            }
        });
        C5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"C5");
            }
        });
        C6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"C6");
            }
        });
        C7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"C7");
            }
        });
        C8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"C8");
            }
        });
        D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"D1");
            }
        });
        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"D2");
            }
        });
        D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"D3");
            }
        });
        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"D4");
            }
        });
        D5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"D5");
            }
        });
        D6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"D6");
            }
        });
        D7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"D7");
            }
        });
        D8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"D8");
            }
        });
        E1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"E1");
            }
        });
        E2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"E2");
            }
        });
        E3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"E3");
            }
        });
        E4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"E4");
            }
        });
        E5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"E5");
            }
        });
        E6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"E6");
            }
        });
        E7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"E7");
            }
        });
        E8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"E8");
            }
        });
        F1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"F1");
            }
        });
        F2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"F2");
            }
        });
        F3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"F3");
            }
        });
        F4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"F4");
            }
        });
        F5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"F5");
            }
        });
        F6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"F6");
            }
        });
        F7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"F7");
            }
        });
        F8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"F8");
            }
        });
        G1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"G1");
            }
        });
        G2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"G2");
            }
        });
        G3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"G3");
            }
        });
        G4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"G4");
            }
        });
        G5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"G5");
            }
        });
        G6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"G6");
            }
        });
        G7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"G7");
            }
        });
        G8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"G8");
            }
        });
        H1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"H1");
            }
        });
        H2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"H2");
            }
        });
        H3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"H3");
            }
        });
        H4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"H4");
            }
        });
        H5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"H5");
            }
        });
        H6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"H6");
            }
        });
        H7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"H7");
            }
        });
        H8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MT.show(context,"H8");
            }
        });


    }


    private void findStuff() {
        image = (ImageView) content.findViewById(R.id.plansza);

        A1 = (ImageView) content.findViewById(R.id.A1);

        A2 = (ImageView) content.findViewById(R.id.A2);
        A3 = (ImageView) content.findViewById(R.id.A3);
        A4 = (ImageView) content.findViewById(R.id.A4);
        A5 = (ImageView) content.findViewById(R.id.A5);
        A6 = (ImageView) content.findViewById(R.id.A6);
        A7 = (ImageView) content.findViewById(R.id.A7);
        A8 = (ImageView) content.findViewById(R.id.A8);
        B1 = (ImageView) content.findViewById(R.id.B1);
        B2 = (ImageView) content.findViewById(R.id.B2);
        B3 = (ImageView) content.findViewById(R.id.B3);
        B4 = (ImageView) content.findViewById(R.id.B4);
        B5 = (ImageView) content.findViewById(R.id.B5);
        B6 = (ImageView) content.findViewById(R.id.B6);
        B7 = (ImageView) content.findViewById(R.id.B7);
        B8 = (ImageView) content.findViewById(R.id.B8);
        C1 = (ImageView) content.findViewById(R.id.C1);
        C2 = (ImageView) content.findViewById(R.id.C2);
        C3 = (ImageView) content.findViewById(R.id.C3);
        C4 = (ImageView) content.findViewById(R.id.C4);
        C5 = (ImageView) content.findViewById(R.id.C5);
        C6 = (ImageView) content.findViewById(R.id.C6);
        C7 = (ImageView) content.findViewById(R.id.C7);
        C8 = (ImageView) content.findViewById(R.id.C8);
        D1 = (ImageView) content.findViewById(R.id.D1);
        D2 = (ImageView) content.findViewById(R.id.D2);
        D3 = (ImageView) content.findViewById(R.id.D3);
        D4 = (ImageView) content.findViewById(R.id.D4);
        D5 = (ImageView) content.findViewById(R.id.D5);
        D5 = (ImageView) content.findViewById(R.id.D5);
        D6 = (ImageView) content.findViewById(R.id.D6);
        D7 = (ImageView) content.findViewById(R.id.D7);
        D8 = (ImageView) content.findViewById(R.id.D8);
        E1 = (ImageView) content.findViewById(R.id.E1);
        E2 = (ImageView) content.findViewById(R.id.E2);
        E3 = (ImageView) content.findViewById(R.id.E3);
        E4 = (ImageView) content.findViewById(R.id.E4);
        E5 = (ImageView) content.findViewById(R.id.E5);
        E6 = (ImageView) content.findViewById(R.id.E6);
        E7 = (ImageView) content.findViewById(R.id.E7);
        E8 = (ImageView) content.findViewById(R.id.E8);
        F1 = (ImageView) content.findViewById(R.id.F1);
        F2 = (ImageView) content.findViewById(R.id.F2);
        F3 = (ImageView) content.findViewById(R.id.F3);
        F4 = (ImageView) content.findViewById(R.id.F4);
        F5 = (ImageView) content.findViewById(R.id.F5);
        F6 = (ImageView) content.findViewById(R.id.F6);
        F7 = (ImageView) content.findViewById(R.id.F7);
        F8 = (ImageView) content.findViewById(R.id.F8);
        G1 = (ImageView) content.findViewById(R.id.G1);
        G2 = (ImageView) content.findViewById(R.id.G2);
        G3 = (ImageView) content.findViewById(R.id.G3);
        G4 = (ImageView) content.findViewById(R.id.G4);
        G5 = (ImageView) content.findViewById(R.id.G5);
        G6 = (ImageView) content.findViewById(R.id.G6);
        G7 = (ImageView) content.findViewById(R.id.G7);
        G8 = (ImageView) content.findViewById(R.id.G8);
        H1 = (ImageView) content.findViewById(R.id.H1);
        H2 = (ImageView) content.findViewById(R.id.H2);
        H3 = (ImageView) content.findViewById(R.id.H3);
        H4 = (ImageView) content.findViewById(R.id.H4);
        H5 = (ImageView) content.findViewById(R.id.H5);
        H6 = (ImageView) content.findViewById(R.id.H6);
        H7 = (ImageView) content.findViewById(R.id.H7);
        H8 = (ImageView) content.findViewById(R.id.H8);
        A1.setAlpha(0.0f);
        A2.setAlpha(0.0f);
        A3.setAlpha(0.0f);
        A4.setAlpha(0.0f);
        A5.setAlpha(0.0f);
        A6.setAlpha(0.0f);
        A7.setAlpha(0.0f);
        A8.setAlpha(0.0f);
        B1.setAlpha(0.0f);
        B2.setAlpha(0.0f);
        B3.setAlpha(0.0f);
        B4.setAlpha(0.0f);
        B5.setAlpha(0.0f);
        B6.setAlpha(0.0f);
        B7.setAlpha(0.0f);
        B8.setAlpha(0.0f);
        C1.setAlpha(0.0f);
        C2.setAlpha(0.0f);
        C3.setAlpha(0.0f);
        C4.setAlpha(0.0f);
        C5.setAlpha(0.0f);
        C6.setAlpha(0.0f);
        C7.setAlpha(0.0f);
        C8.setAlpha(0.0f);
        D1.setAlpha(0.0f);
        D2.setAlpha(0.0f);
        D3.setAlpha(0.0f);
        D4.setAlpha(0.0f);
        D5.setAlpha(0.0f);
        D6.setAlpha(0.0f);
        D7.setAlpha(0.0f);
        D8.setAlpha(0.0f);
        E1.setAlpha(0.0f);
        E2.setAlpha(0.0f);
        E3.setAlpha(0.0f);
        E4.setAlpha(0.0f);
        E5.setAlpha(0.0f);
        E6.setAlpha(0.0f);
        E7.setAlpha(0.0f);
        E8.setAlpha(0.0f);
        F1.setAlpha(0.0f);
        F2.setAlpha(0.0f);
        F3.setAlpha(0.0f);
        F4.setAlpha(0.0f);
        F5.setAlpha(0.0f);
        F6.setAlpha(0.0f);
        F7.setAlpha(0.0f);
        F8.setAlpha(0.0f);
        G1.setAlpha(0.0f);
        G2.setAlpha(0.0f);
        G3.setAlpha(0.0f);
        G4.setAlpha(0.0f);
        G5.setAlpha(0.0f);
        G6.setAlpha(0.0f);
        G7.setAlpha(0.0f);
        G8.setAlpha(0.0f);
        H1.setAlpha(0.0f);
        H2.setAlpha(0.0f);
        H3.setAlpha(0.0f);
        H4.setAlpha(0.0f);
        H5.setAlpha(0.0f);
        H6.setAlpha(0.0f);
        H7.setAlpha(0.0f);
        H8.setAlpha(0.0f);
    }

    public void startGame(){

        /*int idA1 = A1.getId();
        content.findViewById(idA1).setBackgroundResource(R.drawable.ic_action_name);
        content.findViewById(idA1).setAlpha(1.0f);*/
        A1.setImageResource(R.drawable.ic_action_name);
        B1.setImageResource(R.drawable.ic_action_name);
        C1.setImageResource(R.drawable.ic_action_name);
        D1.setImageResource(R.drawable.ic_action_name);
        E1.setImageResource(R.drawable.ic_action_name);
        F1.setImageResource(R.drawable.ic_action_name);
        G1.setImageResource(R.drawable.ic_action_name);
        H1.setImageResource(R.drawable.ic_action_name);
        A2.setImageResource(R.drawable.ic_action_name);
        B2.setImageResource(R.drawable.ic_action_name);
        C2.setImageResource(R.drawable.ic_action_name);
        D2.setImageResource(R.drawable.ic_action_name);
        E2.setImageResource(R.drawable.ic_action_name);
        F2.setImageResource(R.drawable.ic_action_name);
        G2.setImageResource(R.drawable.ic_action_name);
        H2.setImageResource(R.drawable.ic_action_name);

        A8.setImageResource(R.drawable.ic_action_name);
        B8.setImageResource(R.drawable.ic_action_name);
        C8.setImageResource(R.drawable.ic_action_name);
        D8.setImageResource(R.drawable.ic_action_name);
        E8.setImageResource(R.drawable.ic_action_name);
        F8.setImageResource(R.drawable.ic_action_name);
        G8.setImageResource(R.drawable.ic_action_name);
        H8.setImageResource(R.drawable.ic_action_name);
        A7.setImageResource(R.drawable.ic_action_name);
        B7.setImageResource(R.drawable.ic_action_name);
        C7.setImageResource(R.drawable.ic_action_name);
        D7.setImageResource(R.drawable.ic_action_name);
        E7.setImageResource(R.drawable.ic_action_name);
        F7.setImageResource(R.drawable.ic_action_name);
        G7.setImageResource(R.drawable.ic_action_name);
        H7.setImageResource(R.drawable.ic_action_name);

        A1.setAlpha(1.0f);
        B1.setAlpha(1.0f);
        C1.setAlpha(1.0f);
        D1.setAlpha(1.0f);
        E1.setAlpha(1.0f);
        F1.setAlpha(1.0f);
        G1.setAlpha(1.0f);
        H1.setAlpha(1.0f);
        A2.setAlpha(1.0f);
        B2.setAlpha(1.0f);
        C2.setAlpha(1.0f);
        D2.setAlpha(1.0f);
        E2.setAlpha(1.0f);
        F2.setAlpha(1.0f);
        G2.setAlpha(1.0f);
        H2.setAlpha(1.0f);

        A8.setAlpha(1.0f);
        B8.setAlpha(1.0f);
        C8.setAlpha(1.0f);
        D8.setAlpha(1.0f);
        E8.setAlpha(1.0f);
        F8.setAlpha(1.0f);
        G8.setAlpha(1.0f);
        H8.setAlpha(1.0f);
        A7.setAlpha(1.0f);
        B7.setAlpha(1.0f);
        C7.setAlpha(1.0f);
        D7.setAlpha(1.0f);
        E7.setAlpha(1.0f);
        F7.setAlpha(1.0f);
        G7.setAlpha(1.0f);
        H7.setAlpha(1.0f);

    }
    public void showPlace(int id){

        content.findViewById(id).setAlpha(1.0f);

    }

    public void replacePlaces(int currentPos,int destinationPos){

        content.findViewById(destinationPos).setBackgroundResource(currentPos);

    }

}
