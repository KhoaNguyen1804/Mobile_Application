package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class PersonalFragment extends Fragment {
    private Button logoutbtn;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_personal, container, false);
        init(view);

        logoutbtn = view.findViewById(R.id.logout_btn);
        TextView t=view.findViewById(R.id.thu);
        TextView tm=view.findViewById(R.id.thumail);

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