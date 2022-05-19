package com.example.namelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.namelist.models.Name;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private ArrayList<Name> namesList;
    private String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namesList = Name.getNameList();
        names = Name.getNames();

        showNameStartFragment();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Name name = namesList.get(position);

        Bundle args = new Bundle();
        args.putSerializable("name", name);

        NameDetailsFragment outputFragment = new NameDetailsFragment();
        outputFragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frgContainerView, outputFragment)
                .commit();
    }

    @Override
    public void onClick(View view) {
        showNameStartFragment();
    }

    private void showNameStartFragment() {
        Bundle args = new Bundle();
        args.putSerializable("names", names);

        NameStartFragment startFragment = new NameStartFragment();
        startFragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frgContainerView, startFragment)
                .commit();
    }
}