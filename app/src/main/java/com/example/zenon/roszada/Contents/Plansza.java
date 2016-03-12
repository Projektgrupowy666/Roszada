package com.example.zenon.roszada.Contents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zenon.roszada.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Plansza extends Fragment {


    public Plansza() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plansza, container, false);
    }

}
