package com.zxx.app.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.zxx.lrean2017.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewListActivity extends AppCompatActivity {
    private  List<Map<String,Object>> activitys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list= (ListView) findViewById(R.id.index_activity_list);
        SimpleAdapter adapter=new SimpleAdapter(
                this,
                getData(),
                R.layout.activity_main_adp_item,
                new String[]{"title"},
                new int[]{R.id.simple_text}
        );
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity((Intent) activitys.get(position).get("intent"));
            }
        });
    }

    public List<Map<String,Object>> getData(){
        activitys= new ArrayList<>();


//        addItem(activitys, "viewpager+fragment+recyclerView的使用", DomePagerActivity.class);


        return activitys;
    }

    public void addItem(
            List<Map<String,Object>> activitys,
            String text,
            Class<?> obj )
    {
        addItem(activitys, text, new Intent(this,obj));

    }


    protected void addItem(
            List<Map<String, Object>> data,
            String name,
            Intent intent )
    {
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("title", name);
        temp.put("intent", intent);
        data.add(temp);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        return super.onKeyDown(keyCode, event);
    }
}
