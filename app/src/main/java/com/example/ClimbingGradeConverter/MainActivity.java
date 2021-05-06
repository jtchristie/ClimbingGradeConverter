package com.example.ClimbingGradeConverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double costPerTicket = 34;
    int gradeString;
    double totalCost;
    String groupChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText grade = (EditText)findViewById(R.id.txtGrade);
        final Spinner type = (Spinner)findViewById(R.id.type);
        final Spinner conversion = (Spinner)findViewById(R.id.conversion);
        final TextView result = ((TextView) findViewById(R.id.txtResult));



        Button cost = (Button)findViewById(R.id.btnCost);

        ArrayAdapter<CharSequence> adapterBouldering = ArrayAdapter.createFromResource(this, R.array.txtGroupBouldering, android.R.layout.simple_spinner_item);
        adapterBouldering.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterRoute = ArrayAdapter.createFromResource(this, R.array.txtGroupRoute, android.R.layout.simple_spinner_item);
        adapterBouldering.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
              String selectedValue = parentView.getSelectedItem().toString();


                if (selectedValue.equals("Bouldering")){
                    conversion.setAdapter(adapterBouldering);
                }

                if (selectedValue.equals("Route Climbing")){
                    conversion.setAdapter(adapterRoute);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        cost.setOnClickListener(new View.OnClickListener(){
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v){
                gradeString = Integer.parseInt(grade.getText().toString());
                result.setText(gradeString);

            }
        });
    }
}