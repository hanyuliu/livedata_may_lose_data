package me.hanyuliu.livedatalost;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SetValueSampleActivity extends BaseActivity {

    private MutableLiveData<Integer> source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        source = new MutableLiveData<>();

        source.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                append("Receiver 1: " + integer.toString());
                if (integer % 2 == 0) {
                    source.setValue(integer * 10);
                    source.setValue(integer * 10 + 1);
                }
            }
        });
        source.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                append("Receiver 2: " + integer.toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        source.setValue(1);
        source.setValue(2);
        source.setValue(3);
    }
}
