package com.example.a2020infiniterecharge;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class AutoActivity extends AppCompatActivity {

    private RadioGroup cross;
    public int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        final TextView counttime=findViewById(R.id.counttime);

        new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                counttime.setText("Time Left: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                counttime.setText("Finished");
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.container);
                bgElement.setBackgroundColor(getResources().getColor(R.color.changecolor));
            }

        }.start();

        final Counter aInnerPortScore = findViewById(R.id.acounterInnerPort);
        final Counter aOuterPortScore = findViewById(R.id.acounterOuterPort);
        final Counter aBottomPortScore = findViewById(R.id.acounterBottomPort);
        final Counter aGroundCollect = findViewById(R.id.acounterGroundCollect);
        final Counter aLoadingBayCollect = findViewById(R.id.aBayCollect);
        final Counter aMissed = findViewById(R.id.acounterMissed);


        Button startButton = findViewById(R.id.buttonNext);

        startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cross = findViewById(R.id.initiationGroup);
                    int selected = cross.getCheckedRadioButtonId();
                    final RadioButton selectedCrossButton = findViewById(selected);
                    String crossed = selectedCrossButton.getText().toString();

                    Bundle bundleAuto = new Bundle();
                    bundleAuto.putInt("aInnerPortScore", aInnerPortScore.getValue());
                    bundleAuto.putInt("aOuterPortScore", aOuterPortScore.getValue());
                    bundleAuto.putInt("aBottomPortScore", aBottomPortScore.getValue());
                    bundleAuto.putInt("aGroundCollect", aGroundCollect.getValue());
                    bundleAuto.putInt("aLoadingBayCollect", aLoadingBayCollect.getValue());
                    bundleAuto.putInt("aMissed", aMissed.getValue());
                    bundleAuto.putString("crossed", crossed);

                    Bundle bundleMain = getIntent().getExtras();

                    Intent intentAuto = new Intent(AutoActivity.this, TeleopActivity.class);
                    intentAuto.putExtras(bundleAuto);
                    intentAuto.putExtras(bundleMain);
                    startActivity(intentAuto);
                }
            });
        }

}

