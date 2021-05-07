package com.example.ClimbingGradeConverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String conversionChoice;
    String gradeChoice;
    int gradeIndex;
    String[] hueco = new String[] {"VB","V0", "V1", "V2", "V3" , "V4", "V5", "V6", "V7", "V8","V9","V10", "V11", "V12", "V13", "V14", "V15", "V16", "V17" };
    String[] font = new String[] { "3", "4",  "5",   "5+","6A/6A+","6B/6B+","6C/6C+","7A","7A+","7B/7B+","7B+/7C","7C+","8A","8A+","8B","8B+","8C","8C+","9A"};
    String[] YDS = new String [] {"5","5.1/5.2","5.3/5.4","5.5","5.6","5.7","5.8","5.9","5.10a","5.10b","5.10c","5.10d","5.11a","5.11b","5.11c","5.11d","5.12a","5.12b","5.12c","5.12d","5.13a","5.13b","5.13c","5.13d","5.14a","5.14b","5.14c","5.14d","5.15a","5.15b","5.15c","5.15d"};
    String[] french = new String[] {"1","2","3","4a","4b","4c","5a","5b","5c","6a","6a+","6b","6b+","6c","6c+","7a","7a+","7b","7b+","7c","7c+","8a","8a+","8b","8b+","8c","8c+","9a","9a+","9b","9b+","9c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner type = (Spinner)findViewById(R.id.type);
        final Spinner conversion = (Spinner)findViewById(R.id.conversion);
        final Spinner grade = (Spinner)findViewById(R.id.grade);
        final TextView result = ((TextView) findViewById(R.id.txtResult));
        final


        Button convert = (Button)findViewById(R.id.btnCost);

        ArrayAdapter<CharSequence> adapterBouldering = ArrayAdapter.createFromResource(this, R.array.txtGroupBouldering, android.R.layout.simple_spinner_item);
        adapterBouldering.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterRoute = ArrayAdapter.createFromResource(this, R.array.txtGroupRoute, android.R.layout.simple_spinner_item);
        adapterBouldering.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterHueco = ArrayAdapter.createFromResource(this, R.array.txtHueco, android.R.layout.simple_spinner_item);
        adapterBouldering.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterFont = ArrayAdapter.createFromResource(this, R.array.txtFont, android.R.layout.simple_spinner_item);
        adapterBouldering.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterFrench = ArrayAdapter.createFromResource(this, R.array.txtFrench, android.R.layout.simple_spinner_item);
        adapterBouldering.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterYDS = ArrayAdapter.createFromResource(this, R.array.txtYDS, android.R.layout.simple_spinner_item);
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

        conversion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedValue = parentView.getSelectedItem().toString();


                if (selectedValue.equals("Hueco to Fontainebleau")){
                    grade.setAdapter(adapterHueco);
                }

                if (selectedValue.equals("Fontainebleau to Hueco")){
                    grade.setAdapter(adapterFont);
                }

                if (selectedValue.equals("YDS to French")){
                    grade.setAdapter(adapterYDS);
                }

                if (selectedValue.equals("French to YDS")){
                    grade.setAdapter(adapterFrench);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        grade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedValue = parentView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        convert.setOnClickListener(new View.OnClickListener(){
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v){
                conversionChoice = conversion.getSelectedItem().toString();
                gradeChoice = grade.getSelectedItem().toString();
                gradeIndex=  grade.getSelectedItemPosition();

                if (conversionChoice.equals("Hueco to Fontainebleau")){
                    result.setText(hueco[gradeIndex] + " Hueco is " + font[gradeIndex] + " in Fontainebleau");
                } else if (conversionChoice.equals("Fontainebleau to Hueco")) {
                    result.setText(font[gradeIndex] + " Fontainebleau is " + hueco[gradeIndex] + " in Hueco");
                } else if (conversionChoice.equals("YDS to French")){
                    result.setText(YDS[gradeIndex] + " YDS is "  + french[gradeIndex] + " in French");
                } else if (conversionChoice.equals("French to YDS")){
                    result.setText( french[gradeIndex] + " French is " +  YDS[gradeIndex] + " in YDS");
                }
            }
        });
    }
}