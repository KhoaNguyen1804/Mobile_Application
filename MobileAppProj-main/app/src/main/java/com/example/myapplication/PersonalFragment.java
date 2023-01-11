package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PersonalFragment extends Fragment {
    private Button logoutbtn,edit;
    AppCompatButton btnzalopay;

    private String amount = "10000";
    private String fee = "0";
    int environment = 0;//developer default
    private String merchantName = "payment";
    private String merchantCode = "SCB01";
    private String merchantNameLabel = "LamNguyen";
    private String description = "Get";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        init(view);
        TextView t=view.findViewById(R.id.thu);
        TextView tm=view.findViewById(R.id.thumail);
        edit = view.findViewById(R.id.edit_account_btn);
        logoutbtn = view.findViewById(R.id.logout_btn);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditAccountActivity.class);
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
        return view;
    }
    private void init(View view) {
        logoutbtn = view.findViewById(R.id.logout_btn);
    }

}