package com.zxx.app.checkbox_list;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


import com.zxx.base.activity.BaseActivity;
import com.zxx.lrean2017.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class Checkbox_ListActivity extends BaseActivity {
    @Bind(R.id.list_check_list)
    ListView listView;
    List<Infor> data=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox__list);
        initView();
    }

    private void initView() {
        for (int i=0;i<8;i++){
            Infor infoe=new Infor();
            infoe.setGrup_content("conten_"+i);
            infoe.setId("g_"+i);
            List<Bean> list=new ArrayList<>();
            for (int j=0;j<i;j++){
                Bean bean=new Bean();
                bean.setContent("p_"+j);
                bean.setId("p_id"+j);
                bean.setIsChecked("false");
                bean.setContent("c_id_"+j);
                list.add(bean);
            }
            infoe.setBean(list);
            data.add(infoe);
        }
        checkbox_listAdapter adapter=new checkbox_listAdapter(this,data);
        listView.setAdapter(adapter);
    }
}
