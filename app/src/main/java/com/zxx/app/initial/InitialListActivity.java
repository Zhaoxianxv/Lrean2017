package com.zxx.app.initial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zxx.app.initial.adapter.InitialAdapter;
import com.zxx.lrean2017.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitialListActivity extends AppCompatActivity {

    private ListView list;
    private InitialAdapter adapter;

    private List<Map<String,Object>> activitys=new  ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_list);

        initView();
        initSQToolbar();
        initData();
    }
    @Override
    public void finish() {
        super.finish();
        activitys.clear();
    }


    private void initData() {
        addItmeActivity(activitys,"引导页面说明",InitialDetailsActivity.class);
        addItmeActivity(activitys,"主题Style配置引导界面",WindowBackgrunpActivity.class);


        adapter.setActivitys(activitys);
    }
    private void addItmeActivity( List<Map<String,Object>> activitys,String name,Class<?> obj){
        addItmeActivity(activitys,name,new Intent(this,obj));
    }
    private void addItmeActivity( List<Map<String,Object>> activitys,String name,Intent intent) {
        Map<String, Object> activity=new HashMap<>();
        activity.put("title",name);
        activity.put("intent",intent);
        activitys.add(activity);
    }

    private void initSQToolbar() {

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
    }
}
