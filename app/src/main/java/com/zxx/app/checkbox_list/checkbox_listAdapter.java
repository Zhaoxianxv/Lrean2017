package com.zxx.app.checkbox_list;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import com.zxx.lrean2017.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/3/18.
 */
public class checkbox_listAdapter extends BaseAdapter{

    List<Infor> list=new ArrayList<>();

    private Context context;
    Inflater inflater;

    public checkbox_listAdapter(Context context,List<Infor> list) {
        this.list = list;
        this.context = context;

    }

    @Override
    public int getCount() {
        return list.size();
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
        Viewholder viewholder;
        if (convertView==null){
            viewholder=new Viewholder();
            convertView= LayoutInflater.from(context).inflate(R.layout.check_list_group,null);

            viewholder.content= (TextView) convertView.findViewById(R.id.group_textx);
            viewholder.child= (ListView) convertView.findViewById(R.id.item_child);
            convertView.setTag(viewholder);
        }else{
            viewholder= (Viewholder) convertView.getTag();
        }



        ItemChildCheckBoxAdapter adapterc = null;

        if (adapterc==null){

            adapterc=new ItemChildCheckBoxAdapter(list.get(position).getBean());
            viewholder.child.setAdapter(adapterc);
        }else{
            adapterc= (ItemChildCheckBoxAdapter) viewholder.child.getAdapter();
            adapterc.setItem(list.get(position).getBean());
        }



        viewholder.content.setText(list.get(position).getGrup_content());
        return convertView;
    }


    class Viewholder{

        ListView child;
        TextView content;
    }
    class ViewholderChild{

        CheckBox box;
        TextView content;
    }



    class ItemChildCheckBoxAdapter extends BaseAdapter{

        private List<Bean> item;

        public void setItem(List<Bean> item) {
            this.item = item;
            notifyDataSetChanged();
        }

        public ItemChildCheckBoxAdapter(List<Bean> item) {
            if (item==null)return;
            this.item=item;
        }

        @Override
        public int getCount() {
            return item.size();

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
            ViewholderChild viewholder;
            Log.e("zxx","child"+item.size());
            if (convertView==null){
                viewholder=new ViewholderChild();
                convertView= LayoutInflater.from(context).inflate(R.layout.item,null);

                viewholder.content= (TextView) convertView.findViewById(R.id.conent);
                viewholder.box= (CheckBox) convertView.findViewById(R.id.checkbox);
                convertView.setTag(viewholder);
            }else{
                viewholder= (ViewholderChild) convertView.getTag();
            }
            viewholder.content.setText(item.get(position).getContent());
            return convertView;
        }
    }
}
