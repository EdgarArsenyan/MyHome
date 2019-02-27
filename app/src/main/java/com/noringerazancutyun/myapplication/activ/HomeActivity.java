package com.noringerazancutyun.myapplication.activ;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.noringerazancutyun.myapplication.R;
import com.noringerazancutyun.myapplication.fragment.HomeUserFragment;
import com.noringerazancutyun.myapplication.fragment.MapFragment;
import com.noringerazancutyun.myapplication.fragment.FavoritListFragment;
import com.noringerazancutyun.myapplication.fragment.UserMainHomeFragment;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "EmailPassword";
    EmailPasswordActivity mAgent = new EmailPasswordActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MapFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.map:
                    selectedFragment = new MapFragment();

                    break;
                case R.id.navigation_home:
                    if(mAgent.user!=null){
                        selectedFragment = new UserMainHomeFragment();

                    }else {
                        selectedFragment = new HomeUserFragment();

                    }
                break;

                case R.id.favorite:
                    selectedFragment = new FavoritListFragment();
                break;

                case R.id.navigation_notifications:
                    selectedFragment = new MapFragment();
                break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.add_item:
                Intent intent = new Intent(HomeActivity.this, AddActivity.class);
                startActivity(intent);
                break;

            case R.id.search_item:
                Intent intent1 = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}