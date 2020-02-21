package com.example.a2020infiniterecharge;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {

    private RadioGroup endgame;
    private RadioGroup defense;
    private RadioGroup broken;
    private RadioGroup stuck;
    private String tablet = new String("red_1");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        final Bundle bundleTeleop = getIntent().getExtras();

        final Bundle bundleAuto = getIntent().getExtras();

        final Bundle bundleMain = getIntent().getExtras();

        Button noShow = findViewById(R.id.ShowButton);
        noShow.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Bundle bundleEnd = new Bundle();

                endgame = findViewById(R.id.engameGroup);
                int selectedEnd = endgame.getCheckedRadioButtonId();
                final RadioButton selectedButtonEnd = findViewById(selectedEnd);
                String endLevel = selectedButtonEnd.getText().toString();


                broken = findViewById(R.id.brokenGroup);
                int selectedBroken = broken.getCheckedRadioButtonId();
                final RadioButton selectedButtonBroken = findViewById(selectedBroken);
                String brokenLevel = selectedButtonBroken.getText().toString();


                defense = findViewById(R.id.defenseGroup);
                int selectedDefense = defense.getCheckedRadioButtonId();
                final RadioButton selectedButtonDefense = findViewById(selectedDefense);
                String defenseLevel = selectedButtonDefense.getText().toString();

                stuck = findViewById(R.id.stuckGroup);
                int selectedStuck = stuck.getCheckedRadioButtonId();
                final RadioButton selectedButtonStuck = findViewById(selectedStuck);
                String stuckLevel = selectedButtonStuck.getText().toString();


                bundleEnd.putString("End Level", endLevel);
                bundleEnd.putString("Defense", defenseLevel);
                bundleEnd.putString("Broken", brokenLevel);
                bundleEnd.putString("Stuck", stuckLevel);

                String FILENAME = bundleMain.getString("Event") + "_" + tablet + ".csv";
                String entry =
                        bundleMain.getString("Event") + ","
                                + bundleMain.getInt("Robot") + ","
                                + bundleMain.getInt("Match") + ","
                                + bundleMain.getString("Name") + ","

                                + bundleAuto.getInt("aInnerPortScore") + ","
                                + bundleAuto.getInt("aOuterPortScore") + ","
                                + bundleAuto.getInt("aBottomPortScore") + ","
                                + bundleAuto.getInt("aGroundCollect") + ","
                                + bundleAuto.getInt("aLoadingBayCollect") + ","
                                + bundleAuto.getInt("aMissed") + ","
                                + bundleAuto.getString("crossed") + ","

                                + bundleTeleop.getInt("tInnerPortScore") + ","
                                + bundleTeleop.getInt("tOuterPortScore") + ","
                                + bundleTeleop.getInt("tBottomPortScore") + ","
                                + bundleTeleop.getInt("tGroundCollect") + ","
                                + bundleTeleop.getInt("tBayCollect") + ","
                                + bundleTeleop.getInt("tMissed") + ","
                                + bundleTeleop.getBoolean("RotationControl") + ","
                                + bundleTeleop.getBoolean("PositionControl") + ","

                                + bundleEnd.getString("End Level") + ","
                                + bundleEnd.getString("Defense") + ","
                                + bundleEnd.getString("Broken") +","
                                + bundleEnd.getString("Stuck") + ","

                                + "NO SHOW" + ","
                                + tablet
                                + System.lineSeparator();

                try {
                    File file = new File(Environment.getExternalStorageDirectory(), "InfiniteRecharge");
                    file.mkdirs();

                    File matchData = new File(file, FILENAME);
                    if (!matchData.exists()) {
                        matchData.createNewFile();
                    }

                    FileOutputStream os = new FileOutputStream(matchData, true);
                    os.write(entry.getBytes());
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                int match = (bundleMain.getInt("Match"));
                int nextMatchNumber = match + 1;

                String nextScouter = bundleMain.getString("Name");

                Bundle bundleNext = new Bundle();
                bundleNext.putInt("New Match", nextMatchNumber);
                bundleNext.putString("New Name", nextScouter);
                bundleNext.putString("entryNext", entry);

                Intent intent = new Intent (EndActivity.this, MainActivity.class);
                intent.putExtras(bundleNext);
                startActivity(intent);

            }
        });

        Button save = findViewById(R.id.submitButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleEnd = new Bundle();

                endgame = findViewById(R.id.engameGroup);
                int selectedEnd = endgame.getCheckedRadioButtonId();
                final RadioButton selectedButtonEnd = findViewById(selectedEnd);
                String endLevel = selectedButtonEnd.getText().toString();


                broken = findViewById(R.id.brokenGroup);
                int selectedBroken = broken.getCheckedRadioButtonId();
                final RadioButton selectedButtonBroken = findViewById(selectedBroken);
                String brokenLevel = selectedButtonBroken.getText().toString();


                defense = findViewById(R.id.defenseGroup);
                int selectedDefense = defense.getCheckedRadioButtonId();
                final RadioButton selectedButtonDefense = findViewById(selectedDefense);
                String defenseLevel = selectedButtonDefense.getText().toString();

                stuck = findViewById(R.id.stuckGroup);
                int selectedStuck = stuck.getCheckedRadioButtonId();
                final RadioButton selectedButtonStuck = findViewById(selectedStuck);
                String stuckLevel = selectedButtonStuck.getText().toString();


                bundleEnd.putString("End Level", endLevel);
                bundleEnd.putString("Defense", defenseLevel);
                bundleEnd.putString("Broken", brokenLevel);
                bundleEnd.putString("Stuck", stuckLevel);

                String FILENAME = bundleMain.getString("Event") + "_" + tablet + ".csv";
                String entry =

                        bundleMain.getString("Event") + ","
                                + bundleMain.getInt("Robot") + ","
                                + bundleMain.getInt("Match") + ","
                                + bundleMain.getString("Name") + ","

                                + bundleAuto.getInt("aInnerPortScore") + ","
                                + bundleAuto.getInt("aOuterPortScore") + ","
                                + bundleAuto.getInt("aBottomPortScore") + ","
                                + bundleAuto.getInt("aGroundCollect") + ","
                                + bundleAuto.getInt("aLoadingBayCollect") + ","
                                + bundleAuto.getInt("aMissed") + ","
                                + bundleAuto.getString("crossed") + ","

                                + bundleTeleop.getInt("tInnerPortScore") + ","
                                + bundleTeleop.getInt("tOuterPortScore") + ","
                                + bundleTeleop.getInt("tBottomPortScore") + ","
                                + bundleTeleop.getInt("tGroundCollect") + ","
                                + bundleTeleop.getInt("tBayCollect") + ","
                                + bundleTeleop.getInt("tMissed") + ","
                                + bundleTeleop.getBoolean("RotationControl") + ","
                                + bundleTeleop.getBoolean("PositionControl") + ","

                                + bundleEnd.getString("End Level") + ","
                                + bundleEnd.getString("Defense") + ","
                                + bundleEnd.getString("Broken") +","
                                + bundleEnd.getString("Stuck") + ","
                                + "SHOW" + ","
                                + tablet

                                + System.lineSeparator();

                try {
                    File file = new File(Environment.getExternalStorageDirectory(), "InfiniteRecharge");
                    file.mkdirs();

                    File matchData = new File(file, FILENAME);
                    if (!matchData.exists()) {
                        matchData.createNewFile();
                    }

                    FileOutputStream os = new FileOutputStream(matchData, true);
                    os.write(entry.getBytes());
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                int match = (bundleMain.getInt("Match"));
                int nextMatchNumber = match + 1;

                String nextScouter = bundleMain.getString("Name");

                Bundle bundleNext = new Bundle();
                bundleNext.putInt("New Match", nextMatchNumber);
                bundleNext.putString("New Name", nextScouter);
                bundleNext.putString("entryNext", entry);

                Intent intent = new Intent (EndActivity.this, MainActivity.class);
                intent.putExtras(bundleNext);
                startActivity(intent);
            }
        });
    }
}