package com.example.databindingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.example.databindingtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        //        setContentView(R.layout.activity_main);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
//        myViewModel.getNumber().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                binding.textview.setText(String.valueOf(integer));
//            }
//        });
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myViewModel.add();
//            }
//        });



    }
}
