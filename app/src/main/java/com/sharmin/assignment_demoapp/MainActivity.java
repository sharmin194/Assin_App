package com.sharmin.assignment_demoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox milkCheckBox, sugarCheckBox, waterCheckBox;
    private Button showCheckBoxButton, showRadioButton;
    private TextView checkBoxResultTextView, radioResultTextView;
    private RadioGroup radioGroup;
    private RadioButton courseButton;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private Switch notificationSwitch;
    private TextView seekBarValueTextView, switchResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CheckBoxes er id initialize
        milkCheckBox = findViewById(R.id.milkCheckBoxID);
        sugarCheckBox = findViewById(R.id.SugarCheckBoxID);
        waterCheckBox = findViewById(R.id.WaterCheckBoxID);

        // Buttons er id initialize
        showCheckBoxButton = findViewById(R.id.ShowCheckBoxButtonId);
        showRadioButton = findViewById(R.id.ShowRadioButtonId);

        // TextViews er id
        checkBoxResultTextView = findViewById(R.id.checkBoxResultTextViewId);
        radioResultTextView = findViewById(R.id.radioResultTextViewId);
        seekBarValueTextView = findViewById(R.id.seekBarValueId);
        switchResultTextView = findViewById(R.id.switchResultTextViewId);

        //  RadioGroup er id initialize
        radioGroup = findViewById(R.id.radioGroupId);

        // RatingBar er id initialize
        ratingBar = findViewById(R.id.ratingBarId);

        // SeekBar
        seekBar = findViewById(R.id.seekBarId);

        //  Switch
        notificationSwitch = findViewById(R.id.switchId);

        // CheckBox Button Click
        showCheckBoxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                if (milkCheckBox.isChecked()) {
                    result.append("Milk is ordered.\n");
                }
                if (sugarCheckBox.isChecked()) {
                    result.append("Sugar is ordered.\n");
                }
                if (waterCheckBox.isChecked()) {
                    result.append("Water is ordered.\n");
                }
                checkBoxResultTextView.setText(result.toString());
            }
        });

        // RadioButton Click portion
        showRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    courseButton = findViewById(selectedId);
                    String language = courseButton.getText().toString();
                    radioResultTextView.setText("You prefer: " + language);
                } else {
                    radioResultTextView.setText("Please select a language.");
                }
            }
        });

        // RatingBar Change Listener
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                radioResultTextView.setText("Rating: " + rating);
            }
        });

        // SeekBar Change Listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValueTextView.setText("Brightness: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Switch Listener
        notificationSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                switchResultTextView.setText("Notifications Enabled");
            } else {
                switchResultTextView.setText("Notifications Disabled");
            }
        });
    }
}
