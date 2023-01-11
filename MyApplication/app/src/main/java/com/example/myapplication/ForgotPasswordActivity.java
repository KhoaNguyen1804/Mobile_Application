package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    DBHelper db;
    EditText email;
    Button resetbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.email);;
        resetbtn = (Button) findViewById(R.id.resetbtn);
        db = new DBHelper(this);

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = email.getText().toString();
                Boolean checkuseremailphone = db.checkuseremailphone(useremail);
                if (checkuseremailphone==true){
                    Intent intent = new Intent(getApplicationContext(), ResetPasswordActivity.class);
                    intent.putExtra("email", useremail);
                    startActivity(intent);
                } else {
                    Toast.makeText(ForgotPasswordActivity.this, "Email not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
