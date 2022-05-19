package com.example.namelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NameAdapter extends BaseAdapter {
    Context context;
    String[] names;

    LayoutInflater inflater;

    public NameAdapter(Context context, String[] names) {
        this.context = context;
        this.names = names;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.grid_name_item, null);

        TextView tvItemTitle = convertView.findViewById(R.id.txtItemName);
        tvItemTitle.setText(names[position]);

        return convertView;
    }
}
