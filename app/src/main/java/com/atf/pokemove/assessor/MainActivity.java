package com.atf.pokemove.assessor;

import android.Manifest;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.atf.pokemove.assessor.databinding.MainActivityBinding;
import com.atf.pokemove.assessor.viewmodel.MainViewModel;

import pub.devrel.easypermissions.EasyPermissions;

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
        String[] perms = {Manifest.permission.INTERNET};
        if(!EasyPermissions.hasPermissions(this, perms)) EasyPermissions.requestPermissions(this, "need internet", 123, perms);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
