package com.example.namelist;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

public class NameStartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_start, null);

        try {
            String[] names = (String[]) getArguments().getSerializable("names");

            NameAdapter adapterName = new NameAdapter(this.getContext(), names);

            GridView gridViewNameList = view.findViewById(R.id.gridViewNameList);
            gridViewNameList.setAdapter(adapterName);
            gridViewNameList.setOnItemClickListener((MainActivity) this.getActivity());
        } catch (Exception ex) {
            Log.e("Щось пішло не так...", ex.getMessage());
        }

        return view;
    }
}
