package edu.haverford.cs.squirrelfacts;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * TODO: Implement all of this...
 */



public class SquirrelListAdapter extends BaseAdapter implements ListAdapter {

    private SquirrelList mList;
    private Context context;


    public SquirrelListAdapter(Context context, SquirrelList sl) {
        super();
        mList = sl;
    }

    @Override
    public boolean areAllItemsEnabled() {
        for(int i = 0; i<this.getCount(); i++) {
            if(isEnabled(i)==false){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEnabled(int i) {
        if (i != 0) {
            if (mList.getItem(i)!=null) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }


    }


    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        mList.addObserver(dataSetObserver);
        return;
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

        mList.removeObserver(dataSetObserver);
        return;
    }

    @Override
    public int getCount() {

        return mList.size();
    }

    @Override
    public Squirrel getItem(int i) {
        return mList.getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        return view;
    }


    @Override
    public int getItemViewType(int i) {
        return (i == this.getCount() - 1) ? 1 : 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return mList.isEmpty();
    }
}
