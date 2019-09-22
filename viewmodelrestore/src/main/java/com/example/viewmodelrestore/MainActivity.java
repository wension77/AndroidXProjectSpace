package com.example.viewmodelrestore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;

import com.example.viewmodelrestore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;
    public final static String KEY_NUMBER = "my_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel = ViewModelProviders.of(this,new SavedStateVMFactory(this)).get(MyViewModel.class);
//        if (savedInstanceState != null){
//            myViewModel.getNumber().setValue(savedInstanceState.getInt(KEY_NUMBER));
//        }
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_NUMBER,myViewModel.getNumber().getValue());
//    }

}
