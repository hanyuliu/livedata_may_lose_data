package me.hanyuliu.livedatalost;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class TransformationSampleActivity extends BaseActivity {

    private MutableLiveData<Integer> source;
    private LiveData<Integer> tail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        source = new MutableLiveData<>();
        tail = Transformations.map(source, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                if (input == 2) {
                    source.setValue(7);
                    source.setValue(8);
                }
                return input * 10;
            }
        });

        tail.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                append(integer.toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        source.setValue(1);
        source.setValue(2);
        source.setValue(3);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                source.postValue(10);
                source.postValue(20);
                source.postValue(30);
            }
        });
    }
}
