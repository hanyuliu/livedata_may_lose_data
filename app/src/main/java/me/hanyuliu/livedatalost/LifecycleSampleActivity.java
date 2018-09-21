package me.hanyuliu.livedatalost;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LifecycleSampleActivity extends BaseActivity {

    private MutableLiveData<String> source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        source = new MutableLiveData<>();
        source.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String text) {
                append(text);
            }
        });

        source.setValue("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        source.setValue("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        source.setValue("onResume");
    }
}
