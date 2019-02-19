package com.noringerazancutyun.myapplication.activ;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.noringerazancutyun.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.location, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimary));
                ((TextView) parent.getChildAt(0)).setTextSize(20);
                String text = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ImageView searchImage = findViewById(R.id.search_image);
        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (SearchActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }
}
//android.widget.Spinner spinner;
//    List<String> list;
//    ArrayAdapter<String> SpinnerAdapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//        spinner = (android.widget.Spinner) findViewById(R.id.spinner);
//        list = new ArrayList<String>(); // List of Items
//        list.add("Select your favorite city");
//        list.add("Mumbai");
//        list.add("Kolkata");
//        list.add("Delhi");
//        list.add("Goa");
//        list.add("Bengaluru");
//        list.add("Hyderabad");
//        list.add("Ahmedabad");
//
//        SpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list){
//            public View getView(int position, View convertView,
//                                ViewGroup parent) {
//                View v = super.getView(position, convertView, parent);
//                ((android.widget.TextView) v).setTextColor(Color.parseColor("#FFC107"));
//                return v;
//            }
//            public View getDropDownView(int position, View convertView,
//                                        ViewGroup parent) {
//                View v = super.getDropDownView(position, convertView,
//                        parent);
//                v.setBackgroundColor(getResources().getColor(R.color.t));
//                ((android.widget.TextView) v).setTextColor(Color.parseColor("#FFC107"));
//                return v;
//            }
//        };
//        SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(SpinnerAdapter);  // Set Adapter in the spinner
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                String state = parentView.getItemAtPosition(position).toString(); // selected item in the list
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parentView) {
//
//            }
//        });
//    }
//}