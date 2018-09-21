package me.hanyuliu.livedatalost;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public abstract class BaseActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        textView = findViewById(R.id.content);
    }

    protected void append(@NonNull String string) {
        textView.append(string + "\n");
    }
}
