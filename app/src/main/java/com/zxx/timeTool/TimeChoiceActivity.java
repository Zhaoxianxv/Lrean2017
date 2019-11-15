package com.zxx.timeTool;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.zxx.lrean2017.R;

public class TimeChoiceActivity extends Activity {

    private static final String TAG = "zxx";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_choice);
        PickerView view= (PickerView) findViewById(R.id.ssss);
        view.setSelected(1);
        view.setOnSelectListener(new PickerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                Log.e(TAG, "onSelect: "+text );
            }
        });
    }
}
