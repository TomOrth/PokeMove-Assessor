package com.atf.pokemove.assessor.viewmodel;

import android.content.Context;

/**
 * Created by tom on 4/15/17.
 */

public class MainViewModel implements ViewModel {
    Context context;
    public MainViewModel(Context context){
        this.context = context;
    }

    @Override
    public void onDestroy() {

    }
}
