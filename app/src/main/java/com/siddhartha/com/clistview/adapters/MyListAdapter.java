package com.siddhartha.com.clistview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.siddhartha.com.clistview.R;
import com.siddhartha.com.clistview.bean.Items;

import java.util.ArrayList;

/**
 * Created by BLUEHORSE DEVLOPER on 6/29/2015.
 */
public class MyListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Items> arrayList;
    private LayoutInflater inflater;

    public MyListAdapter(Context context, ArrayList<Items> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Items getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = convertView;
        if(rootView==null)
        {
            rootView = inflater.inflate(R.layout.list_layout,parent,false);

            ItemHolder itemHolder = new ItemHolder();
            itemHolder.names = (TextView)rootView.findViewById(R.id.txt_me);
            itemHolder.img = (ImageView)rootView.findViewById(R.id.imageButton);

            rootView.setTag(itemHolder);
        }

ItemHolder myItemHolder = (ItemHolder)rootView.getTag();
        myItemHolder.names.setText(arrayList.get(position).getNames());

        return rootView;
    }

    private class ItemHolder
    {
        TextView names;
        ImageView img;
    }
}
