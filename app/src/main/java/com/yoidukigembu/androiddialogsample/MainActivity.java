package com.yoidukigembu.androiddialogsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.dialogButton);
        button.setOnClickListener(buttonClickedListener);
    }

    private View.OnClickListener buttonClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final SampleDialog dialog = new SampleDialog();
            dialog.setOnOkClickedListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("MainActivity", "OK pressed");
                }
            });

            dialog.setOnCancelClickedListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("MainActivity", "cancel pressed");
                }
            });


            dialog.show(getSupportFragmentManager(), SampleDialog.class.getName());
        }
    };

}
