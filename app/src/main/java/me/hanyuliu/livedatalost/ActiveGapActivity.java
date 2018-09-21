package me.hanyuliu.livedatalost;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class ActiveGapActivity extends BaseActivity {

    private MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String string) {
                System.out.println("ActiveGapActivity Observed: " + string);
            }
        });
        mutableLiveData.setValue("onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        mutableLiveData.setValue("onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        mutableLiveData.setValue("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("ActiveGapActivity onStop called");
        mutableLiveData.setValue("onStop");
    }
}
