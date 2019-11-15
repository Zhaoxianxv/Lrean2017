package com.zxx.lrean2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.zxx.app.DialogListActivity;
import com.zxx.app.banner.BannerActivity;
import com.zxx.app.drawableBg.DrawableBgActivity;
import com.zxx.app.material_design.MaterailMainActivity;
import com.zxx.app.vote.VoteListActivity;
import com.zxx.app.initial.InitialListActivity;
import com.zxx.app.newlistshow.NewLIstActivity;
import com.zxx.timeTool.TimeChoiceActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
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
        addItem(activitys, "引导界面 ：initial", InitialListActivity.class);
        addItem(activitys, "新闻展示界面 ：newlistshow", NewLIstActivity.class);
        addItem(activitys, "投票 ：单选·多选·输入类容", VoteListActivity.class);
        addItem(activitys, "drawable文件，控件:各种图形,背景", DrawableBgActivity.class);
        addItem(activitys, "banner：buttom String +point", BannerActivity.class);
        addItem(activitys, "CoordinatorLayout：", com.zxx.app.material_design.MainActivity.class);
        addItem(activitys, "DrawerLayout：", com.zxx.app.material_design.MaterailMainActivity.class);
        addItem(activitys, "上传单张多张图片：", com.zxx.app.material_design.MaterailMainActivity.class);
        addItem(activitys, "dialog：", DialogListActivity.class);
        addItem(activitys, "时间选择器：", TimeChoiceActivity.class);
        return activitys;
    }

    public void addItem(
            List<Map<String,Object>> activitys,
            String text,
            Class<?> obj )
    {
        addItem(activitys, text, new Intent(this,obj));

    }


    protected void addItem(List<Map<String, Object>> data,
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
