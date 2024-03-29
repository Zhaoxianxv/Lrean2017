package com.zxx.app.drawableBg.widget;

import android.os.Bundle;

import com.zxx.base.activity.BaseActivity;
import com.zxx.lrean2017.R;

/**
 *
 【A】stateUnspecified：软键盘的状态并没有指定，系统将选择一个合适的状态或依赖于主题的设置
 【B】stateUnchanged：当这个activity出现时，软键盘将一直保持在上一个activity里的状态，无论是隐藏还是显示
 【C】stateHidden：用户选择activity时，软键盘总是被隐藏
 【D】stateAlwaysHidden：当该Activity主窗口获取焦点时，软键盘也总是被隐藏的
 【E】stateVisible：软键盘通常是可见的
 【F】stateAlwaysVisible：用户选择activity时，软键盘总是显示的状态
 【G】adjustUnspecified：默认设置，通常由系统自行决定是隐藏还是显示
 【H】adjustResize：该Activity总是调整屏幕的大小以便留出软键盘的空间
 【I】adjustPan：当前窗口的内容将自动移动以便当前焦点从不被键盘覆盖和用户能总是看到输入内容的部分
 */

public class EditTextActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_edit_main);
    }
}
