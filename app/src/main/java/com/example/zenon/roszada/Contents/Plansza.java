package com.example.zenon.roszada.Contents;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zenon.roszada.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Plansza extends android.app.Fragment {


    public Plansza() {
        // Required empty public constructor
    }
    private View content;
    private ImageView image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        content = inflater.inflate(R.layout.fragment_plansza,container,false);
        findStuff();
        return content;
    }

    private void findStuff() {
        image = (ImageView) content.findViewById(R.id.plansza);
    }

}
