package com.zxx.tools;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Administrator on 2017/6/10.
 */
public abstract class ZxTextWatcher implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
