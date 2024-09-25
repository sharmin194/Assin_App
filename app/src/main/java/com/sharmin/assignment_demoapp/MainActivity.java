package com.sharmin.assignment_demoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox milkCheckBox,sugarCheckBox,waterCheckBox;
    private Button showButton;
    private TextView resultTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        milkCheckBox = (CheckBox) findViewById(R.id.milkCheckBoxID);
        sugarCheckBox = (CheckBox) findViewById(R.id.SugarCheckBoxID);
        waterCheckBox = (CheckBox) findViewById(R.id.WaterCheckBoxID);

        showButton = (Button) findViewById(R.id.ShowButtonId);
        resultTextView = (TextView) findViewById(R.id.resultTextViewId);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder stringBuilder = new StringBuilder();

                if(milkCheckBox.isChecked()){
                    String value = milkCheckBox.getText().toString();
                    stringBuilder.append(value + " is ordered "+"\n");
                }
                if(sugarCheckBox.isChecked()){
                    String value = sugarCheckBox.getText().toString();
                    stringBuilder.append(value + " is ordered "+"\n");
                }
                if(waterCheckBox.isChecked()){
                    String value = waterCheckBox.getText().toString();
                    stringBuilder.append(value + " is ordered "+"\n");
                }
                resultTextView.setText(stringBuilder);

            }
        });
    }
}