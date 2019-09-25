package com.winsion.navdemo3;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * author: hewensheng
 * date  : 2019/9/25 10:06
 * desc  :
 */
public class MyViewModel extends ViewModel {
    public MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if (number == null){
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void add(int x){
        number.setValue(number.getValue() + x);
        if (number.getValue() < 0){
            number.setValue(0);
        }
    }

}
