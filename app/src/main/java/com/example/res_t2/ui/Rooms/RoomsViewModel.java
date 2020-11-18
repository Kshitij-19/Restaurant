package com.example.res_t2.ui.Rooms;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RoomsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RoomsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Rooms fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}