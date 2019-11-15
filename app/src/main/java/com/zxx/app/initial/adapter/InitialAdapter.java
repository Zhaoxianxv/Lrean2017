package com.zxx.app.initial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zxx.lrean2017.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/6.
 */
public class InitialAdapter extends BaseAdapter {

    private LayoutInflater infater;
    private Context context;


    private List<Map<String,Object>> activitys=new ArrayList<>();


    public void setActivitys(List<Map<String, Object>> activitys) {
        this.activitys = activitys;
        notifyDataSetChanged();
    }

    public InitialAdapter(Context context) {
        this.context=context;
        infater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return activitys.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=infater.inflate(R.layout.initial_adp_list_item,null);
            holder.title=(TextView) convertView.findViewById(R.id.initial_list_item_title);

            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }


        holder.title.setText((String) activitys.get(position).get("title"));
        return convertView;
    }

    class ViewHolder{
        TextView title;

    }
}
