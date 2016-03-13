package com.example.zenon.roszada.Utility;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Zenon on 13.03.2016.
 */
public class MT {
  static  public void show(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
