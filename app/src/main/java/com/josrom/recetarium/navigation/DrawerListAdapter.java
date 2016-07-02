package com.josrom.recetarium.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.josrom.recetarium.R;

import java.util.List;

public class DrawerListAdapter extends ArrayAdapter {
    public DrawerListAdapter(Context context, List objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.navigation_drawer_item, null);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        TextView text = (TextView) convertView.findViewById(R.id.text);

        DrawerItem item = (DrawerItem) getItem(position);
        icon.setImageResource(item.getIcon());
        text.setText(item.getText());

        return convertView;
    }
}
