package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button signinbtn;
    EditText email, password;
    DBHelper DB;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signinbtn = (Button) findViewById(R.id.signinbtn);
        TextView btn = findViewById(R.id.signup);
        TextView btn1 = findViewById(R.id.forgotpassword);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signinbtn = (Button) findViewById(R.id.signinbtn);
        DB = new DBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class) );
            }
        });

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = email.getText().toString();
                String pass = password.getText().toString();

                if(useremail.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkuseremailpassword(useremail, pass);
                    if(checkuserpass==true) {
                        Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        //Bundle bundle = new Bundle();
                        //String myMessage = "Stackoverflow is cool!";
                        //bundle.putString("message", useremail );
                        //PersonalFragment fragInfo = new PersonalFragment();
                        //fragInfo.setArguments(bundle);
                        //FragmentTransaction transaction = fragmentManager.beginTransaction();
                        //transaction.replace(R.id.fragment_single, fragInfo);
                        //transaction.commit();
                        //Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        Intent intent  = new Intent(LoginActivity.this, MainActivity.class);

                        intent.putExtra("user-email",useremail);
                        intent.putExtra("pass",pass);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}