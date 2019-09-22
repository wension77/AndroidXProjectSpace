package com.example.livedatatest;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    ViewModelWithLiveData viewModelWithLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.text_view);

        viewModelWithLiveData = ViewModelProviders.of(this).get(ViewModelWithLiveData.class);

        viewModelWithLiveData.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });

        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelWithLiveData.addLikeNumber(1);
            }
        });

        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelWithLiveData.addLikeNumber(-1);
            }

        });
    }
}
