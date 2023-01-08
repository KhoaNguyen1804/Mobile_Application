package vn.edu.usth.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AccountPage extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5;
    DBHelper db;
    TextView t;
    EditText email,pass,name,phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        name=findViewById(R.id.name);
        phonenumber=findViewById(R.id.phonenumber);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        t=findViewById(R.id.display);
       // t2=findViewById(R.id.accountname);
        db=new DBHelper(this);
        //String i=db.insertData("kien02","thetiphu");
        //t.setText(i);
        //Cursor data = db.getdata();
        //while (data.moveToNext()){
        //    String text=data.getString(1);
        //    t.setText(text);

        //}

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b1:
            //    startActivity(new Intent(this,EditAccount.class));
                String emailTXT=email.getText().toString();
                String passTXT=pass.getText().toString();
                String nameTXT=name.getText().toString();
                String phoneTXT=phonenumber.getText().toString();
                Boolean checkInsertData=db.insertData(emailTXT,passTXT,nameTXT,phoneTXT);
                if(checkInsertData==true)
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b2:
                startActivity(new Intent(this,Help.class));
                break;
            case R.id.b3:
                Cursor c=db.getdata();
                if(c!=null) {
                    c.moveToFirst();
                    User u = new User(c.getString(0), c.getString(1),c.getString(2),c.getString(3));
                    t.setText(u.email);
                   // t2.setText(u.email);
                }
                else{
                    t.setText("Fail vl");
                    }
                break;
            case R.id.b4:
                startActivity(new Intent(this,EditAccount.class));
                break;







        }


    }
}