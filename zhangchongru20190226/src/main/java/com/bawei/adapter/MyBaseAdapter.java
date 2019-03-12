package com.bawei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bean.Shop;
import com.bawei.zhangchongru.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/2/26 9:30
 * @Description:xListView适配器  加载不同条目数据
 */
public class MyBaseAdapter extends BaseAdapter {
    private List<Shop> list;
    private Context context;

    public MyBaseAdapter(List<Shop> list, Context context) {
        this.list = list;
        this.context = context;
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
    public int getItemViewType(int position) {
        return position%3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)){
            case 0:
                ViewHolder1 holder1;
                if (convertView == null){
                    convertView = View.inflate(context, R.layout.item_layout1,null);
                    holder1 = new ViewHolder1();
                    holder1.text1 = convertView.findViewById(R.id.text1);
                    holder1.image1 = convertView.findViewById(R.id.image1);
                    convertView.setTag(holder1);
                }else {
                    holder1 = (ViewHolder1) convertView.getTag();
                }
                holder1.text1.setText(list.get(position).getCommodityName());
                Glide.with(context).load(list.get(position).getMasterPic()).into(holder1.image1);
                break;
            case 1:
                ViewHolder2 holder2;
                if (convertView == null){
                    convertView = View.inflate(context, R.layout.item_layout2,null);
                    holder2 = new ViewHolder2();
                    holder2.text2 = convertView.findViewById(R.id.text2);
                    holder2.image2 = convertView.findViewById(R.id.image2);
                    convertView.setTag(holder2);
                }else {
                    holder2 = (ViewHolder2) convertView.getTag();
                }
                holder2.text2.setText(list.get(position).getCommodityName());
                Glide.with(context).load(list.get(position).getMasterPic()).into(holder2.image2);
                break;
            case 2:
                ViewHolder3 holder3;
                if (convertView == null){
                    convertView = View.inflate(context, R.layout.item_layout3,null);
                    holder3 = new ViewHolder3();
                    holder3.text3 = convertView.findViewById(R.id.text3);
                    holder3.image3 = convertView.findViewById(R.id.image3);
                    convertView.setTag(holder3);
                }else {
                    holder3 = (ViewHolder3) convertView.getTag();
                }
                holder3.text3.setText(list.get(position).getCommodityName());
                Glide.with(context).load(list.get(position).getMasterPic()).into(holder3.image3);
                break;
        }
        return convertView;
    }
    class ViewHolder1{
        ImageView image1;
        TextView text1;
    }
    class ViewHolder2{
        ImageView image2;
        TextView text2;
    }
    class ViewHolder3{
        ImageView image3;
        TextView text3;
    }

}
