package com.bawei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bean.ResultsBean;
import com.bawei.zcr.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/2/28 20:01
 * @Description:
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<ResultsBean> list;

    public MyAdapter(Context context, List<ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item_listview,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image);
            holder.textView = convertView.findViewById(R.id.textview);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getNews_id());
        Glide.with(context).load(list.get(position).getPic_url()).into(holder.imageView);
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
