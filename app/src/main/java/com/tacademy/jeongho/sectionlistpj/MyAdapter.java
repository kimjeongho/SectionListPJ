package com.tacademy.jeongho.sectionlistpj;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2016-01-22.
 */
public class MyAdapter extends BaseAdapter {
   ArrayList<GroupData> items = new ArrayList<GroupData>();
    private static final int VIEW_TYPE_COUNT = 2;
    private static final int VIEW_TYPE_GROUP = 0;
    private static final int VIEW_TYPE_CHILD = 1;

    public void add(GroupData data){
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        GroupData data = items.get(position);
        if(data instanceof GroupItem){
            return VIEW_TYPE_GROUP;
        } else if(data instanceof ChildItem){
            return VIEW_TYPE_CHILD;}
        else return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_GROUP: {
                GroupView view;
                if(convertView != null && convertView instanceof GroupView) {
                    view = (GroupView)convertView;
                } else {
                    view = new GroupView(parent.getContext());
                }
                view.setGroupItem((GroupItem)items.get(position));
                return view;
            }
            case VIEW_TYPE_CHILD:
            default:{
                ChildView view;
                if(convertView != null && convertView instanceof GroupView) {
                    view = (ChildView)convertView;
                } else {
                    view  = new ChildView(parent.getContext());
                }
                view.setChildItem((ChildItem)items.get(position));
                return view;
            }
        }
    }
}
