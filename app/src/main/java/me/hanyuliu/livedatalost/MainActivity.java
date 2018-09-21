package me.hanyuliu.livedatalost;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lifecycleButton = findViewById(R.id.button_lifecycle_stage);
        lifecycleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(LifecycleSampleActivity.class);
            }
        });

        Button postValueButton = findViewById(R.id.button_post_data);
        postValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PostValueSampleActivity.class);
            }
        });

        Button setValueButton = findViewById(R.id.button_set_data);
        setValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetValueSampleActivity.class);
            }
        });

        Button transformationButton = findViewById(R.id.button_transformation);
        transformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(TransformationSampleActivity.class);
            }
        });

        Button activeStateGapButton = findViewById(R.id.button_active_gap);
        activeStateGapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ActiveGapActivity.class);
            }
        });
    }

    private void startActivity(@NonNull Class clazz) {
        startActivity(new Intent(this, clazz));
    }
}
