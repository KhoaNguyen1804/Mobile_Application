package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class blogpage extends AppCompatActivity implements View.OnClickListener{
    Button button,button2;
    TextView textView,text2;
    ImageView v,v2;
    LinearLayout l,l2;
    Integer visi= View.GONE;
    Boolean firstime= Boolean.TRUE;
    RequestQueue thequeue;
    ImageRequest ima1,ima2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogpage);
        l= findViewById(R.id.Num1Blog);
        l2=findViewById(R.id.Num2Blog);
        l.setVisibility(visi);
        l2.setVisibility(visi);
        button=findViewById(R.id.submit);
        button2=findViewById(R.id.submit2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        textView=findViewById(R.id.display);
        text2=findViewById(R.id.display2);
        v=findViewById(R.id.logo);
        v2=findViewById(R.id.logo2);
        //String url="";
        thequeue = Volley.newRequestQueue(blogpage.this);
        Response.Listener<Bitmap> lis1 =
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {

                        v.setImageBitmap(response);
                    }
                };
        ImageRequest imageRequest = new ImageRequest(
                "https://blog.bluecare.vn/wp-content/uploads/2020/09/cham-soc-nguoi-cao-tuoi-Bluecare.jpg",
                //       url,
                lis1, 0, 0, ImageView.ScaleType.CENTER,
                Bitmap.Config.ARGB_8888,null);
        ima1=imageRequest;
        Response.Listener<Bitmap> lis2 =
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {

                        v2.setImageBitmap(response);
                    }
                };
// a simple request to the required image
        ImageRequest imageRequest2 = new ImageRequest(
                "https://songmanhkhoe.vn/wp-content/uploads/2020/05/thua-can-beo-phi.jpg",
                //       url,
                lis2, 0, 0, ImageView.ScaleType.CENTER,
                Bitmap.Config.ARGB_8888,null);
        ima2=imageRequest2;
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.submit:
                mymethod(l,button,ima1,v);
                break;
            //        url="https://www.sunmate.com.vn/images/GOB/cach-cham-soc-nguoi-cao-tuoi-tai-nha-1.jpg";
            //        button=findViewById(R.id.submit);
            //        v=findViewById(R.id.logo);
            //        lm=l;
            //             textView.setText(R.string.app_name);
            case R.id.submit2:
                mymethod(l2,button2,ima2,v2);
                //        url="https://www.prudential.com.vn/export/sites/prudential-vn/vi/.thu-vien/hinh-anh/pulse-nhip-song-khoe/song-khoe/2022/8-bi-quyet-cham-soc-suc-khoe-gia-dinh-thau-hieu-va-hanh-dong-1200x800-1.jpg";
                //        button=findViewById(R.id.submit2);
                //        v=findViewById(R.id.logo2);
                //        lm=l2;
                //             text2.setText(R.string.app_name);
                break;
            //         default:
            //             throw new RuntimeException("Unknown button ID");
            //     }

            //        Uri uri = Uri.parse("https://nubest.vn/nhay-day-tang-chieu-cao-dung-cach"); // missing 'http://' will cause crashed
            //        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //        startActivity(intent);
        }
    }
    public void mymethod(LinearLayout lm, Button button, ImageRequest i,ImageView v){

        if (firstime) {
            thequeue.add(i);
            visi = View.VISIBLE;
            lm.setVisibility(visi);
            button.setText(R.string.Showless);
            firstime = Boolean.FALSE;
        } else {
            if (visi == View.VISIBLE) {
                visi = View.GONE;
                lm.setVisibility(visi);
                button.setText(R.string.SendButton);

            } else {
                visi = View.VISIBLE;
                lm.setVisibility(visi);
                button.setText(R.string.Showless);
            }
        }

    }
}