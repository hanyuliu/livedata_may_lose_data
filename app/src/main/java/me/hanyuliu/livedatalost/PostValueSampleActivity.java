package me.hanyuliu.livedatalost;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PostValueSampleActivity extends BaseActivity {

    private MutableLiveData<Integer> source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        source = new MutableLiveData<>();
        source.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                append(integer.toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                source.postValue(1);
                source.postValue(2);
                source.postValue(3);
            }
        });
    }
}
