package com.zxx.app.bitmap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.zxx.app.drawableBg.OrthogonActivity;
import com.zxx.app.drawableBg.widget.ButtomActivity;
import com.zxx.app.drawableBg.widget.EditTextActivity;
import com.zxx.app.drawableBg.widget.ImageViewActivity;
import com.zxx.app.drawableBg.widget.ListViewActivity;
import com.zxx.base.activity.BaseActivity;
import com.zxx.lrean2017.R;
import com.zxx.xlist.xlist.XListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

public class BitmapActivity extends BaseActivity {
    @Bind(R.id.drawable_main_xlist)
    XListView xlist;

    private  List<Map<String,Object>> activitys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_bg_main);
        initView();
    }

    private void initView() {

        xlist.setPullRefreshEnable(false);
        xlist.setPullLoadEnable(false);
        SimpleAdapter adapter=new SimpleAdapter(
                this,
                getData(),
                R.layout.activity_main_adp_item,
                new String[]{"title"},
                new int[]{R.id.simple_text}
        );
        xlist.setAdapter(adapter);
        xlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity((Intent) activitys.get(position-1).get("intent"));
            }
        });
    }
    public List<Map<String,Object>> getData(){
        activitys= new ArrayList<>();

        addItem(activitys, "矩形，orthogonactivity", OrthogonActivity.class);
        addItem(activitys, "widget，edittext 输入框", EditTextActivity.class);
        addItem(activitys, "widget，buttom 按钮", ButtomActivity.class);
        addItem(activitys, "widget，iamgeView 按钮", ImageViewActivity.class);
        addItem(activitys, "widget，listview 调array", ListViewActivity.class);
        return activitys;
    }

    public void addItem(
            List<Map<String,Object>> activitys,
            String text,
            Class<?> obj ) {
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

}
