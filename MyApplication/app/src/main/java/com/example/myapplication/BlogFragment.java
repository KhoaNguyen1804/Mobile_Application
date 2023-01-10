package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class BlogFragment extends Fragment {

    public void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_blog, container, false);
        Integer visi= View.GONE;
        Boolean firstime= Boolean.TRUE;
        LinearLayout l= v.findViewById(R.id.Num1Blog);
        LinearLayout l2= v.findViewById(R.id.Num2Blog);
        l.setVisibility(visi);
        l2.setVisibility(visi);
        Button button=v.findViewById(R.id.submit);
        Button button2=v.findViewById(R.id.submit2);

        TextView textView=v.findViewById(R.id.display);
        TextView text2=v.findViewById(R.id.display2);
        ImageView v1=v.findViewById(R.id.logo);
        RequestQueue thequeue = Volley.newRequestQueue(getActivity());
        Response.Listener<Bitmap> listener2 =
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {

                        v1.setImageBitmap(response);
                    }
                };
        ImageRequest imageRequest2 = new ImageRequest(
                "https://songmanhkhoe.vn/wp-content/uploads/2020/05/thua-can-beo-phi.jpg",
                //       url,
                listener2, 0, 0, ImageView.ScaleType.CENTER,
                Bitmap.Config.ARGB_8888,null);
        ImageRequest ima2=imageRequest2;
        return v;

    }
}