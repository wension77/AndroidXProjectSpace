package com.example.viewmodeltest;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyViewModel myViewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(myViewModel.number));
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                myViewModel.number++;
                textView.setText(String.valueOf(myViewModel.number));
                break;

            case R.id.button2:
                myViewModel.number += 2;
                textView.setText(String.valueOf(myViewModel.number));
                break;
        }
    }
}
