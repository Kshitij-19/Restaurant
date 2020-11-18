package com.example.res_t2.ui.Restaurant;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RestaurantViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RestaurantViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Resturant fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}