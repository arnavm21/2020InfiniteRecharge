package com.example.a2020infiniterecharge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class TeleopActivity extends AppCompatActivity {

    private CheckBox rc;
    private CheckBox pc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);

        final Counter tInnerPortScore = findViewById(R.id.tcounterInnerPort);
        final Counter tOuterPortScore = findViewById(R.id.tcounterOuterPort);
        final Counter tBottomPortScore = findViewById(R.id.tcounterBottomPort);
        final Counter tGroundCollect = findViewById(R.id.tcounterGroundCollect);
        final Counter tBayCollect = findViewById(R.id.tcounterBayCollect);
        final Counter tMissed = findViewById(R.id.tcounterMissed);


        Button startButton = findViewById(R.id.buttonToEnd);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rc = findViewById(R.id.rotationControl);
                boolean selectedRC = rc.isChecked();

                pc = findViewById(R.id.positionControl);
                boolean selectedPC = pc.isChecked();

                Bundle bundleTeleop = new Bundle();
                bundleTeleop.putInt("tInnerPortScore", tInnerPortScore.getValue());
                bundleTeleop.putInt("tOuterPortScore", tOuterPortScore.getValue());
                bundleTeleop.putInt("tBottomPortScore", tBottomPortScore.getValue());
                bundleTeleop.putInt("tGroundCollect", tGroundCollect.getValue());
                bundleTeleop.putInt("tBayCollect", tBayCollect.getValue());
                bundleTeleop.putInt("tMissed", tMissed.getValue());
                bundleTeleop.putBoolean("RotationControl", selectedRC);
                bundleTeleop.putBoolean("PositionControl", selectedPC);

                Bundle bundleMain = getIntent().getExtras();
                Bundle bundleAuto = getIntent().getExtras();

                Intent intentAuto = new Intent(TeleopActivity.this, EndActivity.class);
                intentAuto.putExtras(bundleAuto);
                intentAuto.putExtras(bundleMain);
                intentAuto.putExtras(bundleTeleop);
                startActivity(intentAuto);
            }
        });


    }
}
