package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditAccount extends AppCompatActivity {
    TextView t,e,p,ph;
    DBHelper db;
    EditText e2,e3;
    Button b1,b2,b3,b4;
    User u;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        t=findViewById(R.id.accountname);
        e2=findViewById(R.id.editpass);
        e3=findViewById(R.id.editemail);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        e=findViewById(R.id.accountemail);
        p=findViewById(R.id.accountpassword);
        ph=findViewById(R.id.accountphonenumber);
        db=new DBHelper(this);
        c=db.getdata();
        if(c!=null) {
            c.moveToFirst();
             u = new User(c.getString(0), c.getString(1), c.getString(2),c.getString(3));
            t.setText(u.getName());
            e2.setHint(u.getPassword());
            e3.setHint(u.getEmail());
            e.setText(u.getEmail());
            p.setText(u.getPassword());
            ph.setText(u.getPhonenumber());
            Toast.makeText(EditAccount.this,u.getEmail(),Toast.LENGTH_SHORT).show();
            //db.QueryData("UPDATE users SET email='"+u.getEmail()+"'WHERE email='"""');
            // t2.setText(u.email);
        }
        else{
            t.setText("Fail vl");
        }
        b1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(EditAccount.this,"Nội dung chưa đc nhập",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        b2.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String mail="thanhcong";
                        String pass2=e2.getText().toString().trim();
                        if(TextUtils.isEmpty(pass2)){
                            Toast.makeText(EditAccount.this,"Nội dung chưa đc nhập",Toast.LENGTH_SHORT).show();
                            return;

                        }
                        db.QueryData("UPDATE users SET email='"+pass2+"'WHERE email='"+e2.getHint().toString().trim()+"'");
                        Toast.makeText(EditAccount.this,"Update thành công",Toast.LENGTH_SHORT).show();

                    }
                }
        );
        b3.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        String pass3 =e3.getText().toString().trim();
                        String email="";
                        if(TextUtils.isEmpty(pass3)){
                            Toast.makeText(EditAccount.this,"Nội dung chưa đc nhập",Toast.LENGTH_SHORT).show();
                            return;

                        }
                        db.QueryData("UPDATE users SET password='"+pass3+"'WHERE email='"+e2.getHint().toString().trim()+"'");
                        Toast.makeText(EditAccount.this,e3.getText().toString().trim(),Toast.LENGTH_SHORT).show();


                    }
                }
        );




    }

}