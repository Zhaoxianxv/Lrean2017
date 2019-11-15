package com.zxx.base.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import com.google.gson.Gson;

import com.zxx.base.App;
import com.zxx.lrean2017.R;
import com.zxx.view.SQToolBar;


import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Daniel on 2016/3/8.
 * <p/>
 * 说明：
 * 1、封裝Toolbar，我參考了v4.Toolbar, 重写写了一个Toolbar(SQToolbar类)，用法很简单。
 * <p/>
 * 2、封装了ProgressDialog的显示和隐藏
 * <p/>
 * 3、重写了setContentView()方法，并在里面添加ButterKnife,这样就不用在每个子Activity里调用ButterKnife.bind(this)了
 * <p/>
 * 4、还封装了onPageBack()
 * <p/>
 * 5、封装了toast()方法
 * 注：依赖： compile 'com.jakewharton:butterknife:7.0.1'
 */
public class BaseActivity extends AppCompatActivity {

    public  final static int PAGE_NUM = 10;/**常量页码：一页大小*/

    protected ProgressDialog dialog;
    protected BaseActivity mActivity;
    protected Gson gson;

    public static float mDensity = 0;
    public static int mScreenWidth = 0;
    public static int mScreenHeight = 0;



    @Nullable
    @Bind(R.id.sq_toolbar)
    public SQToolBar toolbar;

    /**
     * 重写onCreate，从新定义Activity的初始时的生命周期
     * <p/>
     * 包括：初始化变量-> 初始化控件-> 加载数据
     * 好处：职责单一
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        if (mDensity == 0) {
            initDensity();
        }

        gson=new Gson();
        App.getApp().addActivity(this);


    }






    /**
     * 全局Toast,log
     */
    Toast toast;


    protected void elog(CharSequence text){
        if (TextUtils.isEmpty(text)) {
            Log.e("zxx",""+text);
        }
    }


    protected void toast(String text) {

        toastShow(text);
    }

    protected void toast(@StringRes int resId) {
        toastShow(resId);
    }

    /**
     * 尽量使用onPageBack()方法来销毁页面，不要直接调用finish()，
     * 这种方式的好处有2种：1、方便添加退出动画。2、方便做Umeng统计。
     */
    public void onPageBack() {
        finish();
    }


    public void closeKeyWord() {
        /** 隐藏软键盘 **/
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputManger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        onWindowFocusChanged(false);
    }

    public void showKeyWord() {
        /** 弹出软键盘 **/
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示一个ProgressDialog
     */
    protected void showProgressDialog(String title, String message) {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
        }
        dialog.setCancelable(false);
        if (title != null && !title.equals("")) {
            dialog.setTitle(title);
        }
        if (message != null && !message.equals("")) {
            dialog.setMessage(message);
        }
        dialog.show();
    }

    protected void showProgressDialog(String message) {
        showProgressDialog(null, message);
    }
    /**
     * 隐藏一个ProgressDialog
     */
    protected void dismissProgressDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //初始化 ButterKnife
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        //初始化 ButterKnife
        ButterKnife.bind(this);
    }

    public void onResume() {
        super.onResume();
        toolbar= (SQToolBar) findViewById(R.id.sq_toolbar);

    }

    public void onPause() {
        super.onPause();


    }

    /**
     * 保存Subscription對象到compositeSubscription里面，
     * 当Activity销毁的时候，会在onDestory()方法调用 compositeSubscription.unsubscribe();
     */
//    public void addToCompositeSubscription(Subscription s) {
//        compositeSubscription.add(s);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
//        BusProvider.getBusInstance().unregister(this);
//        compositeSubscription.unsubscribe();
    }

    protected int getFlag() {
        return this.hashCode();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onPageBack();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    public  void mDialog(@StringRes int details, OnClickListener okListener){
        mDialog(getResources().getString(details),okListener);
    }
    public  void mDialog(String details, OnClickListener okListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setMessage(details);
        builder.setTitle("提示");
        builder.setPositiveButton(R.string.app_ok, okListener);
        builder.setNegativeButton(R.string.app_cancel, new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
    /**
     * 判断是否有权限
     * ContextCompat.checkSelfPermission（）检查权限
     *      PackageManager.PERMISSION_GRANTED     已授权
     *      PackageManager.PERMISSION_DENIED      未授权
     */
    private String premission="";
    //
    private DialogInterface.OnClickListener premissonok= new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            requestCameraPermission(premission);
        }
    };
    public boolean isPermission(String permisson){
        this.premission=permisson;
        if(( ActivityCompat.checkSelfPermission(this, permisson) == PackageManager.PERMISSION_GRANTED)) {
            return true;
        } else {
            mDialog(getString(R.string.add_preission),premissonok);
            return false;
        }
    }
    private static final int REQUEST_PERMISSION_CAMERA_CODE = 1;
    public void requestCameraPermission(String permisson) {
        ActivityCompat.requestPermissions(this,new String[]{permisson}, REQUEST_PERMISSION_CAMERA_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CAMERA_CODE) {
            int grantResult = grantResults[0];
            boolean is = grantResult == PackageManager.PERMISSION_GRANTED;
            if(is){
                toast("权限受理成功");
            }else{
                toast("受理权限失败");
            }
        }
    }


    public void toastShow(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    public void toastShow(int text) {
        toastShow(mActivity.getString(text).toString());
    }



    protected void setOnClickListener(Activity listener, View... views) {
        for (int i = 0; i < views.length; i++) {
            views[i].setOnClickListener((View.OnClickListener) listener);
        }
    }

    protected void setOnClickListener(Activity listener, int... resIds) {
        for (int i = 0; i < resIds.length; i++) {
            findViewById(resIds[i]).setOnClickListener((View.OnClickListener) listener);
        }
    }

    protected void setOnClickListener(View.OnClickListener listener, View... views) {
        for (int i = 0; i < views.length; i++) {
            views[i].setOnClickListener( listener);
        }
    }
    protected void setOnClickListener(View.OnClickListener listener, int... resIds) {
        for (int i = 0; i < resIds.length; i++) {
            findViewById(resIds[i]).setOnClickListener(listener);
        }
    }



    /**
     * 获取屏幕密度、宽高等信息
     */
    private void initDensity() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        mDensity = dm.density;
        mScreenWidth = dm.widthPixels;
        mScreenHeight = dm.heightPixels;
    }


    /**
     * 复制粘贴
     */
    public static void copy(String content, Context context)
    {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        // 创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText("Label", content);
        // 将ClipData内容放到系统剪贴板里。
        cm.setPrimaryClip(mClipData);
    }
}
