package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
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
    Bundle b;
    FragmentTransaction f;
    PersonalFragment fragInfo;
    Fragment perfrac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i=getIntent();                                  //
        String useremail=i.getStringExtra("user-email");  // ĐỔI CHỖ 3 DÒNG CODE NÀY XUỐNG PHẦN ONCREATE MỚI ĐC , NẾU DÙNG INTENT Ở CÁI LOGIN MÀ Ở CÁI MAIN
        String pass=i.getStringExtra("pass");            //  KO ĐẢO 3 DÒNG NÀY XUỐNG DƯỚI THÌ CŨNG KHÔNG ĐC

        //transaction.replace(R.id.person, fragInfo,null);
        //transaction.commit();

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
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,personalFragment).commit();
                        FragmentManager fm=getSupportFragmentManager();
                        androidx.fragment.app.FragmentTransaction ft=fm.beginTransaction();
                        Bundle b=new Bundle();
                        b.putString("useremail",useremail);
                        b.putString("pass",pass);
                        PersonalFragment pf=new PersonalFragment();
                        pf.setArguments(b);
                        ft.replace(R.id.container,pf).commit();
                        return true;
                }
                return false;
            }
        });
    }
}
