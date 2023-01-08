package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    CameraFragment cameraFragment = new CameraFragment();
    BlogFragment blogFragment = new BlogFragment();
    NotificationFragment notificationFragment = new NotificationFragment();
    PersonalFragment personalFragment = new PersonalFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,cameraFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.camera:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,cameraFragment).commit();
                        return true;

                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,notificationFragment).commit();
                        return true;
                    case R.id.blog:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,blogFragment).commit();
                        return true;
                    case R.id.personal:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,personalFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}
