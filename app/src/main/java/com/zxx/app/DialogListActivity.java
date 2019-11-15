package com.zxx.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.zxx.base.activity.BaseActivity;
import com.zxx.lrean2017.R;
import com.zxx.tools.DialogTools;

import butterknife.OnClick;

public class DialogListActivity extends BaseActivity {

    private static final String TAG = "zxx";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_list);
    }


    @OnClick(R.id.dialog1)
    void setDialog1(){
        DialogTools.mDialog(mActivity,"title","details", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }
    @OnClick(R.id.dialog2)
    void setDialog2(){
        final EditText edit=new EditText(mActivity);
//        DialogTools.mViewTextDialog(mActivity,edit,"title", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//               toast(""+edit.getText().toString().trim());
//                dialogInterface.dismiss();
//            }
//        });
    }
    @OnClick(R.id.dialog3)
    void setDialog3(){
        final String[] ss=new String[]{"sss","qqqq","ffff"};
        DialogTools.mSingleChioceDialog(mActivity,"title",ss, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                toast(""+ss[i].toString().trim());
                dialogInterface.dismiss();
            }
        });
    }
    @OnClick(R.id.dialog4)
    void setDialog4(){
        final String[] ss=new String[]{"sss","qqqq","ffff"};
        DialogTools.mMultiChoiceDialog(mActivity,"title",ss);
    }
    @OnClick(R.id.dialog5)
    void setDialog5(){

        DialogTools.mItemsDialog(mActivity,"title",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        } );
    }
}
