package com.zxx.app.newlistshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zxx.app.initial.InitialDetailsActivity;
import com.zxx.app.initial.WindowBackgrunpActivity;
import com.zxx.app.initial.adapter.InitialAdapter;
import com.zxx.lrean2017.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewLIstActivity extends AppCompatActivity {

    private ListView list;
    private InitialAdapter adapter;

    private List<Map<String,Object>> activitys=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_new_list);
        initData();
        initView();
    }

    private void initData() {
//        addItmeActivity(activitys,"引导页面说明",InitialDetailsActivity.class);
        addItmeActivity(activitys,"recycierView-single new ",SingleActivity.class);



    }
    private void addItmeActivity(List<Map<String,Object>> activitys, String name, Class<?> obj){
        addItmeActivity(activitys,name,new Intent(this,obj));
    }
    private void addItmeActivity( List<Map<String,Object>> activitys,String name,Intent intent) {
        Map<String, Object> activity=new HashMap<>();
        activity.put("title",name);
        activity.put("intent",intent);
        activitys.add(activity);

    }

    private void initView() {
        list= (ListView) findViewById(R.id.initial_list);
        adapter=new InitialAdapter(this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity((Intent) activitys.get(position).get("intent"));
            }
        });
        adapter.setActivitys(activitys);

    }

}
