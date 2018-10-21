 package com.samsvindland.ergtrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sam on 5/24/2017.
 */

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Piece> arrayList;
    private int activity;

    private class ViewHolder {
        TextView topLine;
        TextView bottomLine;
    }

    public CustomAdapter(Context context, ArrayList<Piece> arrayList, int activity) {
        super();
        inflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = inflater.inflate(R.layout.activity_listview, null);
        }

        TextView topLine = (TextView)view.findViewById(R.id.line1);
        TextView bottomLine = (TextView)view.findViewById(R.id.line2);

        topLine.setText(arrayList.get(i).topLine());
        bottomLine.setText(arrayList.get(i).bottomLine());

        return view;

    }
}
