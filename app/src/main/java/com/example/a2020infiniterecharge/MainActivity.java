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
    public EditText eventN;
    public int robot;

    Integer[] robotN = {61, 78, 157, 166, 173, 181, 190, 316, 348, 1027, 1100, 1153,
            1350, 1735, 1740, 1991, 2064, 2067, 2170, 2262, 2370, 2590, 2877, 3182,
            3555, 3623, 3719, 4987, 5112, 5347, 5491, 5746, 6328, 6723, 6811, 7153,
            7266, 7760, 8013};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this,android.R.layout.select_dialog_singlechoice, robotN);
        AutoCompleteTextView acTextView = findViewById(R.id.robotNumber);
        acTextView.setThreshold(1);
        acTextView.setAdapter(adapter);

        //change event from here
        String string = "Northern CT";

        matchN = findViewById(R.id.editMatch);
        nameN = findViewById(R.id.editName);
        eventN = findViewById(R.id.editEvent);
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
                final TextView Event = findViewById(R.id.editEvent);
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
