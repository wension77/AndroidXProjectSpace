package com.example.livedatatest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * desc  :
 * author: winsion
 * date  : 2019/9/22 16:24
 */
public class ViewModelWithLiveData extends ViewModel {

    private MutableLiveData<Integer> LikedNumber;

    public MutableLiveData<Integer> getLikedNumber(){
        if (LikedNumber == null){
            LikedNumber = new MutableLiveData<>();
            LikedNumber.setValue(0);
        }
        return LikedNumber;
    }

    public void addLikeNumber(int n){
        LikedNumber.setValue(LikedNumber.getValue() + n);
    }

}
