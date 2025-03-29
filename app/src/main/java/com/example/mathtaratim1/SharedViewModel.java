package com.example.mathtaratim1;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> savedData = new MutableLiveData<>();

    public void setSavedData(String data) {
        savedData.setValue(data);
    }

    public LiveData<String> getSavedData() {
        return savedData;
    }
}
