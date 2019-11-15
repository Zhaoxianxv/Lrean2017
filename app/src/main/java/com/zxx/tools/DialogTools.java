package com.zxx.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import com.zxx.base.activity.BaseActivity;
import com.zxx.lrean2017.R;

import org.w3c.dom.Text;


/**
 * Created by yfyandr on 2017/9/25.
 */

public class DialogTools {

    public static DialogTools dialogTools;
    private Activity mActivity;
    private static String ok_String="确定";
    private static String cancle_String="取消";

    public static DialogInterface.OnClickListener cancel=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    };
    public static DialogInterface.OnClickListener ok=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    };



    public  AlertDialog.Builder getBuider(Activity mActivity, String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle(title);
        return builder;
    }


    private DialogTools(Activity mActivity) {
        this.mActivity=mActivity;
    }

    public static DialogTools getInstance(Activity mActivity) {

        if (dialogTools == null) {
            dialogTools = new DialogTools(mActivity);
        }
        return dialogTools;
    }
    /**
     * 对话框
     * @param details
     * @param okListener
     */
    public void mDialog(Activity mActivity,String title,@StringRes int details, DialogInterface.OnClickListener okListener){
        mDialog(mActivity,title,mActivity.getResources().getString(details),okListener);
    }
    public static void mDialog(Activity mActivity, String title, String details, DialogInterface.OnClickListener okListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setMessage(details);
        builder.setTitle(title);
        builder.setPositiveButton(ok_String, okListener);
        builder.setNegativeButton(cancle_String, cancel);
        builder.create().show();
    }

    /**
     * 单选列表对话框
     * @param mActivity
     * @param title
     * @param sex
     * @param okListener 选中监听
     */
    public static void mSingleChioceDialog(
            Activity mActivity,
            String title,
            String[] sex,
            DialogInterface.OnClickListener okListener)
    {
        AlertDialog.Builder single = new AlertDialog.Builder(mActivity);
        single.setTitle(title);
        //    设置一个单项选择下拉框
        /**
         * 第一个参数指定我们要显示的一组下拉单选框的数据集合
         * 第二个参数代表索引，指定默认哪一个单选框被勾选上，
         * 第三个参数给每一个单选项绑定一个监听器
         */
        single.setSingleChoiceItems(sex, -1, okListener);
        single.show();
    }


    /**
     * view dialog
     * @param mActivity
     * @param view
     * @param title
     * @param okListener
     */
    public void  mViewTextDialog(
            Activity mActivity,
            View view,
            String title,
            String ok,
            DialogInterface.OnClickListener okListener)
    {
        AlertDialog.Builder builder_view = new AlertDialog.Builder(mActivity);
        builder_view.setTitle(title);
        builder_view.setIcon(android.R.drawable.ic_dialog_info);
        builder_view.setView(view);
        if (okListener!=null){
            builder_view.setPositiveButton(ok,okListener);
            builder_view .setNegativeButton(cancle_String, cancel);
        }
        builder_view.show();
    }
    public void  mViewTextDialog(
            Activity mActivity,
            View view,
            String title){

    }


    /**
     * 多选列表
     * @param mActivity
     * @param title
     * @param sex
     * @param okListener
     */

    public static void mMultiChoiceDialog(
            Activity mActivity,
            String title,
            String[] sex,
            DialogInterface.OnMultiChoiceClickListener multiListenner,
            DialogInterface.OnClickListener okListener,
            String positive,
            String negative)
    {
        if (positive==null|positive.equals("")){
            positive=ok_String;
        }
        if (negative==null|negative.equals("")){
            negative=cancle_String;
        }
        AlertDialog.Builder multi=new AlertDialog.Builder(mActivity);
        multi .setTitle(title);
        multi .setIcon(android.R.drawable.ic_dialog_info);
        if (multiListenner!=null){
            multi.setMultiChoiceItems(sex, null,multiListenner);
        }
        if (okListener!=null){
            multi.setPositiveButton(positive, okListener);
        }else{
            multi.setPositiveButton(positive, ok);
        }
        multi .setNegativeButton(negative, cancel);
        multi.show();
    }
    public static void mMultiChoiceDialog(Activity mActivity, String title, String[] sex) {
        mMultiChoiceDialog(mActivity,title,sex,null,null,null,null);
    }
    public void mMultiChoiceDialog(
            Activity mActivity,
            String title,
            String[] sex,
            DialogInterface.OnMultiChoiceClickListener multiListenner) {
        mMultiChoiceDialog(mActivity,title,sex,multiListenner,null,null,null);
    }
    public void mMultiChoiceDialog(
            Activity mActivity,
            String title,
            String[] sex,
            DialogInterface.OnClickListener okListener) {
        mMultiChoiceDialog(mActivity,title,sex,null,okListener,null,null);
    }


    /**
     *
     * @param mActivity
     * @param title
     * @param okListener
     */

    public static void mItemsDialog(final Activity mActivity, String title, DialogInterface.OnClickListener okListener) {
        AlertDialog.Builder items=new AlertDialog.Builder(mActivity);
        items.setTitle(title);
        items.setItems(R.array.title, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                CharSequence strDialogBody=mActivity.getString(R.string.app_name);
                String[] it = mActivity.getResources().getStringArray(R.array.title);
                new AlertDialog.Builder(mActivity)
                        .setMessage(strDialogBody + it[which])
                        .setNeutralButton(R.string.app_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                //在这里做要处理的事情
                            }
                        }).show();
            }
        });
        items.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                //在这里做要处理的事情
            }
        });
        items.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        items.show();
    }

}
