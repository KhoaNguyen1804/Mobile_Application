package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    TextView email;
    EditText password_reset, repassword_reset;
    Button form_btn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        email = findViewById(R.id.email);
        password_reset = findViewById(R.id.password_reset);
        repassword_reset = findViewById(R.id.repassword_reset);
        form_btn = findViewById(R.id.form_btn);
        db = new DBHelper(this);

        Intent intent = getIntent();
        email.setText(intent.getStringExtra("email"));

        form_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = email.getText().toString();
                String pass = password_reset.getText().toString();
                String repass = repassword_reset.getText().toString();
                if (pass.equals(repass)){
                    Boolean check_pass_update = db.updatepassword(useremail, pass);
                    if (check_pass_update == true) {
                        Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent1);
                        Toast.makeText(ResetActivity.this, "Password Reset Successfully !!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ResetActivity.this, "Password Not Reset", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ResetActivity.this, "Password Not Matched", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
