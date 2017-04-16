package com.atf.pokemove.assessor;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.atf.pokemove.assessor.databinding.MainActivityBinding;
import com.atf.pokemove.assessor.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainActivityBinding binding;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        viewModel = new MainViewModel(this);
        binding.setViewModel(viewModel);
        setSupportActionBar(binding.toolbar);
    }
}
