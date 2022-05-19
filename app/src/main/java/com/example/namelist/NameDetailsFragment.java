package com.example.namelist;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.namelist.models.Name;

public class NameDetailsFragment extends Fragment {
    private Name name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_details, null);

        if (getArguments() != null) {
            name = (Name) getArguments().getSerializable("name");
        }

        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtBirthdayDate = view.findViewById(R.id.txtBirthdayDate);
        TextView txtMeaning = view.findViewById(R.id.txtMeaning);

        if (name != null) {
            txtName.setText(name.getName());
            txtBirthdayDate.setText("Дати іменин: " + name.getBirthdayDate());
            txtMeaning.setText(name.getMeaning());
            txtMeaning.setMovementMethod(new ScrollingMovementMethod());
        }

        Button btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener((MainActivity) this.getActivity());

        return view;
    }
}