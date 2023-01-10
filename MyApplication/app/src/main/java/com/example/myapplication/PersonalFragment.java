package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PersonalFragment extends Fragment {
    //private TextView tv;
    //String myValue = this.getArguments().getString("message");
    public PersonalFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        //init(v);

        //  tv=v.findViewById(R.id.thu);
        //   tv.setText(myValue);
        //###############################################
        View v= inflater.inflate(R.layout.fragment_personal, container, false);
        TextView t=v.findViewById(R.id.thu);
        TextView tm=v.findViewById(R.id.thumail);

         t.setText(this.getArguments().getString("pass"));
         tm.setText(this.getArguments().getString("useremail"));
         return v;
        //####################################################

    }

}