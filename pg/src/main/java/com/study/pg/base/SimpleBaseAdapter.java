package com.study.pg.base;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adventurer on 16-11-20.
 */

public abstract class SimpleBaseAdapter<T> extends BaseAdapter{

    protected Context c;
    protected LayoutInflater layoutInflater;
    protected List<T> datas = new ArrayList<T>();

    public SimpleBaseAdapter(Context c,List<T> datas){
        this.c = c;
        layoutInflater = LayoutInflater.from(c);
        this.datas = datas;
    }

    /**
     * 刷新适配器数据
     *
     * @param datas
     */
    public void refereshDatas(List<T> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return datas != null ? datas.get(i) : null;
    }
    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public abstract View getView(int i, View view, ViewGroup viewGroup);

}
