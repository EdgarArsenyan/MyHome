package com.noringerazancutyun.myapplication.activ;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.noringerazancutyun.myapplication.R;

public class AddActivity extends AppCompatActivity {
    EditText descText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        descText = findViewById(R.id.desc_edit);
        descText.setSelectAllOnFocus(true);



        Spinner categorySpiner = findViewById(R.id.category_spiner);
        Spinner typeSpinner = findViewById(R.id.type_spiner);
        Spinner roomSpinner = findViewById(R.id.room_spinner);
        Spinner floorSpinner = findViewById(R.id.floor_spinner);
        Spinner locationSpinner = findViewById(R.id.location_spinner);

        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,R.array.category, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this,R.array.type, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> roomAdapter = ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> floorAdapter = ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> locationAdaptewr = ArrayAdapter.createFromResource(this,R.array.location, android.R.layout.simple_spinner_item);

        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationAdaptewr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        categorySpiner.setAdapter(categoryAdapter);
        typeSpinner.setAdapter(typeAdapter);
        roomSpinner.setAdapter(roomAdapter);
        floorSpinner.setAdapter(floorAdapter);
        locationSpinner.setAdapter(locationAdaptewr);

        categorySpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                ((TextView) parent.getChildAt(0)).setTextSize(12);
                String text = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                ((TextView) parent.getChildAt(0)).setTextSize(12);
                String text = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        roomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                ((TextView) parent.getChildAt(0)).setTextSize(12);
                String text = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        floorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                ((TextView) parent.getChildAt(0)).setTextSize(12);
                String text = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                ((TextView) parent.getChildAt(0)).setTextSize(12);
                String text = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
