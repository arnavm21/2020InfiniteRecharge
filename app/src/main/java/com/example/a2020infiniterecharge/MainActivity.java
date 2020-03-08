package com.example.a2020infiniterecharge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText matchN;
    public EditText nameN;
    public TextView eventN;
    public int robot;

    Integer[] robotN = {58, 95, 125, 238, 509, 1058, 1073, 1153, 1289, 1474, 1721, 1761, 1965, 2084, 2423, 2713, 2876, 3323, 3451, 3467, 3930, 4169, 4311,
    4473, 4761, 4796, 4906, 4929, 5422, 5459, 5556, 5563, 5735, 5752, 5813, 5962, 6762, 7674, 7795, 7822};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this,android.R.layout.select_dialog_singlechoice, robotN);
        AutoCompleteTextView acTextView = findViewById(R.id.robotNumber);
        acTextView.setThreshold(1);
        acTextView.setAdapter(adapter);

        //change event from here
        String string = "North_Shore";

        matchN = findViewById(R.id.editMatch);
        nameN = findViewById(R.id.editName);
        eventN = findViewById(R.id.eventView);
        final Bundle bundleNext = getIntent().getExtras();

        if (bundleNext != null) {
            matchN.setText(String.valueOf(bundleNext.getInt("New Match")));
            nameN.setText(bundleNext.getString("New Name"));
        }
        eventN.setText(string);

        Button startButton = findViewById(R.id.buttonStart);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView Name = findViewById(R.id.editName);
                String name = Name.getText().toString();
                final TextView Event = findViewById(R.id.eventView);
                String event = Event.getText().toString();
                int match = Integer.parseInt(((TextView) findViewById(R.id.editMatch)).getText().toString());
                int robot = Integer.parseInt(((TextView) findViewById(R.id.robotNumber)).getText().toString());

                Bundle bundleMain = new Bundle();
                bundleMain.putInt("Robot", robot);
                bundleMain.putInt("Match", match);
                bundleMain.putString("Name", name);
                bundleMain.putString("Event", event);

                Intent intentMain = new Intent(MainActivity.this, AutoActivity.class);
                intentMain.putExtras(bundleMain);
                startActivity(intentMain);
            }
        });
    }
}
