package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class PersonalFragment extends Fragment {
    private Button logoutbtn,edit;
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
        init(v);
        edit=v.findViewById(R.id.edit_account_btn);
        logoutbtn = v.findViewById(R.id.logout_btn);
        TextView t=v.findViewById(R.id.thu);
        TextView tm=v.findViewById(R.id.thumail);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PersonalFragment.class);
                startActivity(intent);
            }
        });
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

         t.setText(this.getArguments().getString("pass"));
         tm.setText(this.getArguments().getString("useremail"));
         return v;
        //####################################################
    }
    private void init(View view) {

        logoutbtn = view.findViewById(R.id.logout_btn);
        edit=view.findViewById(R.id.edit_account_btn);
    }

}