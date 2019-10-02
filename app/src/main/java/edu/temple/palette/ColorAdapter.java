package edu.temple.palette;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    Context context;
    String colors[];

    public ColorAdapter(Context context, String[] colors) {
        this.context = context;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;
        if (convertView instanceof TextView)
            textView = (TextView) convertView;
        else
            textView = new TextView(context);

        textView.setText(colors[position]);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(32);
        if (position == 0)
            textView.setBackgroundColor(000000);
        else
            textView.setBackgroundColor(Color.parseColor(colors[position]));

        return textView;
    }
}
