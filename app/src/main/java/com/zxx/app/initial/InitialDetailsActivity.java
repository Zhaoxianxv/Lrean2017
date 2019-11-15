package com.zxx.app.initial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.zxx.lrean2017.R;

public class InitialDetailsActivity extends AppCompatActivity {

    private TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_details);
        initSQToolbar();
        initView();
    }

    private void initView() {
        details= (TextView) findViewById(R.id.initial_details_tv);
        details.setText("sss");

    }

    private void initSQToolbar() {

    }
}
