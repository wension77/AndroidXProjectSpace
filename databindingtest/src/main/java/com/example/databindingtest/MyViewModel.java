package com.example.databindingtest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * desc  :
 * author: winsion
 * date  : 2019/9/22 22:54
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void add() {
        number.setValue(number.getValue() + 1);
    }
}
